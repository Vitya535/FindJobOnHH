package vsu.project.findjobonhh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vsu.project.findjobonhh.database.entity.Developer;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "FindJobOnHH.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlDevelopers = "CREATE TABLE developers(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " first_name VARCHAR, last_name VARCHAR, middle_name VARCHAR, email VARCHAR);";
        String sqlResumes = "CREATE TABLE resumes(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " first_name VARCHAR, last_name VARCHAR, phone VARCHAR, city VARCHAR, birth_date TEXT," +
                " gender VARCHAR, experience VARCHAR, specialization_name VARCHAR, salary INTEGER, currency VARCHAR);";
        String sqlVacancies = "CREATE TABLE vacancies(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " description VARCHAR, created_at TEXT, name VARCHAR);";

        db.execSQL(sqlDevelopers);
        db.execSQL(sqlResumes);
        db.execSQL(sqlVacancies);
    }

    public boolean addDeveloper(String firstName, String lastName, String middleName, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", firstName);
        contentValues.put("last_name", lastName);
        contentValues.put("middle_name", middleName);
        contentValues.put("email", email);
        db.insert("developers", null, contentValues);
        return true;
    }

    public boolean addResume(String firstName, String lastName, String phone, String city, String birthDate,
                             String gender, String experience, String specializationName,
                             Integer salary, String currency) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", firstName);
        contentValues.put("last_name", lastName);
        contentValues.put("phone", phone);
        contentValues.put("city", city);
        contentValues.put("birth_date", birthDate);
        contentValues.put("gender", gender);
        contentValues.put("experience", experience);
        contentValues.put("specialization_name", specializationName);
        contentValues.put("salary", salary);
        contentValues.put("currency", currency);
        db.insert("resumes", null, contentValues);
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDevelopers = "DROP TABLE IF EXISTS developers";
        String sqlResumes = "DROP TABLE IF EXISTS resumes";
        String sqlVacancies = "DROP TABLE IF EXISTS vacancies";

        db.execSQL(sqlDevelopers);
        db.execSQL(sqlResumes);
        db.execSQL(sqlVacancies);

        onCreate(db);
    }

    public List<Developer> findAllDevelopers() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlFindAllDevelopers = "SELECT * FROM developers";

        Cursor cursor = db.rawQuery(sqlFindAllDevelopers, null);
        return convertFrom(cursor);
    }

    private List<Developer> convertFrom(Cursor cursor) {
        List<Developer> developers = new ArrayList<>();
        while (cursor.moveToNext()) {
            Developer developer = new Developer();
            developer.setFirstName(cursor.getString(1));
            developer.setLastName(cursor.getString(2));
            developer.setMiddleName(cursor.getString(3));
            developer.setEmail(cursor.getString(4));
            developers.add(developer);
        }
        return developers;
    }
}
