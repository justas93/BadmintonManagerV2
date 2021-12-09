package com.example.badmintonmanagerv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    ListView listView;
    private ArrayAdapter<Person> adapter;
    private Intent intent;
    int playerNumberToDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        ImageButton addPlayer = (ImageButton) findViewById(R.id.imageButton_addPerson);
        addPlayer.setOnClickListener(this);

        ImageButton playersList = (ImageButton) findViewById(R.id.imageButton_personList);
        playersList.setOnClickListener(this);


        PlayersDatabaseHelper helper = new PlayersDatabaseHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();
    }

//       listView = findViewById(R.id.listview);
//       listView.setAdapter(adapter);
//
//
//        ArrayList<Person> persons = new ArrayList<>();
//
//        Person person1 = new Person("Petras", "Petraitis ","Male", 8, 20.5,867600555);
//        Person person2 = new Person("Antanas", "Lazauskas ", "Male", 8, 20.5,867600555);
//        Person person3 = new Person("Kazys", "Petraitis ", "Male",8, 20.5,867600555);
//
//        persons.add(person1);
//        persons.add(person2);
//        persons.add(person3);
//
//
//        ListView playersListUI = findViewById(R.id.players_list);
//
//        adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, persons);
//
//        playersListUI.setAdapter(adapter);
//
//        FloatingActionButton buttonSearchPerson = findViewById(R.id.add_person);
//
//
//        buttonAddPerson.setOnClickListener();


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu,menu);
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("Ieškoti ");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                adapter.getFilter().filter(newText);
//
//
//                return false;
//            }
//        });
//
//
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imageButton_addPerson:
                intent = new Intent(MainActivity.this, AddPersonActivity.class);
                startActivity(intent);
                break;

            case R.id.imageButton_personList:
                intent = new Intent(MainActivity.this, PlayersListActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

}












