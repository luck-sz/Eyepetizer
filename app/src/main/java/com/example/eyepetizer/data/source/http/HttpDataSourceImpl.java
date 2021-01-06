package com.example.eyepetizer.data.source.http;

import com.example.eyepetizer.base.BaseBean;
import com.example.eyepetizer.base.api.ApiService;
import com.example.eyepetizer.data.source.HttpDataSource;
import com.example.eyepetizer.entity.BannerBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by goldze on 2019/3/26.
 */
public class HttpDataSourceImpl implements HttpDataSource {
    private ApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseBean> getBanner() {
        return apiService.getBanner();
    }
}
