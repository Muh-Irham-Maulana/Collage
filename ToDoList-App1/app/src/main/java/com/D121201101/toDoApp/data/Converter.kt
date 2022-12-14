package com.D121201101.toDoApp.data

import androidx.room.TypeConverter
import com.D121201101.toDoApp.data.models.Priority

class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}