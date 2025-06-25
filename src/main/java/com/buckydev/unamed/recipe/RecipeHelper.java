package com.buckydev.unamed.recipe;

import com.buckydev.unamed.r.AllRecipesTypes;
import com.buckydev.unamed.recipe.pedestal.PedestalCraftingInput;
import com.buckydev.unamed.recipe.pedestal.PedestalCraftingRecipe;
import java.util.Optional;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;

public class RecipeHelper {

    /*
    public static <RI extends RecipeInput> Optional<RecipeHolder<? extends Recipe<RI>>> get(
            RecipeManager manager, Level level, RI input) {
    
    }
     */
    public static Optional<RecipeHolder<PedestalCraftingRecipe>> getPedestalRecipe(
            Level level, PedestalCraftingInput input) {
        RecipeManager manager = level.getRecipeManager();
        return manager.getRecipeFor(AllRecipesTypes.PEDESTAL_CRAFTING.get(), input, level);
    }
}
