package uk.ac.tees.scdt.mad.w9544759.ReddyWeatherApp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?appid=a4a676a6e98031adac3f147e984c9329&units=metric")
    Call<OpenWeatherMap>getWeatherWithLocation(@Query("lat")double lat,@Query("lon")double lon);

    @GET("weather?appid=a4a676a6e98031adac3f147e984c9329&units=metric")
    Call<OpenWeatherMap>getWeatherWithCityName(@Query("q")String name);
}
