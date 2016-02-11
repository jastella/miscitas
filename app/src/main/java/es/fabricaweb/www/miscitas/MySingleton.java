package es.fabricaweb.www.miscitas;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.security.PublicKey;


public class MySingleton {

    public static final String TAG = MySingleton.class.getSimpleName();
    private static MySingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private MySingleton(Context context) {
        MySingleton.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new MySingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }

}
