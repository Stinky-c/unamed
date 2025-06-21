package com.buckydev.unamed.blocks.hello;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class HelloBlockEntity extends BlockEntity {
    public HelloBlockEntity(BlockEntityType<?> type,
            BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
}
