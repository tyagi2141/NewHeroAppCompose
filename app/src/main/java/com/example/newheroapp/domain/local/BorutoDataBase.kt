package com.example.newheroapp.domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newheroapp.domain.local.dao.HeroDao
import com.example.newheroapp.domain.local.dao.HeroRemoteKeyDao

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class BorutoDataBase() : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}
