package com.example.edit_text_button;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    //variables
    TextView txtMessage, txtNumber, counter;
    Button buttonMin, buttonAdd;
    int i;
    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        txtMessage = findViewById(R.id.message);
        txtMessage.setText(getIntent().getStringExtra("username"));
        counter = findViewById(R.id.viewcount);



        //buttons add and minus
        buttonMin = (Button)findViewById(R.id.buttonminus);
        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(i>0){
                   i--;
                   counter.setText(String.valueOf(i));
               }else{
                   Toast.makeText(HomeActivity.this,
                           "smallest value na dai", Toast.LENGTH_SHORT).show();
               }
            }
        });
        buttonAdd = (Button)findViewById(R.id.buttonadd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>=0){
                    i++;
                    counter.setText(String.valueOf(i));
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}