package com.example.newheroapp.domain.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.newheroapp.domain.local.Hero


@Dao
interface HeroDao {

     @Query("select * from hero_table order by id ASC")
    fun getAllHeroList():PagingSource<Int, Hero>

    @Query("select * from hero_table where id =:heroId")
    fun getSelectedHero(heroId :Int):Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun addHero(hero: List<Hero>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAll()

}