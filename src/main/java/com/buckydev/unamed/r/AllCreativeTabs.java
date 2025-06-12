package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, Unamed.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register(
            "example_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.unamed"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> AllItems.EXAMPLE_ITEM.get().getDefaultInstance()).build());

}
