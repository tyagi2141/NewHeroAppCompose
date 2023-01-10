package com.example.newheroapp.domain.local.dao

import androidx.room.*
import com.example.newheroapp.domain.local.HeroRemoteKey

@Dao
 interface HeroRemoteKeyDao {

    @Query("Select * from hero_remote_key_database_table where id =:heroId")
     fun getRemoteKey(heroId:Int):HeroRemoteKey?

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addRemoteKey(heroRemoteKey: List<HeroRemoteKey>)

     @Query("DELETE from hero_remote_key_database_table")
     fun deleteHeroRemoteKey()
}