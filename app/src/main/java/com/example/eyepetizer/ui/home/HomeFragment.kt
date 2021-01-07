package com.example.eyepetizer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.eyepetizer.BR

import com.example.eyepetizer.R
import com.example.eyepetizer.app.AppViewModelFactory
import com.example.eyepetizer.databinding.FragmentHomeBinding
import me.goldze.mvvmhabit.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): HomeViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: AppViewModelFactory = AppViewModelFactory.getInstance(_mActivity.application)
        return ViewModelProviders.of(this, factory)[HomeViewModel::class.java]
    }
}
