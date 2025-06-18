package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TestBlockEntity extends BlockEntity {

    public TestBlockEntity(BlockPos pos,
            BlockState blockState) {
        super(AllBlockEntityTypes.TEST_BLOCK_ENTITY.get(), pos, blockState);
    }


    public static void tick(Level level, BlockPos pos, BlockState state,
            TestBlockEntity blockEntity) {
        if (level.getGameTime() % 20 == 0) {
            Block.popResourceFromFace(level, pos, Direction.UP, Items.DIRT.getDefaultInstance());
        }

    }
}

