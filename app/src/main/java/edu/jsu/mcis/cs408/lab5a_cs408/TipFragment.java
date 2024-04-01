package edu.jsu.mcis.cs408.lab5a_cs408;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.NumberFormat;

import edu.jsu.mcis.cs408.lab5a_cs408.databinding.TipFragmentBinding;

public class TipFragment extends Fragment {
    public static final String TAG = "TipFragment";
    private TipFragmentBinding binding;
    double bill;
    double total;
    int tip, people_num;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
       //Bundle args = getArguments();
        binding.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StringBuilder s = new StringBuilder();
                EditText input = binding.billTotal;
                EditText input2 = binding.tipPercentage;
                EditText input3 = binding.numberOfPeople;
                TextView t = binding.output;
                if (!input.getText().toString().isEmpty() &&
                        !input2.getText().toString().isEmpty() &&
                        !input3.getText().toString().isEmpty()) {
                    bill = Double.parseDouble(input.getText().toString());
                    tip = Integer.parseInt(input2.getText().toString());
                    people_num = Integer.parseInt(input3.getText().toString());
                    double percentage = (bill * tip) / 100;
                    total = (bill + percentage) / people_num;

                    String newTotal = NumberFormat.getCurrencyInstance().format(total);
                    s.append(getResources().getText(R.string.Total_message)).append("");
                    s.append(newTotal);
                    t.setText(s.toString());
                } else {
                    Context context = requireContext();
                    Toast message = Toast.makeText(context, "Please complete all fields", Toast.LENGTH_SHORT);
                    message.show();
                }
            }

        });

    }

}
