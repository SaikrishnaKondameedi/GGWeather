
package com.example.ggweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Main implements Serializable {

    @SerializedName("temp")
    @Expose
    private Double temp;

    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp)
    {
        this.temp = temp;
    }
}