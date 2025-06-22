package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.blocks.IModEntityBlock;
import com.buckydev.unamed.blocks.ModBlockFacing;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.r.AllBlockTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TestBlock extends ModBlockFacing implements IModEntityBlock<TestBlockEntity> {
    public TestBlock(BlockBehaviour.Properties p) {
        super(p);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return AllBlockTypes.TEST_BLOCK_CODEC.get();
    }

    @Override
    public BlockEntityType<? extends TestBlockEntity> getBlockEntityType() {
        return AllBlockEntityTypes.TEST_BLOCK_ENTITY.get();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level,
            BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        var be = (TestBlockEntity) level.getBlockEntity(pos);

        if (heldStack.isEmpty() && player.isCrouching()) {
            be.HANDLER.setStackInSlot(0, ItemStack.EMPTY);
        }

        if (heldStack.isEmpty()) {
            return ItemInteractionResult.FAIL;
        }

        be.HANDLER.setStackInSlot(0, heldStack);
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public Class<TestBlockEntity> getBlockEntityClass() {
        return TestBlockEntity.class;
    }
}
