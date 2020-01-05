package com.ovais.datavalidationassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN=Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{5,8}" +               //at least 5 characters and max 8 characters
            "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void redirectHome(View view) {

        if (validateEmail()&& passwordValidation() ){
            Intent loginActivity=new Intent(Login.this,Home.class);
            startActivity(loginActivity);



        }

    }

    private boolean validateEmail(){
        EditText email;
        email=findViewById(R.id.email);
        String emailInput=email.getText().toString().trim();
        if (emailInput.isEmpty()){


            email.setError("Email Field Is Empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError("Please Enter A Valid Email Address");
            return false;
        }
        else {

            email.setError(null);
            return true;
        }


    }


    private boolean passwordValidation(){
        EditText password=findViewById(R.id.password);
        String passwordInput=password.getText().toString().trim();
        if (passwordInput.isEmpty()){

            password.setError("Password Can't Be Empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){

            password.setError("Password must contains 1 Uppercase,1 Lowercase," +
                    "1 Digit,1 Special Character,No whitespaces");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }

    }

}
