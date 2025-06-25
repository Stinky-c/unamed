package com.buckydev.unamed.recipe.pedestal;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class PedestalCraftingRecipeSerializer implements RecipeSerializer<PedestalCraftingRecipe> {
    public static final MapCodec<PedestalCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst.group(Ingredient.CODEC.fieldOf("inputStack")
                    .forGetter(PedestalCraftingRecipe::getInputStack),
                    Codec.INT.fieldOf("duration").forGetter(PedestalCraftingRecipe::getDuration),
                    ItemStack.CODEC.fieldOf("outputStack")
                            .forGetter(PedestalCraftingRecipe::getOutputStack))
                    .apply(inst, PedestalCraftingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PedestalCraftingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, PedestalCraftingRecipe::getInputStack,
            ByteBufCodecs.INT, PedestalCraftingRecipe::getDuration,
            ItemStack.STREAM_CODEC, PedestalCraftingRecipe::getOutputStack,
            PedestalCraftingRecipe::new);

    @Override

    public MapCodec codec() {
        return CODEC;
    }

    @Override
    public StreamCodec streamCodec() {
        return STREAM_CODEC;
    }
}
