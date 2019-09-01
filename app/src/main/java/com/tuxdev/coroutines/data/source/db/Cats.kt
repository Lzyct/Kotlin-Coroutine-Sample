package com.tuxdev.coroutines.data.source.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 **********************************************
 * Created by ukie on 2/4/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */

//TODO add field later
@Entity(tableName = "cat_table")
data class Cats(
        @PrimaryKey(autoGenerate = true)
        val id: Int
)