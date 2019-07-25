package com.example.ggweather;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ggweather.model.List;
import com.example.ggweather.model.WeatherForecastData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {

    TextView Location11;
    TextView weatherData11;
    TextView SlotOne;
    TextView SlotTwo;
    TextView SlotThree;
    TextView SlotFour;
    TextView SlotFive;
    TextView SlotSix;
    TextView SlotSeven;
    TextView SlotEight;


    public static String BaseURL = "http://api.openweathermap.org/";
    public static String appid = "d48ce54fd8cf859dddb937d539946430";
    public static String id = "1277333";
    public static String units = "metric";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );

        Location11 = (TextView) findViewById( R.id.textView32 );
        weatherData11 = (TextView) findViewById( R.id.textView33 );
        SlotOne = (TextView) findViewById( R.id.textView70 );
        SlotTwo = (TextView) findViewById( R.id.textView80 );
        SlotThree = (TextView) findViewById( R.id.textView90 );
        SlotFour = (TextView) findViewById( R.id.textView100 );
        SlotFive = (TextView) findViewById( R.id.textView110 );
        SlotSix = (TextView) findViewById( R.id.textView120 );
        SlotSeven = (TextView) findViewById( R.id.textView130 );
        SlotEight = (TextView) findViewById( R.id.textView140 );


        Intent intent = getIntent();
        String message = intent.getStringExtra( "WEATHERVALUE" );
        weatherData11.setText( message );
        String message2 = intent.getStringExtra( "LOCATIONVALUE" );
        Location11.setText( message2 );

        final ArrayList<List> forecastList1 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotOne.setText(forecastList1.get( 8 ).getMain().getTemp().toString() + "\u2103");

        final ArrayList<List> forecastList2 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotTwo.setText(forecastList2.get( 9 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList3 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotThree.setText(forecastList3.get( 10 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList4 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotFour.setText(forecastList4.get( 11 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList5 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotFive.setText(forecastList5.get( 12 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList6 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotSix.setText(forecastList6.get( 13 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList7 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" ) ;
        SlotSeven.setText(forecastList7.get( 14 ).getMain().getTemp().toString() + "\u2103");

        ArrayList<List> forecastList8 = (ArrayList<List>) getIntent().getSerializableExtra( "HOURLY_DATA" );
        SlotEight.setText(forecastList8.get( 15 ).getMain().getTemp().toString() + "\u2103");


        SlotOne.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotOne.getText().toString());
            }
        } );

        SlotTwo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotTwo.getText().toString());
            }
        } );

        SlotThree.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotThree.getText().toString());
            }
        } );

        SlotFour.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotFour.getText().toString());
            }
        } );

        SlotFive.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotFive.getText().toString());
            }
        } );

        SlotSix.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotSix.getText().toString());
            }
        } );

        SlotSeven.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotSeven.getText().toString());
            }
        } );

        SlotEight.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherData11.setText(SlotEight.getText().toString());
            }
        } );




    }


}

