package net.practice.mod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionTypes;
import net.practice.mod.PracticeMod;
import net.practice.mod.entity.custom.FurryEntity;

import javax.swing.text.html.parser.Entity;

public class ModEntities {
    public static final EntityType<FurryEntity> FURRY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(PracticeMod.MOD_ID, "furry"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FurryEntity::new).dimensions(EntityDimensions.fixed(3.0f, 5.0f)).build()
    );
}

