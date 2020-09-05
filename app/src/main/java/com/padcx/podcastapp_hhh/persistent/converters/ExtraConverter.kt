package com.padcx.podcastapp_hhh.persistent.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.podcastapp_hhh.data.vo.ExtraVO

class ExtraConverter {
    @TypeConverter
    fun toString(dataList: ExtraVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): ExtraVO{
        val dataListType = object : TypeToken<ExtraVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}