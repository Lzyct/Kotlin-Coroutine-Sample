package com.tuxdev.coroutines.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 **********************************************
 * Created by ukie on 2/4/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */

//TODO replace DataBase with your table name
@Database(entities = [Cats::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    abstract fun dataBase(): CatDao
}