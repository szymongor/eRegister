package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.auth0.android.jwt.JWT;

public class MenuInfoFragment extends Fragment
{
    private View fragmentView;
    private ImageButton passwordBtn;
    private ImageButton phoneBtn;
    private ImageButton mailBtn;
    private ImageButton addressBtn;
    private String token;
    private MenuInfoFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.menu_info, container, false);
        setComponents();
        setTitleBar("Menu");
        return fragmentView;
    }

    private void setComponents()
    {
        passwordBtn = (ImageButton) fragmentView.findViewById(R.id.passwordBtn);
        phoneBtn = (ImageButton) fragmentView.findViewById(R.id.phoneBtn);
        mailBtn = (ImageButton) fragmentView.findViewById(R.id.mailBtn);
        addressBtn = (ImageButton) fragmentView.findViewById(R.id.addressBtn);
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");

        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.passwordBtn:
                        setCurrentFragment(new PasswordFragment());
                        break;
                    case R.id.phoneBtn:
                        setCurrentFragment(new PhoneFragment());
                        break;
                    case R.id.mailBtn:
                        setCurrentFragment(new MailFragment(), "/People/myPersonalData");
                        break;
                    case R.id.addressBtn:
                        JWT jwt = new JWT(token);
                        if(jwt.getClaim("roles").asString().equals("STUDENT"))
                        {
                            setCurrentFragment(new AddressStudentFragment(), "/People/myPersonalData");
                        }
                        else
                        {
                            setCurrentFragment(new AddressGuardianFragment());
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        passwordBtn.setOnClickListener(clickListener);
        phoneBtn.setOnClickListener(clickListener);
        mailBtn.setOnClickListener(clickListener);
        addressBtn.setOnClickListener(clickListener);
    }

    interface MenuInfoFragmentActivityListener
    {
        void setCurrentFragment(Fragment fragment);
        void setCurrentFragment(Fragment fragment, String api);
        void logOut();
        void setTitleBar(String title);
    }

    private void setCurrentFragment(Fragment fragment)
    {
        listener.setCurrentFragment(fragment);
    }

    private void setCurrentFragment(Fragment fragment, String api)
    {
        listener.setCurrentFragment(fragment, api);
    }

    private void logOut()
    {
        listener.logOut();
    }

    private void setTitleBar(String title)
    {
        listener.setTitleBar(title);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof MenuInfoFragmentActivityListener)
        {
            listener = (MenuInfoFragmentActivityListener) context;
        }
        else
        {
            throw new ClassCastException(context.toString());
        }
    }
}
