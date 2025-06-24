package com.buckydev.unamed.blocks.pedestal;

import com.buckydev.unamed.blocks.IModEntityBlock;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PedestalBlock extends Block implements IModEntityBlock<PedestalBlockEntity> {
    public PedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntityType<? extends PedestalBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.PEDESTAL_BLOCK_ENTITY.get();
    }

    @Override
    public Class<PedestalBlockEntity> getBlockEntityClass() {
        return PedestalBlockEntity.class;
    }
}
