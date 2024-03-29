package com.tuxdev.coroutines.di

import com.tuxdev.coroutines.utils.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 **********************************************
 * Created by ukie on 10/4/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2018 | All Right `
 */


//TODO change with project name sample tiketViewModel
val baseViewModel = module {
    // TODO define view model to inject
//    viewModel { LoginViewModel(get()) }
}

val globalModule = module {
    single { PrefManager(androidContext()) }
}
val baseApp = listOf(baseViewModel, networkModule, globalModule, roomModule)