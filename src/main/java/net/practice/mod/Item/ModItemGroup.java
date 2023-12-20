package net.practice.mod.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.practice.mod.PracticeMod;

public class ModItemGroup {
    public static ItemGroup CITRINE;

    public static void registerItemGroups(){
        final Identifier identifier = new Identifier(PracticeMod.MOD_ID, "citrine");
        CITRINE = FabricItemGroup.builder(identifier).displayName(Text.translatable("itemgroup.citrine")).icon(() -> new ItemStack(ModItems.CITRINE)).build();
    }
}
