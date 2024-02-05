package com.example.linkanotherpage.api;

import com.example.linkanotherpage.model.ClubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClubApi {


    @GET("purbacal.php?action= read")
    Call<List<ClubModel>> getClub();
}
