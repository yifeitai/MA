package ma.com.ma.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import ma.com.ma.R;
import ma.com.ma.models.User;

public class RegisterActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private EditText fullname;
    private EditText email;
    private EditText password1;
    private EditText password2;
    private Switch switchButton;
    private TextView swicthText;
    private String switchOn = "English";
    private String switchOff="Español";
    private Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname=(EditText) findViewById(R.id.fullname);
        email =(EditText) findViewById(R.id.email);
        password1=(EditText) findViewById(R.id.password1);
        password2=(EditText) findViewById(R.id.password2);
        register_button=(Button) findViewById(R.id.register_button);

        switchButton = (Switch) findViewById(R.id.switchButton);
        swicthText = (TextView) findViewById(R.id.switchText);
        switchButton.setChecked(true);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    swicthText.setText(switchOn);
                } else {
                    swicthText.setText(switchOff);
                }
            }
        });

        if (switchButton.isChecked()) {
            swicthText.setText(switchOn);
        } else {
            swicthText.setText(switchOff);
        }


        sharedPreferences=this.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().isEmpty()||fullname.getText().toString().isEmpty()||password1.getText().toString().isEmpty()||password2.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please verify your data", Toast.LENGTH_LONG).show();
                }else{
                    if (password1.getText().toString().equals(password2.getText().toString())){


                        User user=new User(email.getText().toString(),
                                password1.getText().toString(),
                                fullname.getText().toString()
                        );

                        UserBL.register(user);


                        SharedPreferences.Editor editor=sharedPreferences.edit();

                        boolean success=editor
                                .putString("fullname",user.getFullname())
                                .putString("email",user.getEmail())
                                .putBoolean("logged",true)
                                .commit();

                        Intent intent=new Intent(RegisterActivity.this,UserActivity.class);
                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(RegisterActivity.this, "Please verify your passwords", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

    }

    public void androidCheckBoxClicked(View view) {
// action for checkbox click
        switch (view.getId()) {
            case R.id.checkBox1:
                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked())
                    Toast.makeText(this, checkBox.getText() + " selected!", Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox2:
                //DO something when user check the box
                break;
            case R.id.checkBox3:
                //DO something when user check the box
                break;
        }
    }
}
