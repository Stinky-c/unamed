package com.buckydev.unamed.blocks.test;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.r.AllBlockTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class TestBlock extends Block implements EntityBlock {


    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public TestBlock(BlockBehaviour.Properties p) {
        super(p);
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        // Get the direction the facing player is facing if they are crouching else get direction facing the player
        Direction direction = (context.getPlayer() != null && context.getPlayer().isCrouching())
                ? context.getHorizontalDirection() : context.getHorizontalDirection().getOpposite();

        return defaultBlockState().setValue(FACING, direction);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return AllBlockTypes.TEST_BLOCK_CODEC.get();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TestBlockEntity(pos, state);
    }

    @SuppressWarnings("unchecked")
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level,
            BlockState state, BlockEntityType<T> blockEntityType) {
        return blockEntityType == AllBlockEntityTypes.TEST_BLOCK_ENTITY.get()
                ? (BlockEntityTicker<T>) ((BlockEntityTicker<TestBlockEntity>) TestBlockEntity::tick)
                : null;
    }
}
