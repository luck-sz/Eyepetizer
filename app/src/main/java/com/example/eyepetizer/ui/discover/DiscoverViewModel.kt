package com.example.eyepetizer.ui.discover

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.eyepetizer.data.BaseRepository
import me.goldze.mvvmhabit.base.BaseViewModel

class DiscoverViewModel(
    application: Application,
    repository: BaseRepository?
) :
    BaseViewModel<BaseRepository?>(application, repository) {

}

