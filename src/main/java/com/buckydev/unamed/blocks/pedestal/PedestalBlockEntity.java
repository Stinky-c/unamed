package com.buckydev.unamed.blocks.pedestal;

import com.buckydev.unamed.r.AllBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;

public class PedestalBlockEntity extends BlockEntity {
    private ItemStackHandler HANDLER = new ItemStackHandler(1);

    public PedestalBlockEntity(BlockEntityType<?> type,
            BlockPos pos,
            BlockState blockState) {
        super(type, pos, blockState);
        this.HANDLER.setStackInSlot(0, Items.DIRT.getDefaultInstance());
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                AllBlockEntityTypes.PEDESTAL_BLOCK_ENTITY.get(), (be, ctx) -> be.HANDLER);
    }
}
