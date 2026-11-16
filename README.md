# dg-desktop

Minimal Operaton testing demo: a Java Swing window displaying Hello world.
Requires Java 17 (JDK 17 to build). No external dependencies.

## Build and run

```sh
mkdir -p build dist
javac --release 17 -d build src/Main.java
jar --create --file dist/dg-desktop-local.jar --main-class Main -C build .
java -jar dist/dg-desktop-local.jar
```

Downloaded release JARs run with `java -jar dg-desktop-v0.1.0.jar`.
A graphical desktop is required. CI tests the GUI using Xvfb.

## Release

Operaton prepares `release/<version>` and `.release/notes.md`. RC tags build a
JAR on Linux and an unsigned `.app` ZIP on macOS, then upload the combined
`release-payloads` Actions artifact. Operaton verifies the bytes and publishes an
RC prerelease with `SHA256SUMS`, never latest. Final tags copy the approved RC
bytes into a draft without rebuilding; Operaton verifies and publishes the final.
The macOS app also requires Java 17; it is not signed or notarized.
Verify downloaded assets with `sha256sum -c SHA256SUMS`.
