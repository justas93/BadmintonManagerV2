package com.example.badmintonmanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.text.BreakIterator;


public class PlayerInfoActivity extends AppCompatActivity {


    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        Intent intent = getIntent();

        int playerId = intent.getExtras().getInt(PlayersListActivity.PLAYER_ID);

        TextView nameId = findViewById(R.id.name_txt);
        nameId.setText(playerId);

        PlayersDatabaseHelper helper = new PlayersDatabaseHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();

        DatabaseDataWorker worker = new DatabaseDataWorker(database);

       // Person person = worker.getPlayerById(playerId);
       // name = findViewById(R.id.name_txt);
        //name.setText(person.getName());


    }
}