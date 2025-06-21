package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

public class AllCreativeTabs {
    private static final Registrate REGISTRATE = Unamed.registrate();

    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TAB = REGISTRATE.defaultCreativeTab(Unamed.MODID,
            b -> b.icon(AllItems.EXAMPLE_ITEM::asStack)).register();

    public static void register() {}
}
