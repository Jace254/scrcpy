package com.genymobile.scrcpy.audio;

import android.media.AudioAttributes;

/**
 * Audio usages which may be routed to the playback capture mixing rule.
 * <p>
 * A mixing rule matches a usage exactly (there is no notion of category), so every usage to capture must be requested explicitly. By default all of
 * these are captured; a subset may be requested through {@code --audio-dup=<usages>}.
 */
public enum AudioUsage {
    MEDIA("media", AudioAttributes.USAGE_MEDIA),
    UNKNOWN("unknown", AudioAttributes.USAGE_UNKNOWN),
    GAME("game", AudioAttributes.USAGE_GAME),
    ALARM("alarm", AudioAttributes.USAGE_ALARM),
    NOTIFICATION("notification", AudioAttributes.USAGE_NOTIFICATION),
    NOTIFICATION_EVENT("notification-event", AudioAttributes.USAGE_NOTIFICATION_EVENT),
    RINGTONE("ringtone", AudioAttributes.USAGE_NOTIFICATION_RINGTONE),
    ASSISTANT("assistant", AudioAttributes.USAGE_ASSISTANT),
    SONIFICATION("sonification", AudioAttributes.USAGE_ASSISTANCE_SONIFICATION),
    ACCESSIBILITY("accessibility", AudioAttributes.USAGE_ASSISTANCE_ACCESSIBILITY),
    NAVIGATION("navigation", AudioAttributes.USAGE_ASSISTANCE_NAVIGATION_GUIDANCE),
    VOICE_COMMUNICATION("voice-communication", AudioAttributes.USAGE_VOICE_COMMUNICATION),
    VOICE_COMMUNICATION_SIGNALLING("voice-communication-signalling", AudioAttributes.USAGE_VOICE_COMMUNICATION_SIGNALLING),
    CALL_ASSISTANT("call-assistant", AudioAttributes.USAGE_CALL_ASSISTANT);

    // USAGE_VIRTUAL_SOURCE is deliberately absent: it would capture the loopback itself

    private final String name;
    private final int attributesUsage;

    AudioUsage(String name, int attributesUsage) {
        this.name = name;
        this.attributesUsage = attributesUsage;
    }

    public int getAttributesUsage() {
        return attributesUsage;
    }

    public static AudioUsage findByName(String name) {
        for (AudioUsage usage : AudioUsage.values()) {
            if (name.equals(usage.name)) {
                return usage;
            }
        }

        return null;
    }
}
