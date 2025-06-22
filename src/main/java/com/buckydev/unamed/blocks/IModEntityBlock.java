package com.buckydev.unamed.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public interface IModEntityBlock<T extends BlockEntity> extends EntityBlock {
    BlockEntityType<? extends T> getBlockEntityType();

    Class<T> getBlockEntityClass();

    @Override
    default @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return getBlockEntityType().create(pos, state);
    }

    @Override
    @SuppressWarnings("unchecked")
    default <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
            BlockEntityType<T> blockEntityType) {
        // Return early if the target block is not tickable
        if (!IBlockEntityTicker.class.isAssignableFrom(getBlockEntityClass())) {
            return null;
        }

        // This is depressing.
        // Check if target is the same as expected, similar to {BaseBlockEntity#createTickerHelper}
        if (blockEntityType.equals(getBlockEntityType())) {
            return (BlockEntityTicker<T>) ((BlockEntityTicker<? extends IBlockEntityTicker>) (bLevel, bPos, bState, blockEntity) -> blockEntity.tick(
                    bLevel, bPos, bState));
        }
        return null;
    }
}
