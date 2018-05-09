package com.igoryamamoto.choquedecultura

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.igoryamamoto.choquedecultura.Models.YoutubeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchYoutubeVideos()
    }

    private fun fetchYoutubeVideos() {
        val retrofit = RetrofitHelper.getRetrofit()
        val api = retrofit?.create(YoutubeApi::class.java)
        api?.listVideos()?.enqueue(object : Callback<YoutubeResult> {
            override fun onFailure(call: Call<YoutubeResult>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<YoutubeResult>?, response: Response<YoutubeResult>?) {

            }
        })
    }
}
