package com.buckydev.unamed;

import com.buckydev.unamed.r.AllBlockEntityTypes;
import com.buckydev.unamed.r.AllBlockTypes;
import com.buckydev.unamed.r.AllBlocks;
import com.buckydev.unamed.r.AllCreativeTabs;
import com.buckydev.unamed.r.AllItems;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Unamed.MODID)
public class Unamed {
    public static final String MODID = "unamed";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(
            () -> Registrate.create(Unamed.MODID));

    public Unamed(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

//        REGISTRATE.get().registerEventListeners(modEventBus);

        AllCreativeTabs.register();
        AllBlockEntityTypes.register();
        AllBlocks.register();
        AllBlockTypes.register();
        AllItems.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    /**
     * Returns the mod Regisgrate Instance
     *
     * @return Registrate
     */
    public static Registrate registrate() {
        return REGISTRATE.get();
    }
}
