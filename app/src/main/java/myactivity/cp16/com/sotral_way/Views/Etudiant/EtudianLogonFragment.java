package myactivity.cp16.com.sotral_way.Views.Etudiant;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.List;

import myactivity.cp16.com.sotral_way.R;

public class EtudianLogonFragment extends Fragment {
    WheelPicker lignesUlWheelPicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_etu, container, false);
         lignesUlWheelPicker=view.findViewById(R.id.wheel_picker_etu);
        List<String> lignesUl = new ArrayList<>();
        String[] str = getResources().getStringArray(R.array.lignesUL);
        for (int i = 0; i < str.length; i++) {
            lignesUl.add(str[i]);
        }
        lignesUlWheelPicker.setData(lignesUl);
        lignesUlWheelPicker.setAtmospheric(false);
        lignesUlWheelPicker.setCurtain(false);
        lignesUlWheelPicker.setCyclic(true);
        lignesUlWheelPicker.setCurved(true);
        lignesUlWheelPicker.setItemSpace(1000);

        return view;
    }


    }
