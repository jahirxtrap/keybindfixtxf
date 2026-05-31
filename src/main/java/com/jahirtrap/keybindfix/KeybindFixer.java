package com.jahirtrap.keybindfix;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jahirtrap.keybindfix.mixin.KeyMappingAccessor;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

/**
 * Entry point of Keybind Fix TXF.
 * <p>
 * Minecraft only triggers the first key mapping it finds for a given key, so
 * several mods that share the same default key end up clashing &mdash; only one
 * of them reacts. Registering each affected mapping with
 * {@link #putKey(KeyMapping)} makes every registered mapping respond
 * independently, even when more than one is bound to the same physical key.
 * <p>
 * Registration is meant to happen once per mapping during client
 * initialisation, after the key mapping itself has been created and registered
 * with the loader.
 *
 * @since 1.0.0
 */
public class KeybindFixer {

    /**
     * Holds every {@link KeyMapping} registered through
     * {@link #putKey(KeyMapping)}, grouped by the physical key it is bound to.
     * <p>
     * Populated by {@code putKey} and consumed internally to dispatch key
     * events to all conflicting mappings; mods normally do not need to read or
     * modify it directly.
     *
     * @since 1.0.0
     */
    public static final Multimap<InputConstants.Key, KeyMapping> KEY_MAP = ArrayListMultimap.create();

    /**
     * Registers a key mapping so it is no longer suppressed by other mappings
     * bound to the same key.
     * <p>
     * Call this once for each key mapping that may conflict with another mod,
     * typically right after the mapping is registered during client setup.
     *
     * @param keyMapping the key mapping to track
     * @since 1.0.0
     */
    public static void putKey(KeyMapping keyMapping) {
        KEY_MAP.put(((KeyMappingAccessor) keyMapping).getKey(), keyMapping);
    }
}
