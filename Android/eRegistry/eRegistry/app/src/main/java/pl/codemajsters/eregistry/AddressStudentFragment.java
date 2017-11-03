package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;

public class AddressStudentFragment extends Fragment
{
    private View fragmentView;
    private String response;
    private EditText street;
    private EditText houseNumber;
    private EditText flatNumber;
    private EditText postalCode;
    private EditText city;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.address_student, container, false);
        setComponents();
        loadData();
        return fragmentView;
    }

    private void setComponents()
    {
        response = getArguments().getString("RESPONSE");
        street = (EditText) fragmentView.findViewById(R.id.street);
        houseNumber = (EditText) fragmentView.findViewById(R.id.houseNumber);
        flatNumber = (EditText) fragmentView.findViewById(R.id.flatNumber);
        postalCode = (EditText) fragmentView.findViewById(R.id.postalCode);
        city = (EditText) fragmentView.findViewById(R.id.city);
    }

    private void loadData()
    {
        Log.d("! DEBUG !", response);
        try
        {
            Data data = new Gson().fromJson(response, Data.class);
            street.setText(data.personalData.street);
            houseNumber.setText(data.personalData.houseNumber);
            flatNumber.setText("" + data.personalData.flatNumber);
            postalCode.setText(data.personalData.postalCode);
            city.setText(data.personalData.city);
        }
        catch (Exception e)
        {
            Log.d("! EXCEPTION !", e.toString());
        }
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
}
