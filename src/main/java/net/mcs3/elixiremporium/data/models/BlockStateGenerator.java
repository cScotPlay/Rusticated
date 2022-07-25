package net.mcs3.elixiremporium.data.models;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.minecraft.client.model.Model;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


import java.util.Map;
import java.util.Optional;


public class BlockStateGenerator extends FabricModelProvider
{
    public static String MOD_ID = ElixirEmporium.MOD_ID;
    private final Map<Model, ResourceLocation> knownModels = Maps.newHashMap();

    public static final ModelTemplate PLANK_BASE = createVanillaModel("planks", TextureSlot.ALL);
    public static final ModelTemplate STAIRS = createVanillaModel("stairs", TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate STAIRS_INNER = createVanillaModel("inner_stairs", "_inner", TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate STAIRS_OUTER = createVanillaModel("outer_stairs", "_outer", TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate SLAB = createVanillaModel("slab", TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate SLAB_TOP = createVanillaModel("slab_top", "_top", TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate PATH_0 = createPathModel("path_0", "_0", TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    public static final ModelTemplate PATH_1 = createModdedModel("path_1", "_1", TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    public static final ModelTemplate PATH_2 = createModdedModel("path_2", "_2", TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    public static final ModelTemplate PATH_3 = createModdedModel("path_3", "_3", TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    public static final ModelTemplate CHANDELIER = createModdedModel("chandelier", TextureSlot.ALL);
    public static final ModelTemplate CHAIN = createModdedModel("chain", TextureSlot.PARTICLE, TextureSlot.ALL);
    public static final ModelTemplate BARREL = createModdedModel("barrel_base", TextureSlot.PARTICLE, TextureSlot.TOP,TextureSlot.BOTTOM);
    public static final ModelTemplate LIQUID_BARREL = createModdedModel("liquid_barrel_base", TextureSlot.PARTICLE, TextureSlot.TOP,TextureSlot.BOTTOM);
    public static final ModelTemplate JAR = createModdedModel("jar_base", TextureSlot.TEXTURE, TextureSlot.PARTICLE);





    public BlockStateGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator)
    {
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_WHITE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_ORANGE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_MAGENTA);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_LIGHT_BLUE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_YELLOW);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_LIME);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_PINK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_GRAY);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_LIGHT_GRAY);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_CYAN);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_PURPLE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_BLUE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_BROWN);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_GREEN);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_RED);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PAINTED_PLANKS_BLACK);

        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_WHITE, ModBlocks.PAINTED_PLANKS_WHITE);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_ORANGE, ModBlocks.PAINTED_PLANKS_ORANGE);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_MAGENTA, ModBlocks.PAINTED_PLANKS_MAGENTA);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_LIGHT_BLUE, ModBlocks.PAINTED_PLANKS_LIGHT_BLUE);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_YELLOW, ModBlocks.PAINTED_PLANKS_YELLOW);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_LIME, ModBlocks.PAINTED_PLANKS_LIME);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_PINK, ModBlocks.PAINTED_PLANKS_PINK);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_GRAY, ModBlocks.PAINTED_PLANKS_GRAY);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_LIGHT_GRAY, ModBlocks.PAINTED_PLANKS_LIGHT_GRAY);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_CYAN, ModBlocks.PAINTED_PLANKS_CYAN);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_PURPLE, ModBlocks.PAINTED_PLANKS_PURPLE);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_BLUE, ModBlocks.PAINTED_PLANKS_BLUE);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_BROWN, ModBlocks.PAINTED_PLANKS_BROWN);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_GREEN, ModBlocks.PAINTED_PLANKS_GREEN);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_RED, ModBlocks.PAINTED_PLANKS_RED);
        createStairsModels(blockStateModelGenerator, ModBlocks.PAINTED_STAIRS_BLACK, ModBlocks.PAINTED_PLANKS_BLACK);

        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_WHITE, ModBlocks.PAINTED_PLANKS_WHITE, "painted_planks_white");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_ORANGE, ModBlocks.PAINTED_PLANKS_ORANGE, "painted_planks_orange");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_MAGENTA, ModBlocks.PAINTED_PLANKS_MAGENTA, "painted_planks_magenta");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_LIGHT_BLUE, ModBlocks.PAINTED_PLANKS_LIGHT_BLUE, "painted_planks_light_blue");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_YELLOW, ModBlocks.PAINTED_PLANKS_YELLOW, "painted_planks_yellow");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_LIME, ModBlocks.PAINTED_PLANKS_LIME, "painted_planks_lime");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_PINK, ModBlocks.PAINTED_PLANKS_PINK, "painted_planks_pink");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_GRAY, ModBlocks.PAINTED_PLANKS_GRAY, "painted_planks_gray");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_LIGHT_GRAY, ModBlocks.PAINTED_PLANKS_LIGHT_GRAY, "painted_planks_light_gray");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_CYAN, ModBlocks.PAINTED_PLANKS_CYAN, "painted_planks_cyan");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_PURPLE, ModBlocks.PAINTED_PLANKS_PURPLE, "painted_planks_purple");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_BLUE, ModBlocks.PAINTED_PLANKS_BLUE, "painted_planks_blue");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_BROWN, ModBlocks.PAINTED_PLANKS_BROWN, "painted_planks_brown");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_GREEN, ModBlocks.PAINTED_PLANKS_GREEN, "painted_planks_green");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_RED, ModBlocks.PAINTED_PLANKS_RED, "painted_planks_red");
        createSlabModels(blockStateModelGenerator, ModBlocks.PAINTED_SLAB_BLACK, ModBlocks.PAINTED_PLANKS_BLACK, "painted_planks_black");

        createPathStates(blockStateModelGenerator, ModBlocks.COBBLESTONE_PATH, Blocks.COBBLESTONE);
        createPathStates(blockStateModelGenerator, ModBlocks.STONE_PATH, Blocks.STONE);
        createPathStates(blockStateModelGenerator, ModBlocks.GRANITE_PATH, Blocks.GRANITE);
        createPathStates(blockStateModelGenerator, ModBlocks.ANDESITE_PATH, Blocks.ANDESITE);
        createPathStates(blockStateModelGenerator, ModBlocks.DIORITE_PATH, Blocks.DIORITE);
        createPathStates(blockStateModelGenerator, ModBlocks.COBBLED_DEEPSLATE_PATH, Blocks.COBBLED_DEEPSLATE);
        createPathStates(blockStateModelGenerator, ModBlocks.BLACKSTONE_PATH, Blocks.BLACKSTONE);
        createPathStates(blockStateModelGenerator, ModBlocks.NETHER_BRICKS_PATH, Blocks.NETHER_BRICKS);

        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_IRON);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_GOLD);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_EXPOSED_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_WEATHERED_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_OXIDIZED_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_WAXED_COPPER, ModBlocks.CHANDELIER_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER, ModBlocks.CHANDELIER_EXPOSED_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER, ModBlocks.CHANDELIER_WEATHERED_COPPER);
        createChandelierStates(blockStateModelGenerator, ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER, ModBlocks.CHANDELIER_OXIDIZED_COPPER);

        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_GOLD);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_EXPOSED_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_WEATHERED_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_OXIDIZED_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_WAXED_COPPER, ModBlocks.CHAIN_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_WAXED_EXPOSED_COPPER, ModBlocks.CHAIN_EXPOSED_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_WAXED_WEATHERED_COPPER, ModBlocks.CHAIN_WEATHERED_COPPER);
        createChainStates(blockStateModelGenerator, ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER, ModBlocks.CHAIN_OXIDIZED_COPPER);

        createBarrelStates(blockStateModelGenerator, ModBlocks.BARREL, BARREL);
        createBarrelStates(blockStateModelGenerator, ModBlocks.LIQUID_BARREL, LIQUID_BARREL);

        createJarStates(blockStateModelGenerator, ModBlocks.UNFIRED_JAR, JAR);
        createJarStates(blockStateModelGenerator, ModBlocks.FIRED_JAR, JAR);





    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator)
    {
        itemModelGenerator.generateFlatItem(ModItems.COPPER_NUGGET, ModelTemplates.FLAT_ITEM);

    }

    public static void createStairsModels(BlockModelGenerators modelGenerator, Block block, Block parentTextureBlock)
    {
        TextureMapping textures = TextureMapping.cube(parentTextureBlock);

        ResourceLocation identifier = STAIRS_INNER.create(block, textures, modelGenerator.modelOutput);
        ResourceLocation identifier2 = STAIRS.create(block, textures, modelGenerator.modelOutput);
        ResourceLocation identifier3 = STAIRS_OUTER.create(block, textures, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(block, identifier, identifier2, identifier3));
        modelGenerator.delegateItemModel(block, identifier2);
    }

    public static void createSlabModels(BlockModelGenerators modelGenerator, Block block, Block parentBlock, String name) {
        TextureMapping textures = TextureMapping.cube(parentBlock);
        ResourceLocation baseModelId = new ResourceLocation(MOD_ID, "block/" + name);

        ResourceLocation identifier = SLAB.create(block, textures, modelGenerator.modelOutput);
        ResourceLocation identifier2 = SLAB_TOP.create(block, textures, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSlab(block, identifier, identifier2, baseModelId));
        modelGenerator.delegateItemModel(block, identifier);

    }

    public static void createChandelierStates(BlockModelGenerators modelGenerator, Block block)
    {
        TextureMapping texture = TextureMapping.cube(block);
        ResourceLocation resource = CHANDELIER.create(block, texture, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resource));
        modelGenerator.delegateItemModel(block, resource);

    }

    public static void createChandelierStates(BlockModelGenerators modelGenerator, Block block, Block blockTexture)
    {
        TextureMapping texture = TextureMapping.cube(blockTexture);
        ResourceLocation resource = CHANDELIER.create(block, texture, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resource));
        modelGenerator.delegateItemModel(block, resource);

    }

    public static void createPathStates(BlockModelGenerators modelGenerator, Block block, Block baseStoneBlock)
    {
        TextureMapping texture = TextureMapping.cube(baseStoneBlock);

        ResourceLocation path_0 = PATH_0.create(block, texture, modelGenerator.modelOutput);
        ResourceLocation path_1 = PATH_1.create(block, texture, modelGenerator.modelOutput);
        ResourceLocation path_2 = PATH_2.create(block, texture, modelGenerator.modelOutput);
        ResourceLocation path_3 = PATH_3.create(block, texture, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(pathModelVariants(block, path_0, path_1, path_2, path_3));
        modelGenerator.delegateItemModel(block, path_0);
    }

    public static void createChainStates(BlockModelGenerators modelGenerators, Block block)
    {
        TextureMapping texture = TextureMapping.cube(block);
        ResourceLocation resourceLocation = CHAIN.create(block, texture, modelGenerators.modelOutput);

        modelGenerators.createAxisAlignedPillarBlockCustomModel(block, resourceLocation);
        modelGenerators.createSimpleFlatItemModel(block.asItem());
    }

    public static void createChainStates(BlockModelGenerators modelGenerators, Block block, Block blockTexture)
    {
        TextureMapping texture = TextureMapping.cube(blockTexture);
        ResourceLocation resourceLocation = CHAIN.create(block, texture, modelGenerators.modelOutput);

        modelGenerators.createAxisAlignedPillarBlockCustomModel(block, resourceLocation);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(block.asItem()), TextureMapping.layer0(blockTexture.asItem()), modelGenerators.modelOutput);
    }

    public static void createBarrelStates(BlockModelGenerators modelGenerator, Block block, ModelTemplate model)
    {
        TextureMapping texture = TextureMapping.cube(Blocks.SPRUCE_PLANKS);
        ResourceLocation resource = model.create(block, texture, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resource));
        modelGenerator.delegateItemModel(block, resource);

    }

    public static MultiVariantGenerator pathModelVariants(Block block, ResourceLocation path0Location, ResourceLocation path1Location, ResourceLocation path2Location, ResourceLocation path3Location) {
        return MultiVariantGenerator.multiVariant(block, new net.minecraft.data.models.blockstates.Variant[]{
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path0Location),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path0Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path0Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path0Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path1Location),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path1Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path1Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path1Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path2Location),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path2Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path2Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path2Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path3Location),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path3Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path3Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                net.minecraft.data.models.blockstates.Variant.variant().with(VariantProperties.MODEL, path3Location).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)});
    }

    public static void createJarStates(BlockModelGenerators modelGenerator, Block block, ModelTemplate model)
    {
        TextureMapping texture = TextureMapping.cube(block);
        ResourceLocation resource = model.create(block, texture, modelGenerator.modelOutput);

        modelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resource));
        modelGenerator.delegateItemModel(block, resource);

    }

    private static ModelTemplate createVanillaModel(String parent, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + parent)), Optional.empty(), requiredTextures);
    }

    private static ModelTemplate createVanillaModel(String parent, String variant, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + parent)), Optional.of(variant), requiredTextures);
    }

    private static ModelTemplate createModdedModel(String parent, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(new ResourceLocation(MOD_ID, "block/" + parent)), Optional.empty(), requiredTextures);
    }

    private static ModelTemplate createModdedModel(String parent, String variant, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(new ResourceLocation(MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextures);
    }

    private static ModelTemplate createPathModel(String parent, String variant, TextureSlot... requiredTextures) {
        return new ModelTemplate(Optional.of(new ResourceLocation(MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextures);
    }


}
