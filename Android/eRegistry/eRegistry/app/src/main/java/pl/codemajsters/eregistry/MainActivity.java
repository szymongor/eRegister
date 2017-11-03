/*package pl.codemajsters.eregistry;

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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements
        MenuStudentFragment.MenuStudentFragmentActivityListener
{
    private JWT jwt;
    private String token;
    private String id;
    private boolean isStudent = false;
    private final FragmentManager fragmentManager = getFragmentManager();
    private Fragment currentFragment = null;
    private AuthTask authTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        token = intent.getStringExtra("TOKEN");
        jwt = new JWT(token);
        id = jwt.getClaim("id").asString();

        isStudent = checkIfStudent(jwt);
        if(isStudent)
        {
            setFragment(new MenuStudentFragment(), token, id, false);
        }
        else
        {
            setFragment(new MenuGuardianFragment(), token, id, false);
        }
    }

    private boolean checkIfStudent(JWT jwt)
    {
        Claim claim = jwt.getClaim("roles");

        if(claim.asString().equals("STUDENT"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void setFragment(Fragment fragment, String token, String id, boolean addToStack)
    {
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
        bundle.putString("ID", id);
        fragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        currentFragment = fragment;
        fragmentTransaction.replace(R.id.fragment_container, currentFragment);
        if(addToStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onItemSelected(Fragment fragment, String token, String id)
    {
        setFragment(fragment, token, id, true);
    }

    @Override
    public StringBuffer getData(String api, String token, String id)
    {
        authTask = new AuthTask(api, token, id);
        authTask.execute((Void) null);
        try
        {
            return authTask.get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showProgress(final View progressView, final View dataView, final boolean show)
    {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        dataView.setVisibility(show ? View.GONE : View.VISIBLE);
        dataView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                dataView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        progressView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void logOut()
    {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public Boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private class AuthTask extends AsyncTask<Void, Void, StringBuffer>
    {
        private String url;
        public StringBuffer response;

        AuthTask(String api, String token, String id)
        {
            url = "http://157.158.16.186:8090" + api;
        }

        @Override
        protected StringBuffer doInBackground(Void... params)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
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
                        InputStream inputStream = urlConnection.getInputStream();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (inputStream == null)
                        {
                            return null;
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                        String line;
                        while ((line = bufferedReader.readLine()) != null)
                        {
                            stringBuffer.append(line + "\n");
                        }

                        if (stringBuffer.length() == 0)
                        {
                            return null;
                        }
                        urlConnection.disconnect();
                        return stringBuffer;
                    }
                    urlConnection.disconnect();
                }
                catch (Exception e)
                {
                    Log.d("! DEBUG !", e.toString());
                }
            }
            else
            {
                //jjj
            }
            return null;
        }

        @Override
        protected void onPostExecute(StringBuffer res)
        {
            authTask = null;
            response = res;
        }

        @Override
        protected void onCancelled()
        {
            authTask = null;
        }
    }
}
*/