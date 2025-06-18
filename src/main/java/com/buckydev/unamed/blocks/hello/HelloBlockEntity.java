package com.buckydev.unamed.blocks.hello;

import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HelloBlockEntity extends BlockEntity {

    public HelloBlockEntity(
            BlockPos pos,
            BlockState blockState) {
        super(AllBlockEntityTypes.HELLO_BLOCK_ENTITY.get(), pos, blockState);
    }
}
