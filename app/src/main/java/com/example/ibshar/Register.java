package com.example.ibshar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        EditText edtfn, edtpass, edtrpass, edtphn, edtsn;
        Button btncrtreg;
        //  Pcdata pcdata;


        edtfn = findViewById(R.id.edtfn);
        edtsn = findViewById(R.id.edtsn);
        edtphn = findViewById(R.id.edtphn);
        edtpass = findViewById(R.id.edtpass);
        edtrpass = findViewById(R.id.edtrpass);
        btncrtreg = findViewById(R.id.btncrtreg);
        //  pcdata = Pcdata.getDB(this);

        btncrtreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = edtfn.getText().toString();
                String lastname = edtsn.getText().toString();
                String phonenumber = edtphn.getText().toString();
                String password = edtpass.getText().toString();
                String confirmPassword = edtrpass.getText().toString();

                if (password.equals(confirmPassword) && !password.isEmpty() && !firstname.isEmpty()) {
                    DatabaseHelper dbhelper = new DatabaseHelper(Register.this);
                    boolean isinserted = dbhelper.insertUser(firstname, password, phonenumber);

                    if (isinserted) {
                        Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, "Passwords do not match or fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });


               /* pcdata.userinfoDao().adduser(
                        new usersinfo(firstname, lastname, password, phonenumber
                                , confirmPassword)
                );
*/

                /*if (password.equals(confirmPassword)) {
                    usersinfo user = new usersinfo(firstname, lastname, password, Integer.parseInt(phonenumber));
                    new RegisterTask().execute(user);
                }

                else {
                    Toast.makeText(register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }*/
/*
            }
        });
    }
*/

    /*private class RegisterTask extends AsyncTask<usersinfo, Void, Void> {
        @Override
        protected Void doInBackground(usersinfo... users) {
            pcdata.userinfoDao().adduser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            finish();
        }
    }*/
    }}





        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
