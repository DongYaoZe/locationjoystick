package com.locationjoystick.app

/**
 * Fork-specific privacy/network policy.
 *
 * Core map/search/routing requests still happen when the user explicitly uses those features.
 * These flags only control unsolicited background requests on app launch.
 */
internal object OpenLocationPolicy {
    const val ENABLE_UPSTREAM_UPDATE_CHECK = false
    const val ENABLE_BACKGROUND_CONTENT_REFRESH = false
}
