package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.blocks.hello.HelloBlock;
import com.buckydev.unamed.blocks.test.TestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(
            Unamed.MODID);


    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock(
            "example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.registerBlock("test_block",
            TestBlock::new, BlockBehaviour.Properties.of());

    public static final DeferredBlock<Block> HELLO_BLOCK = BLOCKS.registerBlock("hello_block",
            HelloBlock::new, BlockBehaviour.Properties.of());


}
