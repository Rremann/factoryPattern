package com.example.rmann.factorypattern;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by rmann on 12/2/15.
 */
public class ServiceFactory {

    Context mContext;

    public ServiceFactory(Context context) {
        mContext = context;
    }

    /**
     * Creates your provider or returns
     *
     * @param provider
     * @return will return null if no provider found
     */
    @Nullable
    public CableService selectProvider(Provider provider) {
        switch (provider) {
            case HULU:
                return new Hulu();
            case NETFLIX:
                return new Netflix();
            case UNKNOWN:
            default:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Toast.makeText(mContext, "Unknown Service Provider", Toast.LENGTH_LONG).show();
                    }
                }).run();
        }
        return null;
    }

    public enum Provider {
        HULU("hulu"),
        NETFLIX("netflix"),
        UNKNOWN("unknown");
        private final String name;

        Provider(String name) {
            this.name = name;
        }

        public static Provider from(String name) {
            for (Provider p : Provider.values()) {
                if (p.name.equalsIgnoreCase(name)) {
                    return p;
                }
            }
            return UNKNOWN;
        }

    }

}

