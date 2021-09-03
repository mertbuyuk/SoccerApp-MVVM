package com.mb.soccerleauge.sharedpref

import android.content.Context
import androidx.core.content.edit
import android.content.Context.MODE_PRIVATE



class SharedPref(context : Context) {

    private val prefs = context.getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE)

    fun save(len : Int,key : String) = prefs.edit(commit = true){
        putInt(key,len)
    }
    fun saveBoolean(value : Boolean,key : String) = prefs.edit(commit = true){
        putBoolean(key,value)
    }

    fun loadBoolen(key : String): Boolean = prefs.getBoolean(key, false)

    fun load(key : String): Int = prefs.getInt(key, 0)

    companion object {
        const val PREFS_FILE_NAME = "fixture"
    }
}
