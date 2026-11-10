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

```sh
git tag v0.1.0
git push origin v0.1.0
```

Tag pushes matching `v*` run the Release workflow, which builds and tests the
executable JAR and publishes it with `SHA256SUMS` in a GitHub release.
Verify downloaded assets with `sha256sum -c SHA256SUMS`.
