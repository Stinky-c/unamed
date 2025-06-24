package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.blocks.IBlockEntityTicker;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.r.AllDataAttachments;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class TestBlockEntity extends BlockEntity implements IBlockEntityTicker {
    private static final Logger LOGGER = LogUtils.getLogger();

    protected ItemStackHandler HANDLER = new ItemStackHandler(1);
    protected int COUNTER = 0;

    public TestBlockEntity(BlockEntityType<?> type, BlockPos pos,
            BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide()) {
            return;
        }
        if (COUNTER >= 20 && !HANDLER.getStackInSlot(0).isEmpty()) {
            COUNTER = 0;
            // Without `copyWithCount()` stack was being removed from the handler
//            Block.popResourceFromFace(level, pos, Direction.UP,HANDLER.getStackInSlot(0).copyWithCount(1));
        } else {
            ++COUNTER;
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
//        if (tag.contains("value")) {
//            this.HANDLER.setStackInSlot(1, ItemStack.parse(registries, tag.get("value")).get());
//        }
        if (hasData(AllDataAttachments.STACK_HANDLER.get())) {
            this.HANDLER = getData(AllDataAttachments.STACK_HANDLER.get());
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ItemStack stack;
        // If not empty grab stack

//        if (!(stack = this.HANDLER.getStackInSlot(0)).isEmpty()) {
//            tag.put("value", stack.save(registries));
//        }
        if (!this.HANDLER.getStackInSlot(0).isEmpty()) {
            setData(AllDataAttachments.STACK_HANDLER.get(), this.HANDLER);
        }
    }

    // see block entity syncing: https://docs.neoforged.net/docs/1.21.1/blockentities/#syncing
    @Override
    public CompoundTag getUpdateTag(Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, Provider lookupProvider) {
        super.handleUpdateTag(tag, lookupProvider);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt,
            Provider lookupProvider) {
        super.onDataPacket(net, pkt, lookupProvider);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                AllBlockEntityTypes.TEST_BLOCK_ENTITY.get(), (be, ctx) -> be.HANDLER);
    }
}
