package com.example.newheroapp.domain.local

import androidx.room.TypeConverter
import java.lang.StringBuilder

class DataConverter {

    private val separator =","

    @TypeConverter
    fun convertListToString(list: List<String>): String {

        val stringBuilder = StringBuilder()
        for (item in stringBuilder){
            stringBuilder.append(item).append(separator)
        }
        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }

}