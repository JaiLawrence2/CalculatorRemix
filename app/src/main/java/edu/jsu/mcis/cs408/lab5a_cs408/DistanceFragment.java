package edu.jsu.mcis.cs408.lab5a_cs408;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.lab5a_cs408.databinding.DistanceFragmentBinding;


public class DistanceFragment extends Fragment {
    private DistanceFragmentBinding binding;
    double miles;
    double km;

    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState){
        binding = DistanceFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = binding.mInput;
                EditText input2 = binding.kmInput;
                String kilometers = input2.getText().toString();
                String m = input.getText().toString();

                if (kilometers.isEmpty() && m.isEmpty()){
                    Context context = requireContext();
                    Toast toast = Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
                try{

                if (kilometers.equals("")){
                    miles = Double.parseDouble(m);
                    double km = (miles * 1.60934);
                    km = Double.parseDouble(String.format("%.2f",km));
                    input2.setText(String.valueOf(km));
                }
                else if (m.equals("")){
                    km = Double.parseDouble(kilometers);
                    double miles = (km * 0.621371);
                    miles = Double.parseDouble(String.format("%.2f",miles));
                    input.setText(String.valueOf(miles));
                }
                else{
                    miles = Double.parseDouble(m);
                    double km = (miles * 1.60934);
                    km = Double.parseDouble(String.format("%.2f",km));
                    input2.setText(String.valueOf(km));
                }

            } catch (NumberFormatException e){
                Context context = requireContext();
                Toast toast = Toast.makeText(context, "Non-numeric Value Entered", Toast.LENGTH_SHORT);
                toast.show();
            }

            }

        });
    }

}

