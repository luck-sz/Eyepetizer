package com.example.eyepetizer.ui.main

import android.app.Application
import android.util.Log
import com.example.eyepetizer.base.BaseBean
import com.example.eyepetizer.data.BaseRepository
import com.example.eyepetizer.utils.NetCallback
import me.goldze.mvvmhabit.base.BaseViewModel
import me.goldze.mvvmhabit.utils.KLog

class MainViewModel(
    application: Application,
    repository: BaseRepository?
) :
    BaseViewModel<BaseRepository?>(application, repository) {



}