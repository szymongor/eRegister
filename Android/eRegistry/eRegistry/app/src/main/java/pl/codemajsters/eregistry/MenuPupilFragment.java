package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MenuPupilFragment extends Fragment
{
    private View fragmentView;
    private ImageButton gradesBtn;
    private ImageButton guardianBtn;
    private ImageButton infoBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.menu_pupil, container, false);
        setComponents();
        return fragmentView;
    }

    private void setComponents()
    {
        gradesBtn = (ImageButton) fragmentView.findViewById(R.id.gradesBtn);
        guardianBtn = (ImageButton) fragmentView.findViewById(R.id.guardianBtn);
        infoBtn = (ImageButton) fragmentView.findViewById(R.id.infoBtn);

        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.gradesBtn:
                        //update(new MenuSubjectsFragment(), token, id);
                        break;
                    case R.id.guardianBtn:
                        //update(new TutorFragment(), token, id);
                        break;
                    case R.id.infoBtn:
                        //update(new MenuInfoFragment(), token, id);
                        break;
                    default:
                        break;
                }
            }
        };
        gradesBtn.setOnClickListener(clickListener);
        guardianBtn.setOnClickListener(clickListener);
        infoBtn.setOnClickListener(clickListener);
    }
}
