package myactivity.cp16.com.sotral_way.Views.Autre;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.List;

import myactivity.cp16.com.sotral_way.R;

public class AnonymLogonFragment extends Fragment {
    WheelPicker lignesAutresWheelPicker;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_other, container, false);
        lignesAutresWheelPicker=view.findViewById(R.id.wheel_picker_anony);
        List<String> lignesAutres = new ArrayList<>();
        String[] str = getResources().getStringArray(R.array.lignesAutres);
        for (int i = 0; i < str.length; i++) {
            lignesAutres.add(str[i]);
        }
        lignesAutresWheelPicker.setData(lignesAutres);
        lignesAutresWheelPicker.setAtmospheric(true);
        lignesAutresWheelPicker.setCurtain(true);
        lignesAutresWheelPicker.setCyclic(true);
        lignesAutresWheelPicker.setCurved(true);
        return view;
    }
}
