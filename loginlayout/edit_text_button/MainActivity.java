package com.example.edit_text_button;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText userPassword, userID;
    Button btnlogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        userID = (EditText)findViewById(R.id.usernamefill);
        userPassword = (EditText)findViewById(R.id.passwordfill);
        btnlogin = (Button)findViewById(R.id.loginbutton);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "admin";
                String pass = "admin";

                if(userID.getText().toString().equals(user) && userPassword.getText().toString().equals(pass)){
                    //username view in home activity
                    Intent mainLogin = new Intent(MainActivity.this, HomeActivity.class);
                    mainLogin.putExtra("username", user);
                    startActivity(mainLogin);

                    Toast.makeText(MainActivity.this, "succ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "wrong", Toast.LENGTH_SHORT).show();
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