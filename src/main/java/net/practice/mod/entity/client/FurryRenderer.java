package net.practice.mod.entity.client;

import net.minecraft.util.Identifier;
import net.practice.mod.PracticeMod;
import net.practice.mod.entity.custom.FurryEntity;
import software.bernie.geckolib.model.GeoModel;

public class FurryRenderer extends GeoModel<FurryEntity> {
    @Override
    public Identifier getModelResource(FurryEntity animatable) {
        return new Identifier(PracticeMod.MOD_ID,"furry");
    }

    @Override
    public Identifier getTextureResource(FurryEntity animatable) {
        return null;
    }

    @Override
    public Identifier getAnimationResource(FurryEntity animatable) {
        return null;
    }
}
