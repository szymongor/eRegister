package pl.codemajsters.eregistry;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MenuStudentFragment extends Fragment
{
    private View fragmentView;
    private ImageButton gradeBtn;
    private ImageButton guardianBtn;
    private ImageButton infoBtn;
    private ImageButton logOutBtn;
    private MenuStudentFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentView = inflater.inflate(R.layout.menu_student, container, false);
        setComponents();
        setTitleBar("Menu");
        return fragmentView;
    }

    private void setComponents()
    {
        gradeBtn = (ImageButton) fragmentView.findViewById(R.id.gradeBtn);
        guardianBtn = (ImageButton) fragmentView.findViewById(R.id.guardianBtn);
        infoBtn = (ImageButton) fragmentView.findViewById(R.id.infoBtn);
        logOutBtn = (ImageButton) fragmentView.findViewById(R.id.logOutBtn);

        View.OnClickListener clickListener = new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.gradeBtn:
                        setCurrentFragment(new MenuSubjectsFragment());
                        break;
                    case R.id.guardianBtn:
                        setCurrentFragment(new TutorFragment(), "/Groups/myClass");
                        break;
                    case R.id.infoBtn:
                        setCurrentFragment(new MenuInfoFragment());
                        break;
                    case R.id.logOutBtn:
                        logOut();
                        break;
                    default:
                        break;
                }
            }
        };
        gradeBtn.setOnClickListener(clickListener);
        guardianBtn.setOnClickListener(clickListener);
        infoBtn.setOnClickListener(clickListener);
        logOutBtn.setOnClickListener(clickListener);
    }

    interface MenuStudentFragmentActivityListener
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
        if (context instanceof MenuStudentFragmentActivityListener)
        {
            listener = (MenuStudentFragmentActivityListener) context;
        }
        else
        {
            throw new ClassCastException(context.toString());
        }
    }
}