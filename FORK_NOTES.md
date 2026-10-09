# OpenLocation fork notes

OpenLocation is a personal derivative of [shortcuts/locationjoystick](https://github.com/shortcuts/locationjoystick), used under the MIT License.

Current fork policy:

- Installed application ID: `com.dongyaoze.openlocation`.
- Source namespaces remain `com.locationjoystick.*` to minimize unnecessary churn.
- Core mock-location, map, joystick, routes, roaming, favorites, overlays, import/export, and group-sync code remains available.
- Automatic upstream release checks are disabled.
- Automatic hot-location and hot-route refreshes on application launch are disabled.
- Network access initiated by explicit user actions, such as map tiles, geocoding, route planning, group sync, or opening changelog content, is unchanged.
- No ads, account requirement, subscription, or paid unlock has been added.

Upstream baseline cloned on 2026-10-07 from commit:

`53285b4 fix(wiki): stop mobile layout overflowing the viewport`

The original MIT license remains in `LICENSE`.

## Windows workspace note

The repository stays physically under the user's required workspace. Android Gradle Plugin/Kover/aapt have Windows path-encoding problems when the project path contains CJK characters, so generated Gradle outputs are configured through the ASCII path `D:/Documents/_build-cache/OpenLocation`. On this workstation that path is an NTFS junction whose target is the repository-local `.build-cache` directory, so generated files are physically stored inside the OpenLocation workspace rather than on the desktop or in a second source tree.

Installable self-use APKs are placed in the ignored `dist/` directory.
