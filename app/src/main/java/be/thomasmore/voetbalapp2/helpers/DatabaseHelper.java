package be.thomasmore.voetbalapp2.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.models.Fixture;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "usa";

    // uitgevoerd bij instantiatie van DatabaseHelper
    // -> als database nog niet bestaat, dan creëren (call onCreate)
    // -> als de DATABASE_VERSION hoger is dan de huidige versie,
    //    dan upgraden (call onUpgrade)

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // methode wordt uitgevoerd als de database gecreëerd wordt
    // hierin de tables creëren en opvullen met gegevens
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_Fixture = "CREATE TABLE fixture (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "home_team TEXT," +
                "away_team TEXT, " +
                "date TEXT, " +
                "time TEXT, " +
                "competitionId TEXT, " +
                "home_score INTEGER, " +
                "away_score INTEGER, " +
                "status TEXT )";
        db.execSQL(CREATE_TABLE_Fixture);
        insertPresidents(db);
    }

    // methode wordt uitgevoerd als database geupgrade wordt
    // hierin de vorige tabellen wegdoen en opnieuw creëren
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS fixture");

        // Create tables again
        onCreate(db);
    }

    private void insertPresidents(SQLiteDatabase db) {
        db.execSQL("INSERT INTO fixture (home_team, away_team, date,time,competitionId, home_score, away_score, status) VALUES ('PSG', 'LILLE', '15/05/2019', '10:00', '1', 0,3,'finished');");
        db.execSQL("INSERT INTO fixture (home_team, away_team, date,time,competitionId, home_score, away_score, status) VALUES ('PSG', 'Rennes', '15/05/2019', '10:00', '1', 3,3,'finished');");
        db.execSQL("INSERT INTO fixture (home_team, away_team, date,time,competitionId, home_score, away_score, status) VALUES ('PSG', 'Barcelona', '15/05/2019', '10:00', '1', 3,0,'finished');");
    }

    //-------------------------------------------------------------------------------------------------
    //  CRUD Operations
    //-------------------------------------------------------------------------------------------------

    public long insertPresident(Fixture fixture) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("home_team", fixture.getHome_name());
        values.put("away_team", fixture.getAway_name());
        values.put("status", fixture.getStatus());
        values.put("date", fixture.getDate());
        values.put("time", fixture.getTime());
        values.put("home_score", fixture.getHome_score());
        values.put("away_score", fixture.getAway_score());


        long id = db.insert("fixture", null, values);

        db.close();
        return id;
    }

    // delete-methode
    public boolean deleteFixture(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        int numrows = db.delete(
                "fixture",
                "id = ?",
                new String[] { String.valueOf(id) });

        db.close();
        return numrows > 0;
    }

    // rawQuery-methode
    public List<Fixture> getFixtures() {
        List<Fixture> lijst = new ArrayList<Fixture>();

        String selectQuery = "SELECT  * FROM fixture";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Fixture fixture = new Fixture(cursor.getString(0), cursor.getString(4), cursor.getString(3), cursor.getString(1), cursor.getString(2), cursor.getString(5), cursor.getInt(6), cursor.getInt(7), cursor.getString(8));
                lijst.add(fixture);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lijst;
    }

//    // rawQuery-methode
//    public int getCountPresidents() {
//        String selectQuery = "SELECT  * FROM president";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        int aantal = cursor.getCount();
//
//        cursor.close();
//        db.close();
//        return aantal;
//    }

}
