package com.example.badmintonmanagerv2;

public class PlayersDatabaseContract {
    
    private PlayersDatabaseContract(){}
    
    
    public static final class PlayerEntry{

        public static String TABLE_NAME = "Players" ;
        public static String ID = "Id";
        public static String NAME = "Name";
        public static String SURNAME = "Surname";
        public static String SEX = "Sex";
        public static String LEVEL = "Level";
        public static String BALANCE = "Balance";
        public static String PHONE_NUMBER = "PhoneNumber";


        public static final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" (" +
                "    "+ID+ "          INTEGER  UNIQUE" +
                "                       PRIMARY KEY" +
                "                       NOT NULL," +
                "    "+NAME+"        STRING NOT NULL," +
                "    "+SURNAME+"     STRING NOT NULL," +
                "    "+SEX+"        STRING NOT NULL," +
                "    "+LEVEL+"      INT    NOT NULL," +
                "    "+BALANCE +"    DOUBLE," +
                "    "+PHONE_NUMBER+" INT    NOT NULL" +
                ");";
    }
}
