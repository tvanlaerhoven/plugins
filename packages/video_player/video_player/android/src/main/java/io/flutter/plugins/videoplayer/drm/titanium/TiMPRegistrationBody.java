package io.flutter.plugins.videoplayer.drm.titanium;

import com.google.gson.annotations.SerializedName;

class TiMPRegistrationBody {
    @SerializedName("LatensRegistration")
    TiMPRegistration tiMPRegistration;

    @SerializedName("Payload")
    String payload;

    @SerializedName("AuthToken")
    String authToken;
}
