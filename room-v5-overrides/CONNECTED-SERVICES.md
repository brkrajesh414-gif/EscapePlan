# EscapePlan 2.3 service configuration

The APK runs offline without Firebase. This is guest use, not authentication.

The Room v5 build workflow extracts the original archive and applies `room-v5-overrides` before building. The repository root still contains the older export; build via `.github/workflows/build-room-v5-apk.yml` on `codex/build-room-v5-apk`.

To enable connected services, set these repository Actions secrets:

- `GOOGLE_SERVICES_JSON`: full contents of the Android Firebase configuration downloaded for package `com.aistudio.tripplanner.kvxwq`.
- `GOOGLE_WEB_CLIENT_ID`: the Web OAuth client ID for Google sign-in (not the Android OAuth client ID).
- `MAPS_ANDROID_KEY`: the restricted Android Maps/Places API key for that package and its signing certificate.

In the same Firebase project, enable the desired authentication providers (Email/Password and Google), register the signing SHA-1/SHA-256, and deploy the supplied Firestore rules and functions using the owner's Firebase access. Cloud AI generation also requires its backend configuration. A client JSON file alone does not deploy that backend.

Do not commit service-account keys, signing keys or private backend credentials.

The automated output is a debug APK. CI currently generates a fresh debug signing key: it may not replace an earlier installed build. Export saved trips before any uninstall; uninstalling removes local data. Production updates need a retained signing key. No device migration test has been run for this update.

## Changes and remaining content work

Explore searches destination guides, 108 regional guides, and the category catalogue together. It supports partial names and supplied aliases. Budget filters remain available for the destinations with estimates. Category details are enriched from matching existing guides; short entries are explicitly labelled when no complete guide exists. Srisailam now has a short introduction and official visitor link.

The map screen opens Google Maps when an embedded-map key is absent. Missing Firebase configuration leads to guest exploration and offline planning; no fake login is implemented. The profile heading has explicit line spacing, and failed sign-in attempts no longer erase the password.

Offline requests such as `within 200 km of Hyderabad for 2 days` filter against recorded origin distances; missing distances are excluded. A bare `200km` requests a starting city. Travel data and estimates still need ongoing verification and expansion. External map results require connectivity.
