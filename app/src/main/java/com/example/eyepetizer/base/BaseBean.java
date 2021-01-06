package com.example.eyepetizer.base;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;

public class BaseBean implements Serializable {

    private String status;
    private String msg = "";
    private Object data;
    private Object post;

    public <E> E getResultBean(Class<E> eClass){
        if (data == null){
            return null;
        }
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(gson.toJson(data),eClass);
    }

    public <T> T getResultList(TypeToken<T> token){
        if (data == null || TextUtils.isEmpty(data.toString())){
            return null;
        }
        Type type = token.getType();
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(gson.toJson(data),type);
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        if (TextUtils.isEmpty(status)) return "";
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getPost() {
        return post;
    }

    public void setPost(Object post) {
        this.post = post;
    }
}
