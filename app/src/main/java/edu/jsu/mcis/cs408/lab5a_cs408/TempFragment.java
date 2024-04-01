package edu.jsu.mcis.cs408.lab5a_cs408;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.lab5a_cs408.databinding.TempFragmentBinding;

public class TempFragment extends Fragment {
    public static final String TAG = "Temperature";
    private TempFragmentBinding binding;
    double F, C;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TempFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = binding.fInput;
                EditText input2 = binding.cInput;
                String Celsius = input2.getText().toString();
                String Fahren = input.getText().toString();

                if (Celsius.isEmpty() && Fahren.isEmpty()){
                    Context context = requireContext();
                    Toast toast = Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
                try{
                    if (Celsius.equals("")) {
                        F = Double.parseDouble(Fahren);
                        double C = (F - 32) * 5 / 9;
                        C = Double.parseDouble(String.format("%.2f", C));
                        input2.setText(String.valueOf(C));
                    } else if (Fahren.equals("")) {
                        C = Double.parseDouble(Celsius);
                        double F = (C * 9 / 5) + 32;
                        F = Double.parseDouble(String.format("%.2f", F));
                        input.setText(String.valueOf(F));
                    } else {
                        F = Double.parseDouble(Fahren);
                        double C = (F - 32) * 5 / 9;
                        C = Double.parseDouble(String.format("%.2f", C));
                        input2.setText(String.valueOf(C));
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
