package com.example.eyepetizer.base.api;

import com.example.eyepetizer.base.BaseBean;
import com.example.eyepetizer.entity.BannerBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by goldze on 2017/6/15.
 */

public interface ApiService {

    @GET("banner/json")
    Observable<BaseBean> getBanner();

}
