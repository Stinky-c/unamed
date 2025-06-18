package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.blocks.ModBlockFacing;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.r.AllBlockTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TestBlock extends ModBlockFacing implements EntityBlock {


    public TestBlock(BlockBehaviour.Properties p) {
        super(p);
    }


    @Override
    protected MapCodec<? extends Block> codec() {
        return AllBlockTypes.TEST_BLOCK_CODEC.get();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TestBlockEntity(pos, state);
    }

    @SuppressWarnings("unchecked")
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level,
            BlockState state, BlockEntityType<T> blockEntityType) {
        return blockEntityType == AllBlockEntityTypes.TEST_BLOCK_ENTITY.get()
                ? (BlockEntityTicker<T>) ((BlockEntityTicker<TestBlockEntity>) TestBlockEntity::tick)
                : null;
    }
}
