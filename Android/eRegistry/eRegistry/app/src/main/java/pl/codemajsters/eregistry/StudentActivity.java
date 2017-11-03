package pl.codemajsters.eregistry;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StudentActivity extends AppCompatActivity implements
        MenuStudentFragment.MenuStudentFragmentActivityListener,
        MenuInfoFragment.MenuInfoFragmentActivityListener,
        MailFragment.MailFragmentActivityListener
{
    private View loadingView;
    private View fragmentView;
    private final FragmentManager fragmentManager = getFragmentManager();
    private Fragment currentFragment = null;
    private String token;
    private GetTask getTask = null;
    private PostTask postTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setActivity();
        setComponents();
    }

    private void setActivity()
    {
        setContentView(R.layout.activity_student);
    }

    private void setComponents()
    {
        loadingView = findViewById(R.id.progressBar);
        fragmentView = findViewById(R.id.fragmentContainer);
        Intent intent = getIntent();
        token = intent.getStringExtra("TOKEN");

        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        currentFragment = new MenuStudentFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, currentFragment);
        fragmentTransaction.commit();
    }

    private void showProgress(final Boolean show)
    {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        fragmentView.setVisibility(show ? View.GONE : View.VISIBLE);
        fragmentView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                fragmentView.setVisibility(show ? View.GONE : View.VISIBLE);
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

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        currentFragment = fragment;
        fragmentTransaction.replace(R.id.fragmentContainer, currentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void setCurrentFragment(Fragment fragment)
    {
        setFragment(fragment);
    }

    @Override
    public void setCurrentFragment(Fragment fragment, String api)
    {
        showProgress(true);
        getTask = new GetTask(api, fragment);
        getTask.execute((Void) null);
    }

    @Override
    public void sendPostData(String api, String urlParameters)
    {
        showProgress(true);
        postTask = new PostTask(api, urlParameters);
        postTask.execute((Void) null);
    }

    @Override
    public void logOut()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void setTitleBar(String title)
    {
        setTitle(title);
    }

    @Override
    public void showKeyboard(Boolean show)
    {
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

    private class GetTask extends AsyncTask<Void, Void, Boolean>
    {
        private String url;
        private Fragment fragmentToSet;

        private HashMap<String, String> responseData;
        private StringBuffer response;
        private String status;

        GetTask(String api, Fragment fragment)
        {
            url = "http://157.158.16.186:8090" + api;
            fragmentToSet = fragment;
            responseData = new HashMap<>();
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            delay(1000);
            if(isOnline())
            {
                try
                {
                    URL address = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) address.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("Authorization", token);
                    urlConnection.setRequestProperty("charset", "UTF-8");
                    urlConnection.connect();
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
                        responseData = new Gson().fromJson(response.toString(), new TypeToken<HashMap<String, String>>(){}.getType());
                        status = responseData.get("status");
                        if(status.equals("Ok"))
                        {
                            bufferedReader.close();
                            urlConnection.disconnect();
                            return true;
                        }
                        else
                        {
                            status = "error_while_download_data";
                            urlConnection.disconnect();
                            return false;
                        }
                    }
                    else
                    {
                        status = "error_connection_not_available";
                        urlConnection.disconnect();
                        return false;
                    }
                }
                catch (Exception e)
                {
                    Log.d("! EXCEPTION !", e.toString());
                }
            }
            else
            {
                status = "error_no_connection";
                return false;
            }
            return true;

        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            getTask = null;
            showProgress(false);
            if(success)
            {
                setFragment(fragmentToSet);
                Bundle bundle = new Bundle();
                bundle.putString("RESPONSE", response.toString());
                fragmentToSet.setArguments(bundle);
            }
            else
            {
                if(status.equals("error_no_connection"))
                {
                    Snackbar.make(loadingView, R.string.error_no_connection, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else if(status.equals("error_connection_not_available"))
                {
                    Snackbar.make(loadingView, R.string.error_connection_not_available, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else if(status.equals("error_while_download_data"))
                {
                    Snackbar.make(loadingView, R.string.error_while_download_data, Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
            getTask = null;
            showProgress(false);
        }
    }

    private class PostTask extends AsyncTask<Void, Void, Boolean>
    {
        private String url;
        private String parameters;
        private String status;
        private StringBuffer response;
        private Map<String, String> responseData;

        PostTask(String api, String urlParameters)
        {
            url = "http://157.158.16.186:8090" + api;
            parameters = urlParameters;
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            delay(1000);
            if(isOnline())
            {
                try
                {
                    JSONObject JSONPostData = new JSONObject(parameters);
                    URL address = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) address.openConnection();
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Authorization", token);
                    urlConnection.setRequestProperty("charset", "UTF-8");

                    OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                    writer.write(JSONPostData.toString());
                    writer.flush();
                    writer.close();

                    urlConnection.connect();
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
                        Log.d("! RESPONSE !", response.toString());
                        responseData = new Gson().fromJson(response.toString(), new TypeToken<HashMap<String, String>>(){}.getType());
                        status = responseData.get("status");
                        Log.d("! STATUS !", status);
                        if(status.equals("ok"))
                        {
                            bufferedReader.close();
                            urlConnection.disconnect();
                            return true;
                        }
                        else
                        {
                            status = "error_while_sending_data";
                            urlConnection.disconnect();
                            return false;
                        }
                    }
                    else
                    {
                        status = "error_connection_not_available";
                        urlConnection.disconnect();
                        return false;
                    }
                }
                catch (Exception e)
                {
                    Log.d("! DEBUG !", e.toString());
                }
            }
            else
            {
                status = "error_no_connection";
                return false;
            }
            return true;

        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            getTask = null;
            showProgress(false);
            if(success)
            {
                Snackbar.make(loadingView, R.string.success, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                getFragmentManager().popBackStack();
            }
            else
            {
                if(status.equals("error_no_connection"))
                {
                    Snackbar.make(loadingView, R.string.error_no_connection, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else if(status.equals("error_connection_not_available"))
                {
                    Snackbar.make(loadingView, R.string.error_connection_not_available, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else if(status.equals("error_while_sending_data"))
                {
                    Snackbar.make(loadingView, R.string.error_while_sending_data, Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
            getTask = null;
            showProgress(false);
        }
    }

    private Boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}