package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class AllItems {
    public static final Registrate REGISTRATE = Unamed.registrate();

    public static final ItemEntry<Item> EXAMPLE_ITEM = REGISTRATE.item("example_item", Item::new)
            .properties(p -> p.food(
                    new FoodProperties.Builder().alwaysEdible().saturationModifier(2f).nutrition(1)
                            .build()))
            .defaultModel().register();

    public static void register() {}
}
