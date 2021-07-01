package com.example.android.utilitybillcalculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.utilitybillcalculator.entities.ElectricBill;
import com.example.android.utilitybillcalculator.entities.Spending;
import com.example.android.utilitybillcalculator.entities.WaterBill;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_ID = "ID";
    private static final int DATABASE_VERSION = 2;

    //Constant value declaration for spending table
    public static final String SPENDING_TABLE = "SPENDING_TABLE";
    public static final String COLUMN_SPENDING_NAME = "SPENDING_NAME";
    public static final String COLUMN_SPENDING_TYPE = "SPENDING_TYPE";
    public static final String COLUMN_SPENDING_DATE = "DATE";
    public static final String COLUMN_SPENDING_PRICE = "COST";

    // Constant value declaration for price bracket
    public static final String COLUMN_PRICE_BRACKET_ONE = "PRICE_BRACKET_ONE";
    public static final String COLUMN_PRICE_BRACKET_TWO = "PRICE_BRACKET_TWO";
    public static final String COLUMN_PRICE_BRACKET_THREE = "PRICE_BRACKET_THREE";
    public static final String COLUMN_PRICE_BRACKET_FOUR = "PRICE_BRACKET_FOUR";
    public static final String COLUMN_PRICE_BRACKET_FIVE = "PRICE_BRACKET_FIVE";
    public static final String COLUMN_PRICE_BRACKET_SIX = "PRICE_BRACKET_SIX";
    public static final String COLUMN_PRICE_BRACKET_SEVEN = "PRICE_BRACKET_SEVEN";
    public static final String COLUMN_PRICE_BRACKET_EIGHT = "PRICE_BRACKET_EIGHT";
    public static final String COLUMN_PRICE_BRACKET_NINE = "PRICE_BRACKET_NINE";
    public static final String COLUMN_PRICE_BRACKET_TEN = "PRICE_BRACKET_TEN";
    public static final String COLUMN_PRICE_BRACKET_ELEVEN = "PRICE_BRACKET_ELEVEN";

    // Constant value declaration for electric bill table
    public static final String ELECTRIC_TABLE = "ELECTRIC_TABLE";
    public static final String COLUMN_ELECTRIC_NAME = "ELECTRIC_NAME";

    // Constant value declaration for water bill table
    public static final String WATER_TABLE = "WATER_TABLE";
    public static final String COLUMN_WATER_NAME = "WATER_NAME";

    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, "spending.db", null, DATABASE_VERSION);
    }

    //Create the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSpendingTableStatement = "CREATE TABLE " + SPENDING_TABLE
                                                + " ("
                                                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                + COLUMN_SPENDING_TYPE + " TEXT, "
                                                + COLUMN_SPENDING_NAME + " TEXT, "
                                                + COLUMN_SPENDING_DATE + " TEXT, "
                                                + COLUMN_SPENDING_PRICE + " INT) ";
        String createElectricTableStatement = "CREATE TABLE " + ELECTRIC_TABLE
                                                + " ("
                                                + COLUMN_ID + " INTEGER PRIMARY KEY, "
                                                + COLUMN_ELECTRIC_NAME + " TEXT, "
                                                + COLUMN_PRICE_BRACKET_ONE + " INT, "
                                                + COLUMN_PRICE_BRACKET_TWO + " INT, "
                                                + COLUMN_PRICE_BRACKET_THREE + " INT, "
                                                + COLUMN_PRICE_BRACKET_FOUR + " INT, "
                                                + COLUMN_PRICE_BRACKET_FIVE + " INT, "
                                                + COLUMN_PRICE_BRACKET_SIX + " INT, "
                                                + COLUMN_PRICE_BRACKET_SEVEN + " INT, "
                                                + COLUMN_PRICE_BRACKET_EIGHT + " INT, "
                                                + COLUMN_PRICE_BRACKET_NINE + " INT, "
                                                + COLUMN_PRICE_BRACKET_TEN + " INT, "
                                                + COLUMN_PRICE_BRACKET_ELEVEN + " INT) ";
        String createWaterTableStatement = "CREATE TABLE " + WATER_TABLE
                                            + " ("
                                            + COLUMN_ID + " INTEGER PRIMARY KEY, "
                                            + COLUMN_WATER_NAME + " TEXT, "
                                            + COLUMN_PRICE_BRACKET_ONE + " INT, "
                                            + COLUMN_PRICE_BRACKET_TWO + " INT, "
                                            + COLUMN_PRICE_BRACKET_THREE + " INT, "
                                            + COLUMN_PRICE_BRACKET_FOUR + " INT, "
                                            + COLUMN_PRICE_BRACKET_FIVE + " INT, "
                                            + COLUMN_PRICE_BRACKET_SIX + " INT, "
                                            + COLUMN_PRICE_BRACKET_SEVEN + " INT) ";
        db.execSQL(createSpendingTableStatement);
        db.execSQL(createElectricTableStatement);
        db.execSQL(createWaterTableStatement);

        /*
        Code below is to initialize all bill prices id so that it can be updated according to its id.
        For this application, once the main activity is created, the application call the
        updateWaterBillPrice and updateElectricBillPrice below so the value of the id has to be initialized.
         */
        ContentValues cv = new ContentValues();

        for(int i = 1; i <= 3; i++) {
            cv.put(COLUMN_ID, i);
            db.insert(ELECTRIC_TABLE, null, cv);
        }

        for(int j = 1; j <= 18; j++) {
            cv.put(COLUMN_ID, j);
            db.insert(WATER_TABLE, null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SPENDING_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ELECTRIC_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + WATER_TABLE);
        onCreate(db);
    }

    public boolean addOneSpending(Spending spending) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SPENDING_NAME, spending.getName());
        cv.put(COLUMN_SPENDING_TYPE, spending.getType());
        cv.put(COLUMN_SPENDING_DATE, spending.getDate());
        cv.put(COLUMN_SPENDING_PRICE, spending.getPrice());

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
                Spending spending = new Spending(cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getDouble(4),
                                                cursor.getString(3));
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
                Spending spending = new Spending(cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getDouble(4),
                                                cursor.getString(3));
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
                Spending spending = new Spending(cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getDouble(4),
                                                cursor.getString(3));
                spendingList.add(spending);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return spendingList;
    }

    public Double getMonthlyCost() {

        Double sum = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now','start of month') AND '" + COLUMN_SPENDING_DATE + "(now)'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do {

                sum += cursor.getDouble(4);

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
            electricCost = cursor.getDouble(4);
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
            waterCost = cursor.getDouble(4);
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
            spendObject = new Spending(cursor.getDouble(4),
                                        cursor.getString(1),
                                        cursor.getString(2));
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
                sum += cursor.getDouble(4);
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
                sum += cursor.getDouble(4);
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
                sum += cursor.getDouble(4);
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

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 day')";
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

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Electric%' AND " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now','start of month') AND '" + COLUMN_SPENDING_DATE + "(now)'";
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

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Water%' AND " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now','start of month') AND '" + COLUMN_SPENDING_DATE + "(now)'";
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

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Electric%' AND " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 day')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            bill = cursor.getDouble(4);
        }

        db.close();
        cursor.close();
        return bill;
    }

    public Double getLastMonthWaterBill() {
        Double bill = 0.0;

        String queryString = "SELECT * FROM " + SPENDING_TABLE + " WHERE " + COLUMN_SPENDING_TYPE + " LIKE '%Water%' AND " + COLUMN_SPENDING_DATE + " BETWEEN " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 month') AND " + COLUMN_SPENDING_DATE + "('now', 'start of month', '-1 day')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            bill = cursor.getDouble(5);
        }

        db.close();
        cursor.close();
        return bill;
    }

    //Both update bill price code below uses id to update its value.

    public String updateElectricBillPrice(@NotNull ElectricBill electricBill) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        String id = String.valueOf(electricBill.getId());

        cv.put(COLUMN_ELECTRIC_NAME, electricBill.getBillName());
        cv.put(COLUMN_PRICE_BRACKET_ONE, electricBill.getPriceBracketOne());
        cv.put(COLUMN_PRICE_BRACKET_TWO, electricBill.getPriceBracketTwo());
        cv.put(COLUMN_PRICE_BRACKET_THREE, electricBill.getPriceBracketThree());
        cv.put(COLUMN_PRICE_BRACKET_FOUR, electricBill.getPriceBracketFour());
        cv.put(COLUMN_PRICE_BRACKET_FIVE, electricBill.getPriceBracketFive());
        cv.put(COLUMN_PRICE_BRACKET_SIX, electricBill.getPriceBracketSix());
        cv.put(COLUMN_PRICE_BRACKET_SEVEN, electricBill.getPriceBracketSeven());
        cv.put(COLUMN_PRICE_BRACKET_EIGHT, electricBill.getPriceBracketEight());
        cv.put(COLUMN_PRICE_BRACKET_NINE, electricBill.getPriceBracketNine());
        cv.put(COLUMN_PRICE_BRACKET_TEN, electricBill.getPriceBracketTen());
        cv.put(COLUMN_PRICE_BRACKET_ELEVEN, electricBill.getPriceBracketEleven());

        long update = db.update(ELECTRIC_TABLE, cv, "ID = ?", new String[]{id});
        if (update == -1) {
            return "Value of: " + electricBill.getBillName() + " updated";
        } else {
            return "Update failed";
        }
    }

    public String updateWaterBillPrice(@NotNull WaterBill waterBill) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        String id = String.valueOf(waterBill.getId());

        cv.put(COLUMN_WATER_NAME, waterBill.getName());
        cv.put(COLUMN_PRICE_BRACKET_ONE, waterBill.getPriceBracketOne());
        cv.put(COLUMN_PRICE_BRACKET_TWO, waterBill.getPriceBracketTwo());
        cv.put(COLUMN_PRICE_BRACKET_THREE, waterBill.getPriceBracketThree());
        cv.put(COLUMN_PRICE_BRACKET_FOUR, waterBill.getPriceBracketFour());
        cv.put(COLUMN_PRICE_BRACKET_FIVE, waterBill.getPriceBracketFive());
        cv.put(COLUMN_PRICE_BRACKET_SIX, waterBill.getPriceBracketSix());
        cv.put(COLUMN_PRICE_BRACKET_SEVEN, waterBill.getPriceBracketSeven());

        long update = db.update(WATER_TABLE, cv, "ID = ?", new String[]{id});
        if (update == -1) {
            return "Value of: " + waterBill.getName() + " updated";
        } else {
            return "Update failed";
        }
    }

    public ElectricBill getElectricBill(String name) {

        ElectricBill electricBill = null;

        String queryString = "SELECT * FROM " + ELECTRIC_TABLE + " WHERE " + COLUMN_ELECTRIC_NAME + " = '" + name + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            electricBill = new ElectricBill(cursor.getString(1), cursor.getDouble(2),
                                            cursor.getDouble(3), cursor.getDouble(4),
                                            cursor.getDouble(5), cursor.getDouble(6),
                                            cursor.getDouble(7), cursor.getDouble(8),
                                            cursor.getDouble(9), cursor.getDouble(10),
                                            cursor.getDouble(11), cursor.getDouble(12));
        }

        db.close();
        cursor.close();

        return electricBill;
    }

    public WaterBill getWaterBill(String name) {

        WaterBill waterBill = null;

        String queryString = "SELECT * FROM " + WATER_TABLE + " WHERE " + COLUMN_WATER_NAME + " = '" + name + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToLast()) {
            waterBill = new WaterBill(cursor.getString(1), cursor.getDouble(2),
                                    cursor.getDouble(3), cursor.getDouble(4),
                                    cursor.getDouble(5), cursor.getDouble(6),
                                    cursor.getDouble(7), cursor.getDouble(8));
        }

        db.close();
        cursor.close();

        return waterBill;
    }
}
