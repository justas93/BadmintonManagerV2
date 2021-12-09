package com.example.badmintonmanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {

    EditText name;
    String name1;
    EditText surname;
    String surname1;
    EditText sex;
    String sex1;
    EditText level;
    String level1;
    EditText phoneNumber;
    String phoneNumber1;
    Button register_btn;
    private PlayersDatabaseHelper helper;
    private SQLiteDatabase database;
    private DatabaseDataWorker worker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);


        name =  findViewById(R.id.name_txt);
        surname =  findViewById(R.id.surname_txt);
        sex =  findViewById(R.id.sex_txt);
        level =  findViewById(R.id.level_txt);
        phoneNumber = findViewById(R.id.phoneNumber);
        register_btn = findViewById(R.id.register_btn);

        helper = new PlayersDatabaseHelper(this);
        database = helper.getReadableDatabase();
        worker = new DatabaseDataWorker(database);



        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                checkDataEntered(); //patikrina ar ivesti duomenys ir sukisa i duombaze jei viskas gerai


            }

        });

    }


    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(name)) {
            Toast t = Toast.makeText(this, "Įveskite visus duomenis!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(surname)) {
            surname.setError("Iveskite pavardę!");
        }
        if (isEmpty(sex)) {
            sex.setError("Iveskite lytį");
        }
        if (isEmpty(level)) {
            level.setError("Iveskite lygį");
        }
        if (isEmpty(phoneNumber)) {
            phoneNumber.setError("Iveskite telefono numeri");
        } else {
            name1 = name.getText().toString();
            surname1 = surname.getText().toString();
            sex1 = sex.getText().toString();
            level1 = level.getText().toString();
            phoneNumber1 = phoneNumber.getText().toString();
            insertPerson(name1, surname1, sex1, level1, phoneNumber1);
            Toast.makeText(AddPersonActivity.this, "Vartotojas sukurtas", Toast.LENGTH_SHORT).show();

            Intent  intent = new Intent(AddPersonActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void insertPerson(String name1, String surname1, String sex1, String level1, String phoneNumber1) {

        worker.insertPerson(name1, surname1, sex1, level1, phoneNumber1);
    }




}







