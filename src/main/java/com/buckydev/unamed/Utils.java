package com.buckydev.unamed;

import net.minecraft.resources.ResourceLocation;

public class Utils {

    public static ResourceLocation loc(String location) {
        return ResourceLocation.fromNamespaceAndPath(Unamed.MODID, location);
    }

}
