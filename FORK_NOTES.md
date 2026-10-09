# OpenLocation fork notes

OpenLocation is a personal derivative of [shortcuts/locationjoystick](https://github.com/shortcuts/locationjoystick), used under the MIT License.

Current fork policy:

- Installed application ID: `com.dongyaoze.openlocation`.
- Source namespaces remain `com.locationjoystick.*` to minimize unnecessary churn.
- Core mock-location, map, joystick, routes, roaming, favorites, overlays, import/export, and group-sync code remains available.
- Automatic upstream release checks are disabled.
- Automatic hot-location and hot-route refreshes on application launch are disabled.
- Network access initiated by explicit user actions, such as map tiles, geocoding, route planning, group sync, or opening changelog content, is unchanged.
- Map compatibility: Esri World Street Map is the global provider and AMap is the mainland-China provider. The map automatically switches between the two from the current camera center; legacy OSM defaults still migrate once to Esri. Redmi/NJU-WLAN testing showed Esri returns a fixed `Map data not yet available` tile in Nanjing from z14 upward, while AMap remains detailed there.
- Geocoding prefers Photon and falls back to Nominatim because Redmi/NJU-WLAN testing showed Photon reachable while Nominatim timed out.
- No ads, account requirement, subscription, or paid unlock has been added.

Upstream baseline cloned on 2026-10-07 from commit:

`53285b4 fix(wiki): stop mobile layout overflowing the viewport`

The original MIT license remains in `LICENSE`.

## Windows workspace note

The canonical development tree is only:

`D:\Documents\董耀择\dyz电子资料\0.3工作\OpenLocation`

Kotlin/Gradle on this Windows host intermittently fails to resolve sibling Kotlin declarations when compiling directly from the CJK absolute source path. Junction and `subst` aliases are canonicalized back to that path, so they do not reliably fix it.

For release validation only, the current source tree is mirrored to an ephemeral pure-ASCII staging directory under `D:\Documents\_build-cache\OpenLocation-src-*`. Lint/tests/APK assembly run there, and final signed artifacts are copied back to the canonical workspace `dist/`. The staging tree is build scratch, not a second development checkout and may be deleted/recreated at any time.



The repository stays physically under the user's required workspace. Android Gradle Plugin/Kover/aapt have Windows path-encoding problems when the project path contains CJK characters, so generated Gradle outputs are configured through the ASCII path `D:/Documents/_build-cache/OpenLocation-v2`. On this workstation that path is an NTFS junction whose target is the repository-local `.build-cache-v2` directory, so generated files are physically stored inside the OpenLocation workspace rather than on the desktop or in a second source tree.

Installable self-use APKs are placed in the ignored `dist/` directory.
