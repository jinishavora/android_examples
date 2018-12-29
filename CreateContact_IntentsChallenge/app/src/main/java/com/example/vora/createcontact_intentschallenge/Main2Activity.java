package com.example.vora.createcontact_intentschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    EditText etName, etPhone, etWeb, etAddress;
    ImageView ivHappy, ivOk, ivSad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etAddress = findViewById(R.id.etAddress);

        ivHappy = findViewById(R.id.ivHappy);
        ivOk = findViewById(R.id.ivOk);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);
        ivSad.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() ||
                etWeb.getText().toString().isEmpty() || etAddress.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("phone", etPhone.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("address", etAddress.getText().toString().trim());

            if(v.getId() == R.id.ivHappy)
            {
                intent.putExtra("mood", "happy");
            }
            else if (v.getId() == R.id.ivSad)
            {
                intent.putExtra("mood", "sad");
            }
            else
            {
                intent.putExtra("mood","ok");
            }

            setResult(RESULT_OK, intent);
            Main2Activity.this.finish();
        }
    }
}
