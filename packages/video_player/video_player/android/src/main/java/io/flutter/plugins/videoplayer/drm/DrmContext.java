package io.flutter.plugins.videoplayer.drm;

import com.google.android.exoplayer2.util.Util;

import java.util.Map;
import java.util.UUID;

import androidx.annotation.Nullable;

public class DrmContext {

    private String licenseUrl;

    private UUID drmSchemeUUID;

    private String[] keyRequestPropertiesArray;

    private LicenseType licenseType = LicenseType.UNSPECIFIED;

    private Map<String, String> custom;

    public enum LicenseType {UNSPECIFIED, TITANIUM};

    public DrmContext(Map<String, String> arg, @Nullable Map<String, String> custom) {
        if (arg != null) {
            licenseUrl = arg.get("licenseUrl");
            licenseType = licenseTypeFromString(arg.get("licenseType"));
            drmSchemeUUID = Util.getDrmUuid(arg.get("drmScheme"));
            this.custom = custom;
        }
    }

    static private LicenseType licenseTypeFromString(@Nullable String licenseType) {
        if (licenseType == null) {
            return LicenseType.UNSPECIFIED;
        }
        switch (licenseType) {
            case "titanium": return LicenseType.TITANIUM;
            case "unspecified":
            default: return LicenseType.UNSPECIFIED;
        }
    }

    public UUID getDrmSchemeUUID() {
        return drmSchemeUUID;
    }

    String getLicenseUrl() {
        return licenseUrl;
    }

    LicenseType getLicenseType() { return licenseType; }

    String[] getKeyRequestProperties() {
        return keyRequestPropertiesArray;
    }

    Map<String, String> customProperties() { return custom; }
}
