package com.stornit.e_commerceapp.singletonclass;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    private RequestQueue requestQueue;
    private static MyApplication myApplication;

    public void onCreate(){
        super.onCreate();
        myApplication = this;
    }

    public static synchronized MyApplication getInstance(){
        return myApplication;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void canclePendingRequests(Object tag){
        if (requestQueue != null){
            requestQueue.cancelAll(tag);
        }
    }
}
