package com.ayulest.latihanmp2.rest

import com.ayulest.latihanmp2.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    fun getALLPost():Observable<List<Post>>
}