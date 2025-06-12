package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Unamed.MODID);

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "example_block", AllBlocks.EXAMPLE_BLOCK);

    public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "test_block", AllBlocks.TEST_BLOCK);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item",
            new Item.Properties().food(
                    new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f)
                            .build()));

}
