package com.tmf.room_exam_kotlin

import androidx.room.Database
import androidx.room.RoomDatabase

// https://developer.android.com/training/data-storage/room?hl=en#kts
@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}