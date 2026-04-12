<h2><strong>Keybind Fix TXF</strong></h2>
<p><a href="https://central.sonatype.com/artifact/io.github.jahirxtrap/keybindfixtxf"><img src="https://img.shields.io/maven-central/v/io.github.jahirxtrap/keybindfixtxf?style=flat" alt="Maven Central" /></a></p>

Fix keybinding conflict. Available for **1.18 to 1.21.8** (fixed in later versions).

### Dependency (Maven Central)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    include(implementation("io.github.jahirxtrap:keybindfixtxf:TAG"))
}
```

Replace `TAG` with the version you want (e.g. `1.1.1`).

### Usage

```java
// Register keys to fix
KeybindFixer.putKey(MY_KEY);
```