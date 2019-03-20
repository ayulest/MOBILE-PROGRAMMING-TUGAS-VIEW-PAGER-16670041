package com.ayulest.latihanmp2.rest


import com.ayulest.latihanmp2.model.ResultsItem
import com.ayulest.latihanmp2.model.Upcoming
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("upcoming?api_key=bf1d87498e79a2e3651c1946519b5419&language=en-US&page=1")
    fun getALLPost():Observable<Upcoming>
    @GET("now_playing?api_key=bf1d87498e79a2e3651c1946519b5419&language=en-US&page=1")
    fun getALLPostPlaying():Observable<Upcoming>
}