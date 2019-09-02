package com.tuxdev.coroutines.ui

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tuxdev.coroutines.R
import com.tuxdev.coroutines.base.BaseActivity
import com.tuxdev.coroutines.databinding.ActivityMainBinding
import com.tuxdev.coroutines.utils.setupWithNavController

/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getToolbarResource(): Int = R.id.toolbar

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun myCodeHere() {
        setupBottomNavigationBar()
    }

    private var currentNavController: LiveData<NavController>? = null

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        //register navigation scheme
        val navGraphIds = listOf(R.navigation.list_home, R.navigation.list_favorite)

        // Setup the bottom navigation view with a list of navigation graphs
        // Support save state see on utils -> NavigationExtensions.kt
        val controller = bottomNavigationView.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.nav_host_container,
                intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}