package com.app.koltinpoc.db

import androidx.room.TypeConverter
import com.app.koltinpoc.db.entity.SourceEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    val gson = Gson()

    @TypeConverter
    fun toSourceEntityToString(sourceEntity: SourceEntity): String {

        val type = object : TypeToken<SourceEntity>() {}.type
        return gson.toJson(sourceEntity, type)
    }

    @TypeConverter
    fun fromStringToSourceEntity(string: String): SourceEntity {

        val type = object : TypeToken<SourceEntity>() {}.type
        return gson.fromJson<SourceEntity>(string, type)

    }

}