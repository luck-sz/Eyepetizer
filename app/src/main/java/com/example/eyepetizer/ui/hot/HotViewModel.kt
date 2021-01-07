package com.example.eyepetizer.ui.hot

import android.app.Application
import com.example.eyepetizer.data.BaseRepository
import me.goldze.mvvmhabit.base.BaseViewModel

class HotViewModel(
    application: Application,
    repository: BaseRepository?
) :
    BaseViewModel<BaseRepository?>(application, repository) {

}