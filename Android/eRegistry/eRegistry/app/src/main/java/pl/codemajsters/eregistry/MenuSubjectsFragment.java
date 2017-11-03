package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuSubjectsFragment extends Fragment
{
    private View fragmentView;
    private View gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.menu_subjects, container, false);
        setComponents();
        return fragmentView;
    }

    private void setComponents()
    {
        gridView = fragmentView.findViewById(R.id.gridView);
    }
}
