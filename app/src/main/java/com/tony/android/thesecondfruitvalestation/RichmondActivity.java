package com.tony.android.thesecondfruitvalestation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RichmondActivity extends AppCompatActivity {
    TextView firstTime;
    TextView firstColor;
    TextView firstLength;

    TextView secondTime;
    TextView secondColor;
    TextView secondLength;

    TextView thirdTime;
    TextView thirdColor;
    TextView thirdLength;

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_richmond);

        firstTime = findViewById(R.id.firstTrainTime);
        secondTime = findViewById(R.id.secondTrainTime);
        thirdTime = findViewById(R.id.thirdTrainTime);

        firstColor = findViewById(R.id.firstTrainColor);
        secondColor = findViewById(R.id.secondTrainColor);
        thirdColor = findViewById(R.id.thirdTrainColor);

        firstLength = findViewById(R.id.firstTrainLength);
        secondLength = findViewById(R.id.secondTrainLength);
        thirdLength = findViewById(R.id.thirdTrainLength);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.bart.gov/api/etd.aspx?cmd=etd&orig=ftvl&json=y&key=MW9S-E7SL-26DU-VV8V";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //JSON traversal
                        try {
                            JSONObject responseJson = new JSONObject(response);
                            JSONObject root = responseJson.getJSONObject("root");
                            JSONArray station = root.getJSONArray("station");
                            JSONObject fruitvale = station.getJSONObject(0);
                            JSONArray etd = fruitvale.getJSONArray("etd");
                            JSONObject richmond = etd.getJSONObject(2);
                            JSONArray estimate = richmond.getJSONArray("estimate");
                            JSONObject trainOne = estimate.getJSONObject(0);
                            JSONObject trainTwo = estimate.getJSONObject(1);
                            JSONObject trainThree = estimate.getJSONObject(2);

                            String trainOneMinutes = trainOne.getString("minutes");
                            String trainOneColor = trainOne.getString("color");
                            String trainOneLength = trainOne.getString("length");

                            String trainTwoMinutes = trainTwo.getString("minutes");
                            String trainTwoColor = trainTwo.getString("color");
                            String trainTwoLength = trainTwo.getString("length");

                            String trainThreeMinutes = trainThree.getString("minutes");
                            String trainThreeColor = trainThree.getString("color");
                            String trainThreeLength = trainThree.getString("length");


                            firstTime.setText(trainOneMinutes + " minutes");
                            firstColor.setText(trainOneColor);
                            firstLength.setText(trainOneLength + " cars");

                            secondTime.setText(trainTwoMinutes + " minutes");
                            secondColor.setText(trainTwoColor);
                            secondLength.setText(trainTwoLength + " cars");

                            thirdTime.setText(trainThreeMinutes + " minutes");
                            thirdColor.setText(trainThreeColor);
                            thirdLength.setText(trainThreeLength + " cars");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    public void checkTimes(View view) {
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.bart.gov/api/etd.aspx?cmd=etd&orig=ftvl&json=y&key=MW9S-E7SL-26DU-VV8V";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //JSON traversal
                        try {
                            JSONObject responseJson = new JSONObject(response);
                            JSONObject root = responseJson.getJSONObject("root");
                            JSONArray station = root.getJSONArray("station");
                            JSONObject fruitvale = station.getJSONObject(0);
                            JSONArray etd = fruitvale.getJSONArray("etd");
                            JSONObject richmond = etd.getJSONObject(2);
                            JSONArray estimate = richmond.getJSONArray("estimate");
                            JSONObject trainOne = estimate.getJSONObject(0);
                            JSONObject trainTwo = estimate.getJSONObject(1);
                            JSONObject trainThree = estimate.getJSONObject(2);

                            String trainOneMinutes = trainOne.getString("minutes");
                            String trainOneColor = trainOne.getString("color");
                            String trainOneLength = trainOne.getString("length");

                            String trainTwoMinutes = trainTwo.getString("minutes");
                            String trainTwoColor = trainTwo.getString("color");
                            String trainTwoLength = trainTwo.getString("length");

                            String trainThreeMinutes = trainThree.getString("minutes");
                            String trainThreeColor = trainThree.getString("color");
                            String trainThreeLength = trainThree.getString("length");


                            firstTime.setText(trainOneMinutes + " minutes");
                            firstColor.setText(trainOneColor);
                            firstLength.setText(trainOneLength + " cars");

                            secondTime.setText(trainTwoMinutes + " minutes");
                            secondColor.setText(trainTwoColor);
                            secondLength.setText(trainTwoLength + " cars");

                            thirdTime.setText(trainThreeMinutes + " minutes");
                            thirdColor.setText(trainThreeColor);
                            thirdLength.setText(trainThreeLength + " cars");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
