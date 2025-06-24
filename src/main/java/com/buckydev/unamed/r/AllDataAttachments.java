package com.buckydev.unamed.r;

import com.buckydev.unamed.Unamed;
import java.util.function.Supplier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class AllDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES, Unamed.MODID);

    public static final Supplier<AttachmentType<ItemStackHandler>> STACK_HANDLER = ATTACHMENT_TYPES.register(
            "stack_handler",
            () -> AttachmentType.serializable(() -> new ItemStackHandler(1)).build());

    public static void register(IEventBus bus) {
        ATTACHMENT_TYPES.register(bus);
    }
}
