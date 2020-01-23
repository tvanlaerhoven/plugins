package io.flutter.plugins.videoplayer.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener;
import io.flutter.plugin.common.EventChannel;

public class DrmSessionEventListener implements DefaultDrmSessionEventListener {

    EventChannel.EventSink eventSink;

    public DrmSessionEventListener(EventChannel.EventSink eventSink) {
        this.eventSink = eventSink;
    }

    @Override
    public void onDrmKeysLoaded() {

    }

    @Override
    public void onDrmSessionManagerError(Exception error) {

    }

    @Override
    public void onDrmKeysRestored() {

    }

    @Override
    public void onDrmKeysRemoved() {

    }
}
