package com.example.testgame.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {

    var data: SharedPreferences = context.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    fun getHighScore(): Int{
        return data.getInt("HIGH_SCORE", 0)
    }

    fun clearHighScore(){
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }

    fun saveHighScore(score: Int){
        data.edit().putInt("HIGH_SCORE", score)
    }
}