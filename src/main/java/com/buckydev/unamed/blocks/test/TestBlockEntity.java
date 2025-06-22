package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.blocks.IBlockEntityTicker;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;

public class TestBlockEntity extends BlockEntity implements IBlockEntityTicker {
    protected ItemStackHandler HANDLER = new ItemStackHandler(1);

    public TestBlockEntity(BlockEntityType<?> type, BlockPos pos,
            BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.getGameTime() % 20 == 0) {
//            Block.popResourceFromFace(level, pos, Direction.UP, Items.DIRT.getDefaultInstance());
            Block.popResourceFromFace(level, pos, Direction.UP, HANDLER.getStackInSlot(0));
        }
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                AllBlockEntityTypes.TEST_BLOCK_ENTITY.get(), (be, ctx) -> be.HANDLER);
    }
}
