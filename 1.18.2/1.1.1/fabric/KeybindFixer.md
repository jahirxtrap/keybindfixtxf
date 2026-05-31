# Class `KeybindFixer`

**Package:** `com.jahirtrap.keybindfix`

```java
public class KeybindFixer
```

Entry point of Keybind Fix TXF.

Minecraft only triggers the first key mapping it finds for a given key, so
several mods that share the same default key end up clashing — only one
of them reacts. Registering each affected mapping with
[`putKey(KeyMapping)`](#putkey-keymapping) makes every registered mapping respond
independently, even when more than one is bound to the same physical key.

Registration is meant to happen once per mapping during client
initialisation, after the key mapping itself has been created and registered
with the loader.

> **Since** 1.0.0

---

## Fields

| Field | Description |
|---|---|
| [`KEY_MAP`](#key_map) | Holds every `KeyMapping` registered through [`putKey(KeyMapping)`](#putkey-keymapping), grouped by the physical key it is bound to. |

## Methods

| Method | Summary |
|---|---|
| [`putKey(KeyMapping)`](#putkey-keymapping) | Registers a key mapping so it is no longer suppressed by other mappings bound to the same key. |

---

### `KEY_MAP`

```java
public static final Multimap<InputConstants.Key, KeyMapping> KEY_MAP
```

Holds every `KeyMapping` registered through
[`putKey(KeyMapping)`](#putkey-keymapping), grouped by the physical key it is bound to.

Populated by `putKey` and consumed internally to dispatch key
events to all conflicting mappings; mods normally do not need to read or
modify it directly.

> **Since** 1.0.0

---

### `putKey(KeyMapping)`

```java
public static void putKey(KeyMapping keyMapping)
```

Registers a key mapping so it is no longer suppressed by other mappings
bound to the same key.

Call this once for each key mapping that may conflict with another mod,
typically right after the mapping is registered during client setup.

**Parameters:**

| Name | Description |
|---|---|
| `keyMapping` | the key mapping to track |

> **Since** 1.0.0
