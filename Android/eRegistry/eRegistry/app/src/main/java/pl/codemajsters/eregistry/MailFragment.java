package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

public class MailFragment extends Fragment
{
    private View fragmentView;
    private String response;
    private EditText oldMail;
    private EditText newMail;
    private EditText password;
    private Button confirmBtn;
    private int idPerson;
    private String token;
    private MailFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.mail, container, false);
        setComponents();
        loadData();
        return fragmentView;
    }

    private void setComponents()
    {
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        response = getArguments().getString("RESPONSE");
        oldMail = (EditText) fragmentView.findViewById(R.id.oldMail);
        newMail = (EditText) fragmentView.findViewById(R.id.newMail);
        password = (EditText) fragmentView.findViewById(R.id.password);
        confirmBtn = (Button) fragmentView.findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showKeyboard(false);
                attemptMailChange();
            }
        });
        password.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                boolean handled = false;
                if(actionId == EditorInfo.IME_ACTION_SEND)
                {
                    confirmBtn.performClick();
                    handled = true;
                }
                return handled;
            }
        });
    }

    interface MailFragmentActivityListener
    {
        void showKeyboard(Boolean show);
        void sendPostData(String api, String urlParameters);
    }

    private void sendPostData(String api, String urlParameters)
    {
        listener.sendPostData(api, urlParameters);
    }

    private void showKeyboard(Boolean show)
    {
        listener.showKeyboard(show);
    }

    private void attemptMailChange()
    {
        newMail.setError(null);
        password.setError(null);

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(newMail.getText().toString()))
        {
            newMail.setError(getString(R.string.error_field_required));
            focusView = newMail;
            cancel = true;
        }

        if (TextUtils.isEmpty(password.getText().toString()))
        {
            password.setError(getString(R.string.error_field_required));
            focusView = password;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
            showKeyboard(true);
        }
        else
        {
            PostData postData = new PostData();
            postData.idPerson = idPerson;
            postData.mail = newMail.getText().toString();
            sendPostData("/People/updateMail", new Gson().toJson(postData));
            //TODO: odpalić tu metodę, która przygotuje odpowiednie body do requesta
            //TODO: napisać i odpalić tu metodę asynchronicznie wysyłającą requesta z utworzonym body (POST)
            //showProgress(true);
            //authTask = new AuthTask(login, password);
            //authTask.execute((Void) null);
        }
    }

    private void loadData()
    {
        Log.d("! DEBUG !", response);
        try
        {
            Data data = new Gson().fromJson(response, Data.class);
            oldMail.setText(data.personalData.mail);
            idPerson = data.personalData.idPerson;
        }
        catch (Exception e)
        {
            Log.d("! EXCEPTION !", e.toString());
        }
    }

    private class PostData
    {
        int idPerson;
        String mail;
    }

    private class Data
    {
        String status;
        PersonalData personalData;
    }

    private class PersonalData
    {
        int idPerson;
        String name;
        String surname;
        String dateOfBirth;
        String sex;
        String phone;
        String mail;
        String expirationDate;
        int idAddress;
        String street;
        String houseNumber;
        int flatNumber;
        String postalCode;
        String city;
        String country;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof MailFragmentActivityListener)
        {
            listener = (MailFragmentActivityListener) context;
        }
        else
        {
            throw new ClassCastException(context.toString());
        }
    }
}
