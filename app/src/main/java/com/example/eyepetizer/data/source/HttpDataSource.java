package com.example.eyepetizer.data.source;

import com.example.eyepetizer.base.BaseBean;
import com.example.eyepetizer.entity.BannerBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {

    //获取轮播图
    Observable<BaseBean> getBanner();

}
