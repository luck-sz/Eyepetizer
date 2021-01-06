package com.example.eyepetizer.ui.main

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.eyepetizer.BR
import com.example.eyepetizer.R
import com.example.eyepetizer.app.AppViewModelFactory
import com.example.eyepetizer.databinding.ActivityMainBinding
import com.example.eyepetizer.utils.immersionStatusBar
import me.goldze.mvvmhabit.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private var mExitTime: Long = 0

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): MainViewModel {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        val factory: AppViewModelFactory = AppViewModelFactory.getInstance(application)
        return ViewModelProviders.of(this, factory)[MainViewModel::class.java]
    }

    override fun initData() {
        immersionStatusBar(true, android.R.color.white, true, 0.2f)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        //去掉底部默认选中背景
        binding.mBottomNavigationView.itemIconTintList = null
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                Toast.makeText(this, getString(R.string.home_exit_tips), Toast.LENGTH_LONG).show()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
