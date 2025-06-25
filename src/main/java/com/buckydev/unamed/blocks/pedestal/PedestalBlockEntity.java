package com.buckydev.unamed.blocks.pedestal;

import com.buckydev.unamed.blocks.IBlockEntityTicker;
import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.recipe.RecipeHelper;
import com.buckydev.unamed.recipe.pedestal.PedestalCraftingInput;
import com.buckydev.unamed.recipe.pedestal.PedestalCraftingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements IBlockEntityTicker {
    private ItemStackHandler HANDLER = new ItemStackHandler(1);
    private int COUNTER = 0;

    @Nullable
    private RecipeHolder<PedestalCraftingRecipe> currentRecipe = null;

    public PedestalBlockEntity(BlockEntityType<?> type,
            BlockPos pos,
            BlockState blockState) {
        super(type, pos, blockState);
        this.HANDLER.setStackInSlot(0, Items.DIRT.getDefaultInstance());
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(ItemHandler.BLOCK,
                AllBlockEntityTypes.PEDESTAL_BLOCK_ENTITY.get(), (be, ctx) -> be.HANDLER);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state) {
        return;
        /*
        if (level.isClientSide()) {
            return;
        }
        
        // If the current recipe is null, set the recipe and reset the counter; skips if unsuccessful
        if (currentRecipe == null) {
            // If the recipe update was successful reset the counter
            COUNTER = 0;
            return;
        }
        
        // Currently crafting something
        if (currentRecipe != null) {
            ++COUNTER;
        
            // Current recipe is done; check items and consume
            if (COUNTER >= currentRecipe.value().getDuration()) {
                ItemStack heldStack = HANDLER.getStackInSlot(0);
                PedestalCraftingRecipe recipe = currentRecipe.value();
        
        //                var input = PedestalCraftingInput.of(HANDLER.getStackInSlot(0).consumeAndReturn(recipe.g))
        
            }
        
        }
        
         */
    }

    // Check for and update held recipe
    private void updateRecipe(Level level) {
        if (level.getGameTime() % 20 != 0) {
            return;
        }
        ItemStack stack;
        // if contained stack is not empty
        if (!(stack = HANDLER.getStackInSlot(0).copy()).isEmpty()) {
            var holder = RecipeHelper.getPedestalRecipe(level, PedestalCraftingInput.of(stack));
            if (holder.isPresent()) {
                var recipe = holder.get();
                this.currentRecipe = recipe;
            }

        }
    }
}
