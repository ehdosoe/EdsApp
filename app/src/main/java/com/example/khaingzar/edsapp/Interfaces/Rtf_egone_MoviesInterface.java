package com.example.khaingzar.edsapp.Interfaces;

import com.example.khaingzar.edsapp.Models.Rtf_egone_Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Khaing Zar on 5/21/2018.
 */

public interface Rtf_egone_MoviesInterface {

    @GET("/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json")
    Call <List<Rtf_egone_Movies>> getJSON();
}
