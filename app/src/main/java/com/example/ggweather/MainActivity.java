package com.example.ggweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ggweather.model.List;
import com.example.ggweather.model.WeatherData;
import com.example.ggweather.model.WeatherForecastData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView Location;
    TextView Today;
    TextView weatherData;
    TextView Day1;
    TextView Day2;
    TextView Day3;
    TextView Day4;
    TextView Day5;
    WeatherForecastData weatherForecastData;

    public static String BaseURL = "http://api.openweathermap.org/";
    public static String appid = "d48ce54fd8cf859dddb937d539946430";
    public static String id = "1277333";
    public static String units = "metric";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Location = (TextView) findViewById( R.id.textView );
        Today = (TextView) findViewById( R.id.textView3 );
        weatherData = (TextView) findViewById( R.id.textView15 );
        Day1 = (TextView) findViewById( R.id.textView7 );
        Day2 = (TextView) findViewById( R.id.textView8 );
        Day3 = (TextView) findViewById( R.id.textView9 );
        Day4 = (TextView) findViewById( R.id.textView11 );
        Day5 = (TextView) findViewById( R.id.textView12 );


        Day1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weatherForecastData == null) {
                    return;
                }
                sendMessage(new ArrayList<List>(weatherForecastData.getList().subList(0, 8)));
            }
        } );

        Day2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weatherForecastData == null) {
                    return;
                }
                sendMessage(new ArrayList<List>(weatherForecastData.getList().subList(8, 16)));
            }
        } );

        Day3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weatherForecastData == null) {
                    return;
                }
                sendMessage(new ArrayList<List>(weatherForecastData.getList().subList(16, 24)));
            }
        } );

        Day4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weatherForecastData == null) {
                    return;
                }
                sendMessage(new ArrayList<List>(weatherForecastData.getList().subList(24, 32)));
            }
        } );

        Day5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weatherForecastData == null) {
                    return;
                }
                sendMessage(new ArrayList<List>(weatherForecastData.getList().subList(32, 40)));
            }
        } );



        Today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentData();
            }
        } );

    }

    void getCurrentData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( BaseURL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
        Weather service = retrofit.create( Weather.class );
        Call<WeatherData> call = service.getCurrentWeatherData( id, appid, units );
        Call<WeatherForecastData> call1 = service.getCurrentForecastData( id, appid, units );


        call.enqueue( new Callback<WeatherData>() {
                          @Override
                          public void onResponse(@NonNull Call<WeatherData> call, @NonNull Response<WeatherData> response) {
                              if (response.code() == 200) {
                                  WeatherData weatherResponse = response.body();
                                  assert weatherResponse != null;

                                  String stringBuilder = weatherResponse.getMain().getTemp().toString() + " \u2103" + "\n";
                                  weatherData.setText( stringBuilder );

                                  String string1 = weatherResponse.getName() + " , " + "India";
                                  Location.setText( string1 );

                              }
                          }

                          @Override
                          public void onFailure(@NonNull Call<WeatherData> call, @NonNull Throwable t) {
                              weatherData.setText( t.getMessage() );
                          }
                      }
        );

        call1.enqueue( new Callback<WeatherForecastData>() {
            @Override
            public void onResponse(@NonNull Call<WeatherForecastData> call, @NonNull Response<WeatherForecastData> response) {
                if (response.code() == 200) {
                    weatherForecastData = response.body();
                    assert weatherForecastData != null;

                    String stringBuilder1 = weatherForecastData.getList().get( 0 ).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day1.setText( stringBuilder1 );

                    String stringBuilder2 = weatherForecastData.getList().get( 8 ).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day2.setText( stringBuilder2 );

                    String stringBuilder3 = weatherForecastData.getList().get( 16 ).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day3.setText( stringBuilder3 );

                    String stringBuilder4 = weatherForecastData.getList().get( 24 ).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day4.setText( stringBuilder4 );

                    String stringBuilder5 = weatherForecastData.getList().get( 32 ).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day5.setText( stringBuilder5 );

                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherForecastData> call, @NonNull Throwable t) {
                Day1.setText( t.getMessage() );
            }


        } );
    }

    public void sendMessage(ArrayList<List> data) {
        String value = Day1.getText().toString();
        String location = Location.getText().toString();
        Intent intent = new Intent( MainActivity.this, Main2Activity.class );
        intent.putExtra( "WEATHERVALUE", value );
        intent.putExtra( "LOCATIONVALUE", location );
        intent.putExtra( "HOURLY_DATA", data );
        startActivity(intent);
    }

    public void sendMessage1(ArrayList<List> data){
        String value = Day2.getText().toString();
        String location = Location.getText().toString();
        Intent intent = new Intent( MainActivity.this, Main3Activity.class );
        intent.putExtra( "WEATHERVALUE", value );
        intent.putExtra( "LOCATIONVALUE", location );
        intent.putExtra( "HOURLY_DATA", data );
        startActivity(intent);
    }

    public void sendMessage2(ArrayList<List> data){
        String value = Day3.getText().toString();
        String location = Location.getText().toString();
        Intent intent = new Intent( MainActivity.this, Main4Activity.class );
        intent.putExtra( "WEATHERVALUE", value );
        intent.putExtra( "LOCATIONVALUE", location );
        intent.putExtra( "HOURLY_DATA", data );
        startActivity(intent);
    }

    public void sendMessage3(ArrayList<List> data){
        String value = Day4.getText().toString();
        String location = Location.getText().toString();
        Intent intent = new Intent( MainActivity.this, Main5Activity.class );
        intent.putExtra( "WEATHERVALUE", value );
        intent.putExtra( "LOCATIONVALUE", location );
        intent.putExtra( "HOURLY_DATA", data );
        startActivity(intent);
    }

    public void sendMessage4(ArrayList<List> data){
        String value = Day5.getText().toString();
        String location = Location.getText().toString();
        Intent intent = new Intent( MainActivity.this, Main6Activity.class );
        intent.putExtra( "WEATHERVALUE", value );
        intent.putExtra( "LOCATIONVALUE", location );
        intent.putExtra( "HOURLY_DATA", data );
        startActivity(intent);
    }
}
