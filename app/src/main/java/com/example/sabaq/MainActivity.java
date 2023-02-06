package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnCommit, btnShow, btnSave;
    EditText stuName, SabaqPara, SabaqiiPara, ManzilPara;
    RadioGroup radioGroupSabaq, radioGroupSabaqii, radioGroupManzil;

    String sabaqStatus, sabaqiiStatus, manzilStatus;


    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuName = findViewById(R.id.Student_Name);
        SabaqPara = findViewById(R.id.Sabaq_Para);
        SabaqiiPara = findViewById(R.id.sabaqii_Para);
        ManzilPara = findViewById(R.id.Manzil_Para);
        btnSave = findViewById(R.id.Save);


        radioGroupSabaq = (RadioGroup) findViewById(R.id.radioGroupSabaq);
        radioGroupSabaqii = (RadioGroup) findViewById(R.id.radioGroupSabqi);
        radioGroupManzil = (RadioGroup) findViewById(R.id.radioGroupManzil);



        db = new DbHelper(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student = stuName.getText().toString();
                String sabaq = SabaqPara.getText().toString();
                String sabaqii = SabaqiiPara.getText().toString();
                String manzil = ManzilPara.getText().toString();
                Date date1 = new Date();
                SimpleDateFormat DateFor = new SimpleDateFormat("dd MMMM yyyy");
                String date = DateFor.format(date1);
                if (student.isEmpty() || sabaq.isEmpty() || sabaqii.isEmpty()|| manzil.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill the above info..", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioGroupSabaq.getCheckedRadioButtonId() == R.id.sabaqYes)
                {
                    sabaqStatus = "Yes";
                }
                if (radioGroupSabaq.getCheckedRadioButtonId() == R.id.sabaqNo)
                {
                    sabaqStatus ="No";
                }
                if (radioGroupSabaqii.getCheckedRadioButtonId() == R.id.sabaqiiYes)
                {
                    sabaqiiStatus = "Yes";
                }
                if (radioGroupSabaqii.getCheckedRadioButtonId() == R.id.sabaqiiNo)
                {
                    sabaqiiStatus ="No";
                }
                if (radioGroupManzil.getCheckedRadioButtonId() == R.id.ManzilYes)
                {
                    manzilStatus = "Yes";
                }
                if (radioGroupManzil.getCheckedRadioButtonId() == R.id.ManzilNo)
                {
                    manzilStatus ="No";
                }
                SabaqDiary s = new SabaqDiary(student, sabaq, sabaqStatus, sabaqii, sabaqiiStatus, manzil, manzilStatus, date);
                db.saveData(s);
                Toast.makeText(MainActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnShow = findViewById(R.id.show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), show.class);
                v.getContext().startActivity(intent);
            }
        });

        btnCommit = findViewById(R.id.Commits);
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://github.com/komalafzaal123/SabaqDiary/commits/main");
            }

            private void goToUrl(String url) {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }


}