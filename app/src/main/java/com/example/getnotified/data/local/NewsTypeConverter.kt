package com.example.getnotified.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.getnotified.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(sourceString: String): Source? { // Handle potential parsing errors
        val sourceArray = sourceString.split(",")
        if (sourceArray.size ==2) { // Ensure we have both id and name
            return Source(id = sourceArray[0], name = sourceArray[1])
        }
        return null // Return null if parsing fails
    }
}