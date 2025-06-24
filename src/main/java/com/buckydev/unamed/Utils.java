package com.buckydev.unamed;

import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

public class Utils {
    public static ResourceLocation loc(String location) {
        return ResourceLocation.fromNamespaceAndPath(Unamed.MODID, location);
    }

    @SuppressWarnings("unchecked") // Casting a null supplier is mean
    public static <T extends Supplier<?>> T onlyIn(Dist dist, T supplier) {
        if (FMLEnvironment.dist.equals(dist)) {
            return supplier;
        }
        Supplier<?> v = () -> null;
        return (T) v;
    }
}
