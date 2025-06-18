package com.buckydev.unamed.blocks.hello;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HelloBlock extends Block implements EntityBlock {

//    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public HelloBlock(Properties p) {
        super(p);
//        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HelloBlockEntity(pos, state);
    }
}
