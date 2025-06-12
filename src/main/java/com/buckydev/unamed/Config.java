package com.buckydev.unamed;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = Unamed.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    private static final ModConfigSpec.IntValue SPAWN_RATE = BUILDER.comment(
                    "Tick interval to spawn an item")
            .defineInRange("spawnrate", 20, 0, Integer.MAX_VALUE);

    // a list of strings that are treated as resource locations for items

    static final ModConfigSpec SPEC = BUILDER.build();

    public static Integer SpawnRate;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        SpawnRate = SPAWN_RATE.get();
    }
}
