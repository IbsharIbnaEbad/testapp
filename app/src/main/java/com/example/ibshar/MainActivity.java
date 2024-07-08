package com.example.ibshar;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
/*import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;*/

public class MainActivity extends AppCompatActivity {


    Button btnreg, btnlog;
    //EditText edtfn, edtpass;
    //Pcdata pcdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;*/

        btnlog = findViewById(R.id.btnlog);
        btnreg = findViewById(R.id.btnreg);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;//1
                intent = new Intent(MainActivity.this, Inventory.class);


                startActivity(intent);

            }


        });
/*
        edtfn = findViewById(R.id.edtfn);
        edtpass = findViewById(R.id.edtpass);
        btnlog = findViewById(R.id.btnlog);
        btnreg = findViewById(R.id.btnreg);
        //Pcdata pcdata = Pcdata.getDB(this);


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtfn.getText().toString();
                String password = edtpass.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    DataBaseHelper dbhelper = new DataBaseHelper(MainActivity.this);
                    boolean result = dbhelper.checkusrbyusername(username, password);

                    if (result) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, menuviewtest.class);  // Changed to Menu.class
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
*/

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;//1
                inext = new Intent(MainActivity.this, Register.class);//2
                //1 2 line jekuno jaygay dewa jay doesnt matter but start activy btn click er bitore likhte hoy
//               /* String id=edtid.getText().toString();
//                String pass=edtpass.getText().toString();
//                pcdata.userinfoDao().adduser(
//                        new usersinfo(id ,pass)*/


                startActivity(inext);
            }
            // text dekaimu time faile log in as user dia id dimu
        });


    }


   /* private class LoginTask extends AsyncTask<String, Void, usersinfo> {
        @Override
        protected usersinfo doInBackground(String... params) {
            String username = params[0];
            String password = params[1];
            return pcdata.userinfoDao().login(username, password);
        }

        @Override
        protected void onPostExecute(usersinfo user) {
            if (user != null) {
                Intent intent = new Intent(MainActivity.this, item.class);
                startActivity(intent);
            } else {

                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).
                        show();
            }
        }
    }*/
}