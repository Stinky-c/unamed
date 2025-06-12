package com.buckydev.unamed.datagen;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.Utils;
import com.buckydev.unamed.r.AllBlocks;
import com.buckydev.unamed.r.AllItems;
import java.util.Collections;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.data.PackOutput;

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
                TexturedModel.ORIENTABLE_ONLY_TOP.updateTexture(
                        mapping ->
                                mapping.put(TextureSlot.TOP, Utils.loc("block/test/terminal_top"))
                                        .put(TextureSlot.BOTTOM,
                                                Utils.loc("block/test/terminal_bottom"))
                                        .put(TextureSlot.SIDE,
                                                Utils.loc("block/test/terminal_side"))
                                        .put(TextureSlot.FRONT,
                                                Utils.loc("block/test/terminal_front_on"))
                ));
    }
}
