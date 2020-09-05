package com.padcx.podcastapp_hhh.persistent.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.podcastapp_hhh.data.vo.PodcastVO

class PodCastConverter {
    @TypeConverter
    fun toString(dataList: PodcastVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): PodcastVO {
        val dataListType = object : TypeToken<PodcastVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}