package pl.codemajsters.eregistry;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TutorFragment extends Fragment
{
    private View fragmentView;
    private String response;
    private EditText name;
    private EditText surname;
    private EditText phone;
    private EditText mail;
    private FloatingActionButton phoneBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.tutor, container, false);
        setComponents();
        loadData();
        return fragmentView;
    }

    private void setComponents()
    {
        response = getArguments().getString("RESPONSE");
        name = (EditText) fragmentView.findViewById(R.id.name);
        surname = (EditText) fragmentView.findViewById(R.id.surname);
        phone = (EditText) fragmentView.findViewById(R.id.phone);
        mail = (EditText) fragmentView.findViewById(R.id.mail);
        phoneBtn = (FloatingActionButton) fragmentView.findViewById(R.id.phoneBtn);
        phoneBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //TODO: Klikając przycisk dzwoni pod numer telefonu z pola phone
            }
        });
    }

    private void loadData()
    {
        try
        {
            Data data = new Gson().fromJson(response, Data.class);
            name.setText(data.groupClass.tutorName);
            surname.setText(data.groupClass.tutorSurname);
            phone.setText(data.groupClass.tutorPhone);
            mail.setText(data.groupClass.tutorMail);
        }
        catch (Exception e)
        {
            Log.d("! EXCEPTION !", e.toString());
        }
    }

    private class Data
    {
        String status;
        GroupClass groupClass;
    }

    private class GroupClass
    {
        String name;
        String profile;
        int idTutor;
        String tutorName;
        String tutorSurname;
        String tutorPhone;
        String tutorMail;
    }
}
