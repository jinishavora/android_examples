package com.example.vora.createcontact_intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivFace, ivCall, ivWeb, ivMap;
    Button btnCreate;

    final int ACTIVITY2 = 2;

    String name, phone, web, map, mood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFace = findViewById(R.id.ivFace);
        ivCall = findViewById(R.id.ivCall);
        ivWeb = findViewById(R.id.ivWeb);
        ivMap = findViewById(R.id.ivMap);
        btnCreate = findViewById(R.id.btnCreate);

        ivFace.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, ACTIVITY2);

            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phone));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" +map));
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY2)
        {
            if (resultCode == RESULT_OK)
            {
                ivFace.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                phone = data.getStringExtra("phone");
                web = data.getStringExtra("web");
                map = data.getStringExtra("address");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy"))
                {
                    ivFace.setImageResource(R.drawable.face);
                }
                else if (mood.equals("sad"))
                {
                    ivFace.setImageResource(R.drawable.sad);
                }
                else
                {
                    ivFace.setImageResource(R.drawable.ok);
                }

            }
            else
            {
                Toast.makeText(this,"No data receivved", Toast.LENGTH_SHORT).show();
            }

        }

    }

}
