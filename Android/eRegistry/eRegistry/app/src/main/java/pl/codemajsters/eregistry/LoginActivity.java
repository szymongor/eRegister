package pl.codemajsters.eregistry;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity
{
    private View loadingView;
    private View signInView;
    private EditText loginEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private Button signInBtn;
    private AuthTask authTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setActivity();
        setComponents();
        // Przywraca zapamiętane dane logowania
        restoreData();
    }

    private void setActivity()
    {
        // Ustawia odpowiedni layout
        setContentView(R.layout.activity_login);
        // Ukrywa pasek z nazwą aplikacji
        getSupportActionBar().hide();
        // Ukrywa klawiaturę, która włączyłaby się sama
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void setComponents()
    {
        loadingView = findViewById(R.id.progressBar);
        signInView = findViewById(R.id.scrollView);
        loginEditText = (EditText) findViewById(R.id.login);
        passwordEditText = (EditText) findViewById(R.id.password);
        rememberMeCheckBox = (CheckBox) findViewById(R.id.rememberMe);
        signInBtn = (Button) findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showKeyboard(false);
                attemptLogin();
            }
        });
        // W klawiaturze zamiast opcji dalej pojawia się opcja wyślij
        // działająca jak przycisk signInBtn, ozpoczynająca logowanie
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                boolean handled = false;
                if(actionId == EditorInfo.IME_ACTION_SEND)
                {
                    signInBtn.performClick();
                    handled = true;
                }
                return handled;
            }
        });
    }

    private void restoreData()
    {
        // Przywraca zapamiętane dane logowania, jesli ich nie ma (pierwsze uruchomienie aplikacji)
        //  to domyślnie wstawia pusty ciąg znaków ""
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        loginEditText.setText(sharedPreferences.getString("login", ""));
        passwordEditText.setText(sharedPreferences.getString("password", ""));
        rememberMeCheckBox.setChecked(sharedPreferences.getBoolean("isChecked", false));
    }

    private void keepData()
    {
        // Jeśli zaznaczono zapamiętywanie danych to zapisuje je (wywołane dopiero po udanym logoaniu)
        if(rememberMeCheckBox.isChecked())
        {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("login", loginEditText.getText().toString());
            editor.putString("password", passwordEditText.getText().toString());
            editor.putBoolean("isChecked", rememberMeCheckBox.isChecked());
            editor.apply();
        }
        // Jeśli nie zaznaczono to nie zapamiętuje danych
        // lub jeśli nie zaznaczono a wprowadzone dane są takie same jak te uprzednio zapamiętane
        // usuwa je, żeby nie można było ich przywrócić
        else
        {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
            if(sharedPreferences.getString("login", "").equals(loginEditText.getText().toString()))
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("login", "");
                editor.putString("password", "");
                editor.putBoolean("isChecked", false);
                editor.apply();
            }
        }
    }

    private void attemptLogin()
    {
        //Rozpoczyna proces logowania jeśli wypełniono wszystkie pola
        loginEditText.setError(null);
        passwordEditText.setError(null);

        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(password))
        {
            passwordEditText.setError(getString(R.string.error_field_required));
            focusView = passwordEditText;
            cancel = true;
        }

        if (TextUtils.isEmpty(login))
        {
            loginEditText.setError(getString(R.string.error_field_required));
            focusView = loginEditText;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
            showKeyboard(true);
        }
        else
        {
            showProgress(true);
            authTask = new AuthTask(login, password);
            authTask.execute((Void) null);
        }
    }

    private void showKeyboard(Boolean show)
    {
        //Pokazuje lub ukrywa klawiaturę systemową
        if(getCurrentFocus()!=null)
        {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if(show)
            {
                inputMethodManager.showSoftInput(getCurrentFocus(), 0);
            }
            else
            {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    private void showProgress(final boolean show)
    {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        signInView.setVisibility(show ? View.GONE : View.VISIBLE);
        signInView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                signInView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        loadingView.setVisibility(show ? View.VISIBLE : View.GONE);
        loadingView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                loadingView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    private Boolean isOnline()
    {
        // Jeśli jest połączenie z internetem, zwraca true
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void delay(long time)
    {
        try
        {
            Thread.sleep(time);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private class AuthTask extends AsyncTask<Void, Void, Boolean>
    {
        private Map<String, String> postData;
        private Map<String, String> responseData;
        private StringBuffer response;
        private String status;
        private String token;

        AuthTask(String login, String password)
        {
            postData = new HashMap<>();
            postData.put("login", login);
            postData.put("password", password);
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            // Opóźnienie dla lepszego efektu
            delay(1000);
            if(isOnline())
            {
                try
                {
                    JSONObject JSONPostData = new JSONObject(postData);

                    URL url = new URL("http://157.158.16.186:8090/auth");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("charset", "UTF-8");

                    OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                    writer.write(JSONPostData.toString());
                    writer.flush();
                    writer.close();

                    int code = urlConnection.getResponseCode();

                    if(code == 200)
                    {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String inputLine;
                        response = new StringBuffer();
                        while ((inputLine = bufferedReader.readLine()) != null)
                        {
                            response.append(inputLine);
                        }
                        bufferedReader.close();
                        Log.d("! LOGIN !", response.toString());
                        responseData = new Gson().fromJson(response.toString(), new TypeToken<HashMap<String, String>>(){}.getType());
                        status = responseData.get("status");
                        token = responseData.get("token");
                        if(status.equals("Ok"))
                        {
                            bufferedReader.close();
                            urlConnection.disconnect();
                            keepData();
                            return true;
                        }
                        bufferedReader.close();
                        urlConnection.disconnect();
                    }
                    return false;
                }
                catch (Exception e)
                {
                    Log.d("! DEBUG !", e.toString());
                    return false;
                }
            }
            else
            {
                status = "error_no_connection";
                return false;
            }
        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            authTask = null;
            showProgress(false);
            if(success)
            {
                JWT jwt = new JWT(token);
                Claim claim = jwt.getClaim("roles");
                if(claim.asString().equals("STUDENT"))
                {
                    Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                    intent.putExtra("TOKEN", token);
                    finish();
                    startActivity(intent);
                }
                else if(claim.asString().equals("GUARDIAN"))
                {
                    Intent intent = new Intent(LoginActivity.this, GuardianActivity.class);
                    intent.putExtra("TOKEN", token);
                    finish();
                    startActivity(intent);
                }
                else
                {
                    status = "Unacceptable";
                }
            }
            else
            {
                if(status.equals("Security error"))
                {
                    passwordEditText.setError(getString(R.string.error_incorrect_password));
                    passwordEditText.requestFocus();
                    showKeyboard(true);
                }
                else if(status.equals("error_no_connection"))
                {
                    Snackbar.make(loadingView, R.string.error_no_connection, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else if(status.equals("Internal error"))
                {
                    loginEditText.setError((getString(R.string.account_does_not_exist)));
                    loginEditText.requestFocus();
                    showKeyboard(true);
                }
                else if(status.equals("Unacceptable"))
                {
                    Snackbar.make(loadingView, R.string.error_unacceptable_signin, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else
                {
                    Snackbar.make(loadingView, R.string.error_unlisted, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        }

        @Override
        protected void onCancelled()
        {
            authTask = null;
            showProgress(false);
        }
    }
}