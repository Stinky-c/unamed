package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.blocks.test.TestBlock;
import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllBlockTypes {

    public static final DeferredRegister<MapCodec<? extends Block>> REGISTRAR = DeferredRegister.create(
            BuiltInRegistries.BLOCK_TYPE, Unamed.MODID);

    public static final Supplier<MapCodec<TestBlock>> TEST_BLOCK_CODEC = REGISTRAR.register(
            "test_block", () -> BlockBehaviour.simpleCodec(TestBlock::new));

}
