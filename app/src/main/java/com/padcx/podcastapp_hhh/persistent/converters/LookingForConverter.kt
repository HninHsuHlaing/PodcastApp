package com.padcx.podcastapp_hhh.persistent.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.podcastapp_hhh.data.vo.LookingForVO

class LookingForConverter {
    @TypeConverter
    fun toString(dataList: LookingForVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): LookingForVO {
        val dataListType = object : TypeToken<LookingForVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}