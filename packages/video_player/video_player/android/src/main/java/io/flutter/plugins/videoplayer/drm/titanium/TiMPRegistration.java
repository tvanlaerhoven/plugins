package io.flutter.plugins.videoplayer.drm.titanium;
import com.google.gson.annotations.SerializedName;

class TiMPRegistration {
    @SerializedName("CustomerName")
    String customerName;

    @SerializedName("AccountName")
    String accountName;

    @SerializedName("PortalId")
    String portalId;

    @SerializedName("friendlyName")
    String friendlyName;

    @SerializedName("DeviceInfo")
    TiMPDeviceInfo deviceInfo;
}
