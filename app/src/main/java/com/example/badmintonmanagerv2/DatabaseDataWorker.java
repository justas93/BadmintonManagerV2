package com.example.badmintonmanagerv2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import javax.xml.namespace.QName;

public class DatabaseDataWorker {

    private SQLiteDatabase database;


    public DatabaseDataWorker(SQLiteDatabase database) {
        this.database = database;
    }

    public ArrayList<Person> getAllPlayers() {
        String tableName = PlayersDatabaseContract.PlayerEntry.TABLE_NAME;

        String column1 = PlayersDatabaseContract.PlayerEntry.ID;
        String column2 = PlayersDatabaseContract.PlayerEntry.NAME;
        String column3 = PlayersDatabaseContract.PlayerEntry.SURNAME;
        String column4 = PlayersDatabaseContract.PlayerEntry.SEX;
        String column5 = PlayersDatabaseContract.PlayerEntry.LEVEL;
        String column6 = PlayersDatabaseContract.PlayerEntry.BALANCE;
        String column7 = PlayersDatabaseContract.PlayerEntry.PHONE_NUMBER;

        String[] columns = new String[]{column1, column2, column3, column4, column5, column6, column7};


        Cursor cursor = database.query(tableName, columns, null, null, null, null, null, null);


        ArrayList<Person> persons = new ArrayList<>();

        while (cursor.moveToNext()) {


            int idIndex = cursor.getColumnIndex(column1);
            int id = cursor.getInt(idIndex);

            int nameIndex = cursor.getColumnIndex(column2);
            String name = cursor.getString(nameIndex);

            int surnameIndex = cursor.getColumnIndex(column3);
            String surname = cursor.getString(surnameIndex);

            int sexIndex = cursor.getColumnIndex(column4);
            String sex = cursor.getString(sexIndex);

            int levelIndex = cursor.getColumnIndex(column5);
            int level = cursor.getInt(levelIndex);

            int balanceIndex = cursor.getColumnIndex(column6);
            double balance = cursor.getDouble(balanceIndex);

            int phoneNumberIndex = cursor.getColumnIndex(column7);
            int phoneNumber = cursor.getInt(phoneNumberIndex);

            Person person = new Person(id, name, surname, sex, level, balance, phoneNumber);

            persons.add(person);
        }
        return persons;

    }

    public long insertPerson(String name, String surname, String sex, String level, String phoneNumber) {

        ContentValues values = new ContentValues();

        values.put(PlayersDatabaseContract.PlayerEntry.NAME, name);
        values.put(PlayersDatabaseContract.PlayerEntry.SURNAME, surname);
        values.put(PlayersDatabaseContract.PlayerEntry.SEX, sex);
        values.put(PlayersDatabaseContract.PlayerEntry.LEVEL, level);
        values.put(PlayersDatabaseContract.PlayerEntry.PHONE_NUMBER, phoneNumber);

        int id = (int) database.insert(PlayersDatabaseContract.PlayerEntry.TABLE_NAME, null, values);


        return id;
    }

    public Cursor viewData() {

        String query = "SELECT * FROM " + PlayersDatabaseContract.PlayerEntry.TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);

        return cursor;

    }

    public Person getPlayerById(Integer id) {


        String tableName = PlayersDatabaseContract.PlayerEntry.TABLE_NAME;

        String column1 = PlayersDatabaseContract.PlayerEntry.ID;
        String column2 = PlayersDatabaseContract.PlayerEntry.NAME;
        String column3 = PlayersDatabaseContract.PlayerEntry.SURNAME;
        String column4 = PlayersDatabaseContract.PlayerEntry.SEX;
        String column5 = PlayersDatabaseContract.PlayerEntry.LEVEL;
        String column6 = PlayersDatabaseContract.PlayerEntry.BALANCE;
        String column7 = PlayersDatabaseContract.PlayerEntry.PHONE_NUMBER;

        String[] columns = new String[]{column1, column2, column3, column4, column5, column6, column7};

        Cursor cursor = database.query(tableName, columns, "id=?", new String[]{id.toString()}, null, null, null);

        Person person = null;

        while (cursor.moveToNext()) {


            int nameIndex = cursor.getColumnIndex(column2);
            String name = cursor.getString(nameIndex);

            int surnameIndex = cursor.getColumnIndex(column3);
            String surname = cursor.getString(surnameIndex);

            int sexIndex = cursor.getColumnIndex(column4);
            String sex = cursor.getString(sexIndex);

            int levelIndex = cursor.getColumnIndex(column5);
            int level = cursor.getInt(levelIndex);

            int balanceIndex = cursor.getColumnIndex(column6);
            double balance = cursor.getDouble(balanceIndex);

            int phoneNumberIndex = cursor.getColumnIndex(column7);
            int phoneNumber = cursor.getInt(phoneNumberIndex);

            person = new Person(id, name, surname, sex, level, balance, phoneNumber);


        }
        return person;

    }
}
