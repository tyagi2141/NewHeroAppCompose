package com.example.newheroapp.domain.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_remote_key_database_table")
data class HeroRemoteKey(

    @PrimaryKey(autoGenerate = false)
    val id :Int?,
    val prevKey:Int?,
    val nextKey:Int?
)
