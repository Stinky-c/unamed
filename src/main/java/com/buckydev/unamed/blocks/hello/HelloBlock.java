package com.buckydev.unamed.blocks.hello;

import com.buckydev.unamed.blocks.ModBlockTopBottom;
import com.buckydev.unamed.blocks.ModEntityBlock;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class HelloBlock extends ModBlockTopBottom implements ModEntityBlock<HelloBlockEntity> {
    public HelloBlock(Properties p) {
        super(p);
    }

    @Override
    public BlockEntityType<? extends HelloBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.HELLO_BLOCK_ENTITY.get();
    }
}
