package com.tuxdev.coroutines.ui.home

import com.tuxdev.coroutines.R
import com.tuxdev.coroutines.base.BaseFragment
import com.tuxdev.coroutines.databinding.FragmentHomeBinding

/**
 **********************************************
 * Created by ukietux on 2019-09-02 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/ukieTux <(’_’<)
 * What project name is ? - kotlin-coroutine-sample
 **********************************************
 * © 2019 | All Right Reserved
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutResource(): Int = R.layout.fragment_home

    override fun myCodeHere() {
        bind.lifecycleOwner = this
    }
}