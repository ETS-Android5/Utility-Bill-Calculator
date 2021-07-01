package com.example.android.utilitybillcalculator.logic;

import android.app.Application;

import com.example.android.utilitybillcalculator.database.DatabaseHelper;
import com.example.android.utilitybillcalculator.entities.ElectricBill;
import com.example.android.utilitybillcalculator.entities.WaterBill;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class UpdateBillPrice extends Application {

    DatabaseHelper dbHelper;

    public UpdateBillPrice(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    // Made this helper method to update all bill prices at once in the main activity.
    public String updateAllBillPrice() {
        int i = 0;
        i += updateTenagaNasional();
        i += updateSarawakEnergy();
        i += updateSabahElectricity();
        i += updateJohorWater();
        i += updateKedahWater();
        i += updateKelantanWater();
        i += updateMelakaWater();
        i += updateNegeriSembilanWater();
        i += updatePahangWater();
        i += updatePenangWater();
        i += updatePerakWater();
        i += updatePerlisWater();
        i += updateSelangorWater();
        i += updateTerengganuWater();
        i += updateSarawakWater();
        i += updateKuchingWater();
        i += updateSibuWater();
        i += updateSriAmanWater();
        i += updateBintuluWater();
        i += updateSabahWater();
        i += updateLabuanWater();

        // Used the int returned from each method to return update status to the main activity.
        if(i <= 21) {
            return "Bill price updated!";
        } else {
            return "Something went wrong";
        }
    }

    /*
    All bill prices are updated seperately.
    Jackson is used to convert JSON to POJO.
    Each update method returns an int.
    If the int returned is 0, the connection failed.
    If the int returned is 1, the update succeed.
    If the int returned is 3, something else went wrong.
     */

    public int updateTenagaNasional() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/electric/1", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    ElectricBill electricBill = mapper.readValue(responseString, ElectricBill.class);
                    System.out.println(">> Inside onSuccess: " + electricBill.getBillName());
                    dbHelper.updateElectricBillPrice(electricBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSarawakEnergy() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/electric/2", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    ElectricBill electricBill = mapper.readValue(responseString, ElectricBill.class);
                    System.out.println(">> Inside onSuccess: " + electricBill.getBillName());
                    dbHelper.updateElectricBillPrice(electricBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSabahElectricity() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/electric/3", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    ElectricBill electricBill = mapper.readValue(responseString, ElectricBill.class);
                    System.out.println(">> Inside onSuccess: " + electricBill.getBillName());
                    dbHelper.updateElectricBillPrice(electricBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateJohorWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/1", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateKedahWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/2", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateKelantanWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/3", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateMelakaWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/4", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateNegeriSembilanWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/5", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updatePahangWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/6", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updatePenangWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/7", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updatePerakWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/8", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updatePerlisWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/9", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSelangorWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/10", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateTerengganuWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/11", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSarawakWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/12", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateKuchingWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/13", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSibuWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/14", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSriAmanWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/15", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateBintuluWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/16", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateSabahWater() {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/17", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }

    public int updateLabuanWater()  {

        int i = 0;
        ObjectMapper mapper = new ObjectMapper();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.104:8080/api/water/18", new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                System.out.println(">> Starting update");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(">> Inside onFail, CODE: " + statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    WaterBill waterBill = mapper.readValue(responseString, WaterBill.class);
                    System.out.println(">> Inside onSuccess: " + waterBill.getName());
                    dbHelper.updateWaterBillPrice(waterBill);
                    int i = 1;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    int i = 3;
                }
            }
        });
        return i;
    }
}
