package com.example.week5roomsasn

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DonutDao {
    @Insert
    suspend fun insert(donut:Donut)

    @Update
    suspend fun update(donut:Donut)

    @Delete
    suspend fun delete(donut:Donut)

    @Query("SELECT * FROM donut_table ORDER BY donutID DESC LIMIT 1")
    fun get(): LiveData<Donut>

    @Query("SELECT * FROM donut_table ORDER BY donutID DESC")
    fun getAll():LiveData<List<Donut>>

}