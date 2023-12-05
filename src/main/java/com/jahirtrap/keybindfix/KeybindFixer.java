package com.jahirtrap.keybindfix;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jahirtrap.keybindfix.mixin.KeyMappingAccessor;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class KeybindFixer {

    public static final Multimap<InputConstants.Key, KeyMapping> KEY_MAP = ArrayListMultimap.create();

    public static void putKey(KeyMapping keyMapping) {
        KEY_MAP.put(((KeyMappingAccessor) keyMapping).getKey(), keyMapping);
    }
}
