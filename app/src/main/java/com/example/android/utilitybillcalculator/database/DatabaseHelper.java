package com.example.android.utilitybillcalculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.utilitybillcalculator.classes.Spending;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Constant value declaration
    public static final String SPENDING_TABLE = "SPENDING_TABLE";
    public static final String COLUMN_SPENDING_TYPE = "SPENDING_TYPE";
    public static final String COLUMN_SPENDING_NAME = "SPENDING_NAME";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TO_CALCULATE = "TO_CALCULATE";
    public static final String COLUMN_COST = "COST";
    public static final String COLUMN_ID = "ID";
    private static final int DATABASE_VERSION = 2;

    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, "spending.db", null, DATABASE_VERSION);
    }

    //Create the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + SPENDING_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SPENDING_TYPE + " TEXT, " + COLUMN_SPENDING_NAME + " TEXT, " + COLUMN_DATE + " TEXT, " + COLUMN_TO_CALCULATE + " INT, " + COLUMN_COST + " INT) ";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SPENDING_TABLE);
        onCreate(db);
    }

    public boolean addOne(Spending spending) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SPENDING_TYPE, spending.getType());
        cv.put(COLUMN_SPENDING_NAME, spending.getName());
        cv.put(COLUMN_DATE, spending.getDate());
        cv.put(COLUMN_TO_CALCULATE, spending.getToCalculate());
        cv.put(COLUMN_COST, spending.getCost());

        long insert = db.insert(SPENDING_TABLE, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Spending> getAllSpending() {
        ArrayList<Spending> spendingList = new ArrayList<>();

        String queryString = "SELECT * FROM " + SPENDING_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                Spending spending = new Spending(cursor.getString(1), cursor.getString(2), cursor.getDouble(5), cursor.getString(3));
                spendingList.add(spending);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return spendingList;

    }

    public ArrayList<Spending> getElectricSpending() {
        ArrayList<Spending> spendingList = new ArrayList<>();

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%ELECTRIC%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                Spending spending = new Spending(cursor.getString(1), cursor.getString(2), cursor.getDouble(5), cursor.getString(3));
                spendingList.add(spending);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return spendingList;
    }

    public ArrayList<Spending> getWaterSpending() {
        ArrayList<Spending> spendingList = new ArrayList<>();

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%WATER%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                Spending spending = new Spending(cursor.getString(1), cursor.getString(2), cursor.getDouble(5), cursor.getString(3));
                spendingList.add(spending);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return spendingList;
    }

    public Double getMonthlyCost() {
        Double sum = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now','start of month') AND '" + COLUMN_DATE + "(now)'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do {

                sum += cursor.getDouble(5);

            } while (cursor.moveToNext());

        }

        db.close();
        cursor.close();

        return sum;

    }

    public Double getLastElectricCost() {
        Double electricCost = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " = " + "'Electric'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            electricCost = cursor.getDouble(5);
        }

        db.close();
        cursor.close();

        return electricCost;

    }

    public Double getLastWaterCost() {
        Double waterCost = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " = " + "'Water'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            waterCost = cursor.getDouble(5);
        }

        db.close();
        cursor.close();

        return waterCost;

    }

    public Spending getLastRecord() {
        Spending spendObject = null;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_ID + " = (SELECT MAX(" + COLUMN_ID + ") FROM " + SPENDING_TABLE + ");";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            spendObject = new Spending(cursor.getString(1), cursor.getString(2), cursor.getDouble(5));
        }

        db.close();
        cursor.close();

        return spendObject;
    }

    public Double getAverageElectricCost() {
        double sum = 0.0;
        double average = 0.0;
        int count = 0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%ELECTRIC%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                sum += cursor.getDouble(5);
                count++;
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        if (sum == 0) {
            return 0.00;
        }

        average = (double) sum / count;
        return average;
    }

    public Double getAverageWaterCost() {
        double sum = 0.0;
        double average = 0.0;
        int count = 0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%WATER%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                sum += cursor.getDouble(5);
                count++;
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        if (sum == 0.0) {
            return 0.00;
        }

        average = (double) sum / count;
        return average;
    }

    public Double getAverageSpending() {
        double sum = 0.0;
        double average = 0.0;
        int count = 0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                sum += cursor.getDouble(5);
                count++;
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        if (sum == 0.0) {
            return 0.00;
        }

        average = (double) sum / count;
        return average;
    }

    public Double getAverageSpendingWithoutBills() {
        double sum = 0.0;
        double average = 0.0;
        int count = 0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " NOT LIKE '%Electric%' OR " + COLUMN_SPENDING_TYPE + " NOT LIKE '%Water%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                sum += cursor.getDouble(5);
                count++;
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        if (sum == 0.0) {
            return 0.00;
        }

        average = (double) sum / count;
        return average;
    }

    public Double getLastMonthSpendingWithoutBills() {
        double sum = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_DATE + "('now', 'start of month', '-1 day')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                String billCheck = cursor.getString(1);
                if (billCheck.equals("Water") || billCheck.equals("Electric")) {
                    continue;
                }
                sum += cursor.getDouble(5);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return sum;
    }

    public boolean checkElectricBillSaved() {
        boolean checked = false;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Electric%' AND " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now','start of month') AND '" + COLUMN_DATE + "(now)'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            checked = true;
        }

        Log.d(TAG, "True: " + checked);

        db.close();
        cursor.close();

        return checked;
    }

    public boolean checkWaterBillSaved() {
        boolean checked = false;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Water%' AND " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now','start of month') AND '" + COLUMN_DATE + "(now)'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            checked = true;
        }

        db.close();
        cursor.close();

        return checked;
    }

    public Double getLastMonthElectricBill() {
        Double bill = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Electric%' AND " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_DATE + "('now', 'start of month', '-1 day')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            bill = cursor.getDouble(5);
        }

        db.close();
        cursor.close();
        return bill;
    }

    public Double getLastMonthWaterBill() {
        Double bill = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Water%' AND " + COLUMN_DATE + " BETWEEN " + COLUMN_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_DATE + "('now', 'start of month', '-1 day')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            bill = cursor.getDouble(5);
        }

        db.close();
        cursor.close();
        return bill;
    }

}
