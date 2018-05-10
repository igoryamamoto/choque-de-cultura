package com.igoryamamoto.choquedecultura.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class YoutubeDefaultThumbnail {

    @Expose
    @SerializedName("url")
    var url: String? = null

    /*
        "default": {
            "url": "https://i.ytimg.com/vi/8VmbLF3-Aww/default.jpg",
            "width": 120,
            "height": 90
        },

     */

}
