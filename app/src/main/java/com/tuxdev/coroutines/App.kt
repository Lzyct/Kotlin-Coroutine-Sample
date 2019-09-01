package com.tuxdev.coroutines

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.tuxdev.coroutines.di.baseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * *********************************************
 * Created by ukie on 9/26/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2018 | All Right Reserved
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(1)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("CatTag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        //Insert Koin
        startKoin {
            Logger.e("koin start")
            androidContext(this@App)
            modules(baseApp)
        }

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
