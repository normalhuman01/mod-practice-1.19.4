package net.practice.mod.block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.practice.mod.Item.ModItemGroup;
import net.practice.mod.PracticeMod;

public class ModBlocks extends ModBlocksController {
    public static final Block CITRINE_BLOCK_SETTINGS = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", CITRINE_BLOCK_SETTINGS,ModItemGroup.CITRINE);
    public static final Block CITRINE_ORE_SETTINGS = new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(), UniformIntProvider.create(50,100));
    public static final Block CITRINE_ORE = registerBlock("citrine_ore", CITRINE_ORE_SETTINGS,ModItemGroup.CITRINE);
    public static final Block DEEPSLATE_CITRINE_ORE_SETTINGS = new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool(), UniformIntProvider.create(100,200));
    public static final Block DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore", DEEPSLATE_CITRINE_ORE_SETTINGS,ModItemGroup.CITRINE);

    public static void registerModBlocks(){
        PracticeMod.LOGGER.info("Registering ModBlocks for: " + PracticeMod.MOD_ID);
    }


}
