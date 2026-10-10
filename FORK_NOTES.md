# OpenLocation fork notes

OpenLocation is a derivative of [shortcuts/locationjoystick](https://github.com/shortcuts/locationjoystick), used under the MIT License.

Current fork policy:

- Installed application ID: `com.dongyaoze.openlocation`.
- Source namespaces remain `com.locationjoystick.*` to minimize unnecessary churn.
- Core mock-location, map, joystick, routes, roaming, favorites, overlays, import/export, and group-sync code remains available.
- Automatic upstream release checks are disabled.
- Automatic hot-location and hot-route refreshes on application launch are disabled.
- Network access initiated by explicit user actions, such as map tiles, geocoding, route planning, group sync, or opening changelog content, is unchanged.
- Map compatibility: Esri World Street Map is the global provider and AMap is the mainland-China provider. The map automatically switches between the two from the current camera center; legacy OSM defaults still migrate once to Esri. Mainland-China device/network testing showed Esri returns a fixed `Map data not yet available` tile in Nanjing from z14 upward, while AMap remains detailed there.
- Geocoding prefers Photon and falls back to Nominatim because mainland-China network testing showed Photon reachable while Nominatim timed out.
- No ads, account requirement, subscription, or paid unlock has been added.

Upstream baseline cloned on 2026-10-07 from commit:

`53285b4 fix(wiki): stop mobile layout overflowing the viewport`

The original MIT license remains in `LICENSE`.

## Windows build note

On some Windows hosts, Gradle/Kotlin can behave inconsistently when the source tree is located under a path containing CJK characters. The reliable release workflow used for this fork keeps the canonical source tree unchanged and mirrors it to a temporary ASCII-only staging directory for `lintRelease`, `testRelease`, and `assembleRelease`.

Signing keys, APK outputs, local caches, and staging directories are excluded from Git. Installable local APKs are placed in the ignored `dist/` directory.
