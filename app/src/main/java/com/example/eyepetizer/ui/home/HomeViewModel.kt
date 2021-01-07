package com.example.eyepetizer.ui.home

import android.app.Application
import com.example.eyepetizer.data.BaseRepository
import me.goldze.mvvmhabit.base.BaseViewModel

class HomeViewModel(
    application: Application,
    repository: BaseRepository?
) :
    BaseViewModel<BaseRepository?>(application, repository) {

}
