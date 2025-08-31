package me.kall.ohmyjm.mixin;

import journeymap.client.properties.InGameMapProperties;
import journeymap.common.properties.catagory.Category;
import journeymap.common.properties.config.FloatField;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InGameMapProperties.class, remap = false)
public abstract class InGameMapPropertiesMixin {
    @Mutable @Shadow @Final public FloatField fontScale;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void modifyFontScale(CallbackInfo ci) {
        this.fontScale = new FloatField(Category.Inherit, "jm.common.font_scale", 0.5F, 5.0F, 2.0F);
    }
}
