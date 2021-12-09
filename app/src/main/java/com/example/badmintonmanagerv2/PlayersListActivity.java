package com.example.badmintonmanagerv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayersListActivity extends AppCompatActivity {
    public static final String PLAYER_ID = "com.example.badmintonmanagerv2.PLAYER_ID";
    private PlayersDatabaseHelper helper;
    private SQLiteDatabase database;
    private DatabaseDataWorker worker;

    private int playerNumberToDelete;


   // ArrayAdapter adapter;
    private ArrayList<Person> players;
    private ArrayAdapter<Person> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        helper = new PlayersDatabaseHelper(this);
        database = helper.getReadableDatabase();

        worker = new DatabaseDataWorker(database);
        worker.getAllPlayers();


        players = worker.getAllPlayers();
        adapter = setPlayersListView(players);


        ListView playersListView = findViewById(R.id.player_list);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);

        playersListView.setAdapter(adapter);


    }

    @NonNull
    private ArrayAdapter<Person> setPlayersListView(ArrayList<Person> players) {

        ListView playersListView = findViewById(R.id.player_list);


        //ArrayAdapter<Person> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);



        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                players.remove(playerNumberToDelete);
                adapter.notifyDataSetChanged();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(PlayersListActivity.this);
        builder.setMessage("Ar tikrai nori ištrinti");
        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", null);

        AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                playerNumberToDelete = position;
                builder.show();

                return true;
            }
        };
        playersListView.setOnItemLongClickListener(onItemLongClickListener);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Person clickedPerson = players.get((int)id);

                Intent intent = new Intent(PlayersListActivity.this, PlayerInfoActivity.class);

                intent.putExtra(PLAYER_ID, clickedPerson.getId());

                startActivity(intent);
            }
        };

        playersListView.setOnItemClickListener(onItemClickListener);

        return adapter;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Ieškoti ");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);


                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}