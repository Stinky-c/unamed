package com.buckydev.unamed.datagen;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.r.AllBlocks;
import com.buckydev.unamed.r.AllItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, Unamed.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels,
            ItemModelGenerators itemModels) {

//        itemModels.itemModelOutput.register(
//                AllItems.EXAMPLE_ITEM.get(),
//                new ClientItem(
//                        // Defines the model to render
//                        new BlockModelWrapper.Unbaked(
//                                // Points to a model JSON relative to the 'models' directory
//                                // Located at 'assets/examplemod/models/item/example_item.json'
//                                ModelLocationUtils.getModelLocation(AllItems.EXAMPLE_ITEM.get()),
//                                Collections.emptyList()
//                        ),
//                        // Defines some settings to use during the rendering process
//                        new ClientItem.Properties(
//                                // When false, disables the animation where the item is raised
//                                // up towards its normal position on item swap
//                                false
//                        )
//                )
//        );

        itemModels.generateFlatItem(AllItems.EXAMPLE_ITEM.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(AllBlocks.EXAMPLE_BLOCK.get());

        blockModels.createHorizontallyRotatedBlock(AllBlocks.TEST_BLOCK.get(),
                CUBE_ORIENTABLE_TOP_BOTTOM);
        blockModels.createTrivialBlock(AllBlocks.HELLO_BLOCK.get(), CUBE_TOP_BOTTOM);
    }

    public static TexturedModel.Provider CUBE_ORIENTABLE_TOP_BOTTOM = TexturedModel.createDefault(
            block -> new TextureMapping().put(TextureSlot.SIDE, getSidedBlockTexture(block, "side"))
                    .put(TextureSlot.FRONT, getSidedBlockTexture(block, "front"))
                    .put(TextureSlot.TOP, getSidedBlockTexture(block, "top"))
                    .put(TextureSlot.BOTTOM, getSidedBlockTexture(block, "bottom")),
            ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM);

    public static TexturedModel.Provider CUBE_TOP_BOTTOM = TexturedModel.createDefault(
            block -> new TextureMapping().put(TextureSlot.SIDE, getSidedBlockTexture(block, "side"))
                    .put(TextureSlot.TOP, getSidedBlockTexture(block, "top"))
                    .put(TextureSlot.BOTTOM, getSidedBlockTexture(block, "bottom")),
            ModelTemplates.CUBE_BOTTOM_TOP);

    public static ResourceLocation getSidedBlockTexture(Block block, String suffix) {
        ResourceLocation resourcelocation = BuiltInRegistries.BLOCK.getKey(block);
        return resourcelocation.withPath(p -> "block/" + p + "/" + suffix);
    }
}
