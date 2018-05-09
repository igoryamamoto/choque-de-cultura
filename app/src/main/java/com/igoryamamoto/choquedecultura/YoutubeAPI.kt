package com.igoryamamoto.choquedecultura

interface YoutubeApi {

    @GET("playlistItems?playlistId=PLTeqfOQzqJNyUjKVEogo5AA1O_w2m1hO3&maxResults=8&part=snippet&key=AIzaSyBBk2f6v9_C6ozKEeJ8Bm42RMM1veFhzqw")
    fun listVideos(): Call<YoutubeResult>

}
