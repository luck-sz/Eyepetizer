package com.example.eyepetizer.ui.discover

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eyepetizer.BR

import com.example.eyepetizer.R
import com.example.eyepetizer.app.AppViewModelFactory
import com.example.eyepetizer.databinding.FragmentDiscoverBinding
import me.goldze.mvvmhabit.base.BaseFragment

class DiscoverFragment : BaseFragment<FragmentDiscoverBinding,DiscoverViewModel>() {

    companion object {
        fun newInstance() = DiscoverFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_discover
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): DiscoverViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: AppViewModelFactory = AppViewModelFactory.getInstance(_mActivity.application)
        return ViewModelProviders.of(this, factory)[DiscoverViewModel::class.java]
    }
}
