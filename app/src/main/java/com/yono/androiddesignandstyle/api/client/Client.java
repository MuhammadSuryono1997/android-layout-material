package com.yono.androiddesignandstyle.api.client;

import com.yono.androiddesignandstyle.api.ApiHelper;

public class Client {
    public <T> T Client(Class<T> service, String basUrl){
        return ApiHelper.client(basUrl).create(service);
    }
}
