# Keybind Fix TXF

A lightweight Fabric library that fixes keybinding conflicts in Minecraft. Available for **1.18 to 1.21.8** (fixed in later versions).

## Setup

### Dependency

The library is published on [Maven Central](https://central.sonatype.com/artifact/io.github.jahirxtrap/keybindfixtxf).

Add the dependency to your `build.gradle`:

```gradle
dependencies {
    include(implementation("io.github.jahirxtrap:keybindfixtxf:1.1.1"))
}
```

## Usage

Register your keybindings with `KeybindFixer.putKey()` to fix conflicts:

```java
import com.jahirtrap.keybindfix.KeybindFixer;

public class MyModClient implements ClientModInitializer {
    public static final KeyMapping MY_KEY = new KeyMapping(
        "key.mymod.action",
        GLFW.GLFW_KEY_R,
        "category.mymod"
    );

    @Override
    public void onInitializeClient() {
        KeyMappingHelper.registerKeyMapping(MY_KEY);
        KeybindFixer.putKey(MY_KEY);
    }
}
```

Call `KeybindFixer.putKey()` for each keybinding that may conflict with other mods. The library ensures that all registered keys work independently even when bound to the same physical key.

## Compatibility

| Minecraft Version | Status |
|---|---|
| 1.18 - 1.21.8 | Supported |
| 1.21.9+ | Not needed (fixed in vanilla) |