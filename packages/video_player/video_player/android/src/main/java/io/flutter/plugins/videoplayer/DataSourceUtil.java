package io.flutter.plugins.videoplayer;

import android.content.Context;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;

class DataSourceUtil {

    private static DataSource.Factory defaultDataSourceFactory = null;
    private static HttpDataSource.Factory defaultHttpDataSourceFactory = null;
    private static String userAgent = null;

    private static String getUserAgent(Context context) {
        if (userAgent == null) {
            userAgent = Util.getUserAgent(context, "FlutterVideo");
        }
        return userAgent;
    }

    static DataSource.Factory getDefaultDataSourceFactory(Context context) {
        if (defaultDataSourceFactory == null) {
            defaultDataSourceFactory = buildDataSourceFactory(context);
        }
        return defaultDataSourceFactory;
    }

    static HttpDataSource.Factory getDefaultHttpDataSourceFactory(Context context) {
        if (defaultHttpDataSourceFactory == null) {
            defaultHttpDataSourceFactory = buildHttpDataSourceFactory(context);
        }
        return defaultHttpDataSourceFactory;
    }

    private static DataSource.Factory buildDataSourceFactory(Context context) {
        return new DefaultDataSourceFactory(context, getDefaultHttpDataSourceFactory(context));
    }

    private static HttpDataSource.Factory buildHttpDataSourceFactory(Context context) {
        return new DefaultHttpDataSourceFactory(
                getUserAgent(context),
                null,
                DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS,
                true);
    }
}
