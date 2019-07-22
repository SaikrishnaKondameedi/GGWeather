package com.example.ggweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.ggweather.model.WeatherData;
import com.example.ggweather.model.WeatherForecastData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

    TextView Location;
    TextView Today;
    TextView weatherData;
    TextView Day1;
    TextView Day2;
    TextView Day3;
    TextView Day4;
    TextView Day5;
    TextView Humidity;

    public static String BaseURL = "http://api.openweathermap.org/";
    public static String appid = "d48ce54fd8cf859dddb937d539946430";
    public static String id = "1277333";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Location = (TextView) findViewById(R.id.textView);
        Today = (TextView) findViewById(R.id.textView3);
        weatherData = (TextView) findViewById(R.id.textView15);
        Day1 = (TextView) findViewById(R.id.textView7);
        Day2 = (TextView) findViewById(R.id.textView8);
        Day3 = (TextView) findViewById(R.id.textView9);
        Day4 = (TextView) findViewById(R.id.textView11);
        Day5 = (TextView) findViewById(R.id.textView12);


        Day1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                sendMessage();
                sendMessage1();
            }
        } );

        Day2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        } );

        Today.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getCurrentData();
                getForecastData();
            }
        });

    }

    void getCurrentData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Weather service = retrofit.create(Weather.class);
        Call<WeatherData> call = service.getCurrentWeatherData(id, appid);


        call.enqueue(new Callback<WeatherData>()
                     {
                         @Override
                         public void onResponse(@NonNull Call<WeatherData> call, @NonNull Response<WeatherData> response)
                         {
                             if (response.code() == 200)
                             {
                                 WeatherData weatherResponse = response.body();
                                 assert weatherResponse != null;

                                 String stringBuilder = weatherResponse.getMain().getTemp().toString()+ " \u2103" +"\n";
                                 weatherData.setText(stringBuilder);

                                 String string1 = weatherResponse.getName() + "," + weatherResponse.getSys().getCountry();
                                 Location.setText(string1);

                             }
                         }

                         @Override
                         public void onFailure(@NonNull Call<WeatherData> call, @NonNull Throwable t)
                         {
                             weatherData.setText(t.getMessage());
                         }
                     }
        );
    }

    void getForecastData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Weather service = retrofit.create(Weather.class);
        Call<WeatherForecastData> call = service.getCurrentForecastData(id, appid);

        call.enqueue(new Callback<WeatherForecastData>()
        {
            @Override
            public void onResponse(@NonNull Call<WeatherForecastData> call, @NonNull Response<WeatherForecastData> response)
            {
                if (response.code() == 200)
                {
                    WeatherForecastData weatherResponse = response.body();
                    assert weatherResponse != null;

                    String stringBuilder1 = weatherResponse.getList().get(0).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day1.setText(stringBuilder1);

                    String stringBuilder2 = weatherResponse.getList().get(8).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day2.setText(stringBuilder2);

                    String stringBuilder3 = weatherResponse.getList().get(16).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day3.setText(stringBuilder3);

                    String stringBuilder4 = weatherResponse.getList().get(24).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day4.setText(stringBuilder4);

                    String stringBuilder5 = weatherResponse.getList().get(32).getMain().getTemp().toString() + " \u2103" + "\n";
                    Day5.setText(stringBuilder5);

                }
            }
            @Override
            public void onFailure(@NonNull Call<WeatherForecastData> call, @NonNull Throwable t)
            {
                Day1.setText(t.getMessage());
            }


    });
    }

        public void sendMessage()
        {
            String value = Day1.getText().toString();
            Intent intent = new Intent( MainActivity.this, Main2Activity.class);
            intent.putExtra("WEATHERVALUE", value);
            startActivity(intent);
        }

        public void sendMessage1()
        {
            String location = Location.getText().toString();
            Intent intent1 = new Intent( MainActivity.this, Main2Activity.class);
            intent1.putExtra("LOCATIONVALUE", location);
            startActivity(intent1);
        }


}
