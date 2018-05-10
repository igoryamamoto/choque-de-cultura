package com.igoryamamoto.choquedecultura

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.igoryamamoto.choquedecultura.Models.YoutubeItem
import com.igoryamamoto.choquedecultura.Models.YoutubeResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity: AppCompatActivity(), VideoClickListener {

    val adapter = YoutubeAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        fetchYoutubeVideos()
    }

    private fun fetchYoutubeVideos() {
        val retrofit = RetrofitHelper.getRetrofit()
        val api = retrofit?.create(YoutubeApi::class.java)

        api?.listVideos()?.enqueue(object : Callback<YoutubeResult> {
            override fun onFailure(call: Call<YoutubeResult>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<YoutubeResult>?, response: Response<YoutubeResult>?) {
                adapter.items = response?.body()?.items ?: emptyList()
            }
        })
    }

    override fun onItemClicked(item: YoutubeItem) {
        val id = item.snippet?.resourceId?.videoId ?: return
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=$id"))
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }
}
