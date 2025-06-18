package com.buckydev.unamed.blocks.hello;

import com.buckydev.unamed.blocks.ModBlockTopBottom;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HelloBlock extends ModBlockTopBottom implements EntityBlock {


    public HelloBlock(Properties p) {
        super(p);
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HelloBlockEntity(pos, state);
    }
}
