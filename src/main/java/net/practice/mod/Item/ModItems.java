package net.practice.mod.Item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.practice.mod.PracticeMod;
import net.practice.mod.entity.ModEntities;
import net.practice.mod.entity.custom.FurryEntity;

public class ModItems {
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new FabricItemSettings()));
    public static final Item CITRINE_EGG = registerItem("citrine_egg", new SpawnEggItem(ModEntities.FURRY, 0xc4c4c4, 0xadadad, new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        final Identifier identifier = new Identifier(PracticeMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, identifier, item);

    }
    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, CITRINE);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_CITRINE);

        addToItemGroup(ModItemGroup.CITRINE, CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, CITRINE_EGG);
        addToItemGroup(ModItemGroup.CITRINE, RAW_CITRINE);

    }

    public static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems(){
        PracticeMod.LOGGER.info("Registering Mod Items for " + PracticeMod.MOD_ID);

        addItemsToItemGroup();
    }
}
