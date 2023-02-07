package com.jp.jhgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class add_members extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText membername,m_no,addr,fee;
    Button pickimage,done;
    TextView displayDate ;
    Spinner duration,memberbatch;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        String months[] = {"Select Duration","1 month", "2 month", "3 month",  "6 month", "1 year"};
        List<String> monthList = new ArrayList<>(Arrays.asList(months));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monthList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        duration = findViewById(R.id.month);
        duration.setAdapter(adapter);

        duration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Do something with the selected item

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        memberbatch=findViewById(R.id.mbatch);
        String batch[] = {"Select Batch","Morning", "Evening"};
        /*ArrayAdapter<String> mbadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, batch);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        memberbatch.setAdapter(mbadapter);*/
          ArrayAdapter<String> mbadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, batch) {
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.BLACK);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                tv.setTextSize(15);
                return view;
            }
        };

        mbadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        memberbatch=findViewById(R.id.mbatch);
        memberbatch.setAdapter(mbadapter);

        memberbatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Do something with the selected item

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        displayDate =findViewById(R.id.mjoindate);
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });


    }
    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                add_members.this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
        displayDate.setText(selectedDate);
    }


}