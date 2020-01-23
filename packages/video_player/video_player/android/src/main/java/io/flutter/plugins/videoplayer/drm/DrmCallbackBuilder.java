package io.flutter.plugins.videoplayer.drm;

import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.upstream.HttpDataSource;

import java.util.Map;

import io.flutter.plugins.videoplayer.drm.titanium.TiMPMediaDrmCallback;

public class DrmCallbackBuilder {

    static public MediaDrmCallback buildDrmCallback(DrmContext drmContext, HttpDataSource.Factory dataSourceFactory) {
        switch(drmContext.getLicenseType()) {
            case TITANIUM: return buildTitaniumDrmCallback(drmContext, dataSourceFactory);
            case UNSPECIFIED:
            default: return buildDefaultDrmCallback(drmContext, dataSourceFactory);
        }
    }

    static private MediaDrmCallback buildDefaultDrmCallback(DrmContext drmContext, HttpDataSource.Factory dataSourceFactory) {
        HttpMediaDrmCallback drmCallback = new HttpMediaDrmCallback(drmContext.getLicenseUrl(), dataSourceFactory);
        String[] keyRequestPropertiesArray = drmContext.getKeyRequestProperties();
        if (keyRequestPropertiesArray != null) {
            for (int i = 0; i < keyRequestPropertiesArray.length - 1; i += 2) {
                drmCallback.setKeyRequestProperty(keyRequestPropertiesArray[i],
                        keyRequestPropertiesArray[i + 1]);
            }
        }
        return drmCallback;
    }

    static private MediaDrmCallback buildTitaniumDrmCallback(DrmContext drmContext, HttpDataSource.Factory dataSourceFactory) {
        Map<String, String> custom = drmContext.customProperties();
        return new TiMPMediaDrmCallback(drmContext.getLicenseUrl(), custom.get("portalId"), custom.get("customerId"), dataSourceFactory);
    }

}
