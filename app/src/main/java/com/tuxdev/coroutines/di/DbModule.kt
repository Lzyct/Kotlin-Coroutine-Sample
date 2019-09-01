package com.tuxdev.coroutines.di

import androidx.room.Room
import com.tuxdev.coroutines.data.source.db.AppDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 **********************************************
 * Created by ukie on 2/4/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */

//TODO replace base-db with your db name
val roomModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDB::class.java, "base-db")
            .build()
    }
    // Expose WeatherDAO
    single { get<AppDB>().dataBase() }
}