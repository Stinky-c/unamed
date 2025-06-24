package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.blocks.hello.HelloBlock;
import com.buckydev.unamed.blocks.pedestal.PedestalBlock;
import com.buckydev.unamed.blocks.test.TestBlock;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class AllBlocks {
    private static final Registrate REGISTRATE = Unamed.registrate();

    public static final BlockEntry<Block> EXAMPLE_BLOCK = REGISTRATE.object("example_block")
            .block(Block::new).simpleItem().register();

    public static final BlockEntry<TestBlock> TEST_BLOCK = REGISTRATE.object("test_block")
            .block(TestBlock::new).blockstate(AllBlocks::modelOrientableWithBottom).simpleItem()
            .register();

    public static final BlockEntry<HelloBlock> HELLO_BLOCK = REGISTRATE.object("hello_block")
            .block(HelloBlock::new).blockstate(AllBlocks::modelCubeBottomTop).simpleItem()
            .register();

    public static final BlockEntry<PedestalBlock> PEDESTAL_BLOCK = REGISTRATE.object(
            "pedestal_block").block(PedestalBlock::new).simpleItem().register();

    public static ResourceLocation getSuffixedLocation(Block block, String suffix) {
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        return location.withPath(p -> "block/" + p + "/" + suffix);
    }

    public static void modelOrientableWithBottom(DataGenContext<Block, ?> ctx,
            RegistrateBlockstateProvider prov) {
        Block block = ctx.getEntry();
        prov.horizontalBlock(block, prov.models()
                .orientableWithBottom(ctx.getName(), getSuffixedLocation(block, "side"),
                        getSuffixedLocation(block, "front"),
                        getSuffixedLocation(block, "bottom"),
                        getSuffixedLocation(block, "top")));
    }

    public static void modelCubeBottomTop(DataGenContext<Block, ?> ctx,
            RegistrateBlockstateProvider prov) {
        Block block = ctx.getEntry();
        prov.simpleBlock(block, prov.models()
                .cubeBottomTop(ctx.getName(), getSuffixedLocation(block, "side"),
                        getSuffixedLocation(block, "bottom"),
                        getSuffixedLocation(block, "top")));
    }

    public static void register() {}
}
