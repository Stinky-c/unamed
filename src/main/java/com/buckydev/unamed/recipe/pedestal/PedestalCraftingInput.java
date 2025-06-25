package com.buckydev.unamed.recipe.pedestal;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record PedestalCraftingInput(ItemStack inputStack) implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        if (slot != 0) {
            throw new IllegalArgumentException("No item for index " + slot);
        }
        return this.inputStack;
    }

    @Override
    public int size() {
        return 1;
    }

    public static PedestalCraftingInput of(ItemStack stack) {
        return new PedestalCraftingInput(stack);
    }
}
