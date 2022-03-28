package com.example.week5roomsasn
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "donut_table")
data class Donut(@PrimaryKey(autoGenerate = true)
    var donutID:Long = 0L,

    @ColumnInfo(name = "donut_amount")
    var donutAmount: Int = 0

    //@ColumnInfo(name = "task_done")
    //var taskDone: Boolean = false
)

