package com.jahirtrap.keybindfix.mixin;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

import static com.jahirtrap.keybindfix.KeybindFixer.KEY_MAP;

@Mixin(KeyMapping.class)
public abstract class KeyMappingMixin {

    @Final
    @Shadow
    private static Map<String, KeyMapping> ALL;

    @Unique
    private static final Multimap<InputConstants.Key, KeyMapping> KEY_FIX_MAP = ArrayListMultimap.create();

    @Inject(method = "click", at = @At(value = "HEAD"))
    private static void clickFixed(InputConstants.Key key, CallbackInfo ci) {
        KEY_FIX_MAP.get(key).forEach(it -> ((KeyMappingAccessor) it).setClickCount(((KeyMappingAccessor) it).getClickCount() + 1));
    }

    @Inject(method = "set", at = @At(value = "HEAD"))
    private static void setFixed(InputConstants.Key key, boolean bl, CallbackInfo ci) {
        KEY_FIX_MAP.get(key).forEach(it -> it.setDown(bl));
    }

    @Inject(method = "setAll", at = @At(value = "TAIL"))
    private static void setAllToMultiMap(CallbackInfo ci) {
        KEY_FIX_MAP.clear();
        for (KeyMapping keyMapping : ALL.values()) {
            for (KeyMapping keyMapping2 : KEY_MAP.values()) {
                if (((KeyMappingAccessor) keyMapping).getKey() == ((KeyMappingAccessor) keyMapping2).getKey())
                    KEY_FIX_MAP.put(((KeyMappingAccessor) keyMapping).getKey(), keyMapping);
            }
        }
    }
}
