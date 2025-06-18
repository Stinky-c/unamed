package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.blocks.hello.HelloBlockEntity;
import com.buckydev.unamed.blocks.test.TestBlockEntity;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, Unamed.MODID);


    public static final Supplier<BlockEntityType<TestBlockEntity>> TEST_BLOCK_ENTITY = BLOCK_ENTITY_TYPE.register(
            "test_entity", () -> new BlockEntityType<>(
                    TestBlockEntity::new,
                    AllBlocks.TEST_BLOCK.get()
            ));

    public static final Supplier<BlockEntityType<HelloBlockEntity>> HELLO_BLOCK_ENTITY = BLOCK_ENTITY_TYPE.register(
            "hello_entity", () -> new BlockEntityType<>(
                    HelloBlockEntity::new,
                    AllBlocks.HELLO_BLOCK.get()
            )
    );

}
