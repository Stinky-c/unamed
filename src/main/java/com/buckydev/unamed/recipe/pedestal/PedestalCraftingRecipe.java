package com.buckydev.unamed.recipe.pedestal;

import com.buckydev.unamed.r.AllRecipeSerializers;
import com.buckydev.unamed.r.AllRecipesTypes;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class PedestalCraftingRecipe implements Recipe<PedestalCraftingInput> {
    private final Ingredient inputStack;
    private final int duration;
    private final ItemStack outputStack;

    public PedestalCraftingRecipe(Ingredient inputStack, int duration, ItemStack outputStack) {
        this.inputStack = inputStack;
        this.duration = duration;
        this.outputStack = outputStack;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.inputStack);
        return list;
    }

    @Override
    public boolean matches(PedestalCraftingInput input, Level level) {
        return this.inputStack.test(input.inputStack());
    }

    @Override
    public ItemStack assemble(PedestalCraftingInput input, Provider registries) {
        return this.outputStack.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public ItemStack getResultItem(Provider registries) {
        return this.outputStack;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AllRecipeSerializers.PEDESTAL_CRAFTING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return AllRecipesTypes.PEDESTAL_CRAFTING.get();
    }

    public Ingredient getInputStack() {
        return inputStack;
    }

    public int getDuration() {
        return duration;
    }

    public ItemStack getOutputStack() {
        return outputStack;
    }
}
