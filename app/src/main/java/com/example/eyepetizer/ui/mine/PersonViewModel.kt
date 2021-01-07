package com.example.eyepetizer.ui.mine

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.eyepetizer.data.BaseRepository
import me.goldze.mvvmhabit.base.BaseViewModel

class PersonViewModel(
    application: Application,
    repository: BaseRepository?
) :
    BaseViewModel<BaseRepository?>(application, repository) {

}
