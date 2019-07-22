package com.example.ggweather;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.ggweather.model.WeatherForecastData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity
{

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Location11 = (TextView) findViewById(R.id.textView32);
        weatherData11 = (TextView) findViewById(R.id.textView33);
        SlotOne = (TextView) findViewById(R.id.textView70);
        SlotTwo = (TextView) findViewById(R.id.textView80);
        SlotThree = (TextView) findViewById(R.id.textView90);
        SlotFour = (TextView) findViewById(R.id.textView100);
        SlotFive = (TextView) findViewById(R.id.textView110);
        SlotSix = (TextView) findViewById(R.id.textView120);
        SlotSeven = (TextView) findViewById(R.id.textView130);
        SlotEight = (TextView) findViewById(R.id.textView140);


        Intent intent = getIntent();
        String message = intent.getStringExtra("WEATHERVALUE");
        weatherData11.setText(message);

        Intent intent2 = getIntent();
        String message2 = intent2.getStringExtra("LOCATIONVALUE");
        Location11.setText(message2);


        SlotOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot1();
            }
        });

        SlotTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot2();
            }
        });

        SlotThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot3();
            }
        });

        SlotFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot4();
            }
        });

        SlotFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot5();
            }
        });

        SlotSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot6();
            }
        });

        SlotSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot7();
            }
        });

        SlotEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getForecastDataSlot8();
            }
        });


    }

    void getForecastDataSlot1()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot1temp = Response.getList().get(0).getMain().getTemp().toString() + " \u2103" + "\n";
                    weatherData11.setText(Slot1temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot2()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot2temp = Response.getList().get(1).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot2temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot3()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot3temp = Response.getList().get(2).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot3temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot4()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot4temp = Response.getList().get(3).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot4temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot5()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot5temp = Response.getList().get(4).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot5temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot6()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot6temp = Response.getList().get(5).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot6temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot7()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot7temp = Response.getList().get(6).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot7temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

    void getForecastDataSlot8()
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
            public void onResponse(Call<WeatherForecastData> call, Response<WeatherForecastData> response)
            {
                if(response.code() == 200)
                {
                    WeatherForecastData Response = response.body();
                    assert Response != null;

                    String Slot8temp = Response.getList().get(7).getMain().getTemp().toString() + " \u2103";
                    weatherData11.setText(Slot8temp);

                }
            }

            @Override
            public void onFailure(Call<WeatherForecastData> call, Throwable t)
            {
                Location11.setText(t.getMessage());
            }
        });
    }

}





