package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.Utils;
import com.buckydev.unamed.blocks.hello.HelloBlockEntity;
import com.buckydev.unamed.blocks.pedestal.PedestalBlockEntity;
import com.buckydev.unamed.blocks.pedestal.PedestalBlockEntityRenderer;
import com.buckydev.unamed.blocks.test.TestBlockEntity;
import com.buckydev.unamed.blocks.test.TestBlockEntityRenderer;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.neoforged.api.distmarker.Dist;

public class AllBlockEntityTypes {
    private static final Registrate REGISTRATE = Unamed.registrate();

    public static final BlockEntityEntry<TestBlockEntity> TEST_BLOCK_ENTITY = REGISTRATE.object(
            "test_entity").blockEntity(TestBlockEntity::new)
            .validBlocks(AllBlocks.TEST_BLOCK)
            .registerCapability(TestBlockEntity::registerCapabilities)
            .renderer(Utils.onlyIn(Dist.CLIENT, () -> TestBlockEntityRenderer::new))
            .register();

    public static final BlockEntityEntry<HelloBlockEntity> HELLO_BLOCK_ENTITY = REGISTRATE.object(
            "hello_entity").blockEntity(HelloBlockEntity::new).validBlocks(AllBlocks.HELLO_BLOCK)
            .register();

    public static final BlockEntityEntry<PedestalBlockEntity> PEDESTAL_BLOCK_ENTITY = REGISTRATE.object(
            "pedestal_block").blockEntity(PedestalBlockEntity::new)
            .validBlocks(AllBlocks.PEDESTAL_BLOCK)
            .registerCapability(PedestalBlockEntity::registerCapabilities)
            .renderer(Utils.onlyIn(Dist.CLIENT, () -> PedestalBlockEntityRenderer::new))
            .register();

    public static void register() {}
}
