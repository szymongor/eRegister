package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MenuGuardianFragment extends Fragment
{
    private View fragmentView;
    private ImageButton infoBtn;
    private ImageButton pupilBtn;
    private ImageButton logOutBtn;
    private MenuGuardianFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.menu_guardian, container, false);
        setComponents();
        return fragmentView;
    }

    private void setComponents()
    {
        infoBtn = (ImageButton) fragmentView.findViewById(R.id.infoBtn);
        pupilBtn = (ImageButton) fragmentView.findViewById(R.id.pupilBtn);
        logOutBtn = (ImageButton) fragmentView.findViewById(R.id.logOutBtn);

        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.infoBtn:
                        //update(new MenuInfoFragment(), token, id);
                        break;
                    case R.id.pupilBtn:
                        //update(new MenuPupilsFragment(), token, id);
                        break;
                    case R.id.logOutBtn:
                        //logOut();
                        break;
                    default:
                        break;
                }
            }
        };
        infoBtn.setOnClickListener(clickListener);
        pupilBtn.setOnClickListener(clickListener);
        logOutBtn.setOnClickListener(clickListener);
    }

    interface MenuGuardianFragmentActivityListener
    {
        //Definicja interfejsu fragmentu
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof MenuGuardianFragmentActivityListener)
        {
            listener = (MenuGuardianFragmentActivityListener) context;
        }
        else
        {
            throw new ClassCastException(context.toString());
        }
    }
}
