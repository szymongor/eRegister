package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GuardianActivity extends AppCompatActivity implements
        MenuGuardianFragment.MenuGuardianFragmentActivityListener
{
    private View loadingView;
    private View fragmentView;
    private final FragmentManager fragmentManager = getFragmentManager();
    private Fragment currentFragment = null;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setActivity();
        setComponents();
    }

    private void setActivity()
    {
        setContentView(R.layout.activity_guardian);
    }

    private void setComponents()
    {
        loadingView = findViewById(R.id.progressBar);
        fragmentView = findViewById(R.id.fragmentContainer);
        Intent intent = getIntent();
        token = intent.getStringExtra("TOKEN");

        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        currentFragment = new MenuGuardianFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, currentFragment);
        fragmentTransaction.commit();
    }
}
