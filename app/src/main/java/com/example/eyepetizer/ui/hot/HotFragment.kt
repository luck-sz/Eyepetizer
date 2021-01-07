package com.example.eyepetizer.ui.hot

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eyepetizer.BR

import com.example.eyepetizer.R
import com.example.eyepetizer.app.AppViewModelFactory
import com.example.eyepetizer.databinding.FragmentHotBinding
import me.goldze.mvvmhabit.base.BaseFragment

class HotFragment : BaseFragment<FragmentHotBinding,HotViewModel>() {

    companion object {
        fun newInstance() = HotFragment()
    }

    override fun initContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_hot
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): HotViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: AppViewModelFactory = AppViewModelFactory.getInstance(_mActivity.application)
        return ViewModelProviders.of(this, factory)[HotViewModel::class.java]
    }
}
