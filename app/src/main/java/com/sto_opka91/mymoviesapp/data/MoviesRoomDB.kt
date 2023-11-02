package com.sto_opka91.mymoviesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sto_opka91.mymoviesapp.data.room.dao.MoviesDao
import com.sto_opka91.mymoviesapp.model.Film

@Database(entities = [Film::class], version = 1)
abstract class MoviesRoomDB:RoomDatabase() {
    abstract fun getMovieDao(): MoviesDao
    companion object{
        private var database:MoviesRoomDB ?=null
        fun getInstance(context: Context): MoviesRoomDB{
            return if(database==null){
                database = Room
                    .databaseBuilder(context, MoviesRoomDB::class.java, "db")
                    .build()
                database as MoviesRoomDB
            }else{
                database as MoviesRoomDB
            }
        }
    }
}