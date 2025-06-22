package com.buckydev.unamed.blocks.hello;

import com.buckydev.unamed.blocks.IModEntityBlock;
import com.buckydev.unamed.blocks.ModBlockTopBottom;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class HelloBlock extends ModBlockTopBottom implements IModEntityBlock<HelloBlockEntity> {
    public HelloBlock(Properties p) {
        super(p);
    }

    @Override
    public BlockEntityType<? extends HelloBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.HELLO_BLOCK_ENTITY.get();
    }

    @Override
    public Class<HelloBlockEntity> getBlockEntityClass() {
        return HelloBlockEntity.class;
    }
}
