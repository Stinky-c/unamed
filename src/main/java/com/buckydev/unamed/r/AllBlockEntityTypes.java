package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.blocks.hello.HelloBlockEntity;
import com.buckydev.unamed.blocks.test.TestBlockEntity;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, Unamed.MODID);

    private static final Registrate REGISTRATE = Unamed.registrate();

    public static final BlockEntityEntry<TestBlockEntity> TEST_BLOCK_ENTITY = REGISTRATE.object(
            "test_entity").blockEntity(TestBlockEntity::new).validBlocks(AllBlocks.TEST_BLOCK)
            .register();

    public static final BlockEntityEntry<HelloBlockEntity> HELLO_BLOCK_ENTITY = REGISTRATE.object(
            "hello_entity").blockEntity(HelloBlockEntity::new).validBlocks(AllBlocks.HELLO_BLOCK)
            .register();

    public static void register() {}
}
