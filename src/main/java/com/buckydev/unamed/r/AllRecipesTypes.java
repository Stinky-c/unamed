package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.Utils;
import com.buckydev.unamed.recipe.pedestal.PedestalCraftingRecipe;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllRecipesTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
            BuiltInRegistries.RECIPE_TYPE, Unamed.MODID);

    public static final Supplier<RecipeType<PedestalCraftingRecipe>> PEDESTAL_CRAFTING = RECIPE_TYPES.register(
            "pedestal", () -> RecipeType.simple(Utils.loc("pedestal")));

    public static void register(IEventBus bus) {
        RECIPE_TYPES.register(bus);
    }
}
