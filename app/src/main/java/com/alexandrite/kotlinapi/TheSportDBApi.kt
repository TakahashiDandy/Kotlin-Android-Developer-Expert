package com.alexandrite.kotlinapi

import android.net.Uri

object TheSportDBApi{
    fun getTeams(league: String?) : String{
        var BASE_URL = "https://www.thesportsdb.com/"
        var API_KEY = "1"
        return Uri.parse(BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(API_KEY)
                .appendPath("search_all_teams.php")
                .appendQueryParameter("l",league)
                .build()
                .toString()
    }
}