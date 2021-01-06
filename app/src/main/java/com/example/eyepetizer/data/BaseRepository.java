package com.example.eyepetizer.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.example.eyepetizer.base.BaseBean;
import com.example.eyepetizer.data.source.HttpDataSource;
import com.example.eyepetizer.data.source.LocalDataSource;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import me.goldze.mvvmhabit.base.BaseModel;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class BaseRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static BaseRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private BaseRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static BaseRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (BaseRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * 网络请求封装 oneOperation
     *
     * @param checking 校验输入框是否输入（布尔值要子类判断），如没输入框，则传true
     * @param function 根据布尔值进行网络请求，例如 Function泛型== Function<Boolean, ObservableSource<UserBean>>
     * @param observer 网络请求回调
     */
    //@param lifecycle 内存管理对象，activity 继承 AppCompatActivity可得，传this
    public <T extends BaseBean> void oneOperation(boolean checking,
                                                  Function<Boolean, ObservableSource<T>> function,
                                                  io.reactivex.Observer<T> observer) {
        Observable<T> observe = Observable.just(checking)
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<Boolean>() {
                    @Override
                    public boolean test(Boolean aBoolean) {
                        return aBoolean;
                    }
                })
                .flatMap(function)
                .observeOn(AndroidSchedulers.mainThread());
        observe.subscribe(observer);
    }

    @Override
    public Observable<BaseBean> getBanner() {
        return mHttpDataSource.getBanner();
    }
}
