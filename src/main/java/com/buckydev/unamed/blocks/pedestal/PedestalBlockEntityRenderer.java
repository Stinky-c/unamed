package com.buckydev.unamed.blocks.pedestal;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.items.IItemHandler;

public class PedestalBlockEntityRenderer implements
        BlockEntityRenderer<PedestalBlockEntity> {
    private final BlockEntityRendererProvider.Context context;

    public PedestalBlockEntityRenderer(Context context) {
        this.context = context;
    }

    @Override
    public void render(PedestalBlockEntity be, float partialTick, PoseStack poseStack,
            MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level;
        if ((level = be.getLevel()) == null) {
            return;
        }

        IItemHandler cap;
        if ((cap = level.getCapability(ItemHandler.BLOCK, be.getBlockPos(), null)) == null) {
            return;
        }

        ItemStack stack = cap.getStackInSlot(0);
        if (stack.isEmpty()) {
            return;
        }

        long millis = System.currentTimeMillis();
        poseStack.pushPose();
        poseStack.pushPose();

        poseStack.scale(.5f, .5f, .5f);
        poseStack.translate(1f, 2.8f, 1f);
        float angle = ((millis / 45) % 360);

        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        context.getItemRenderer()
                .renderStatic(stack, ItemDisplayContext.FIXED, LightTexture.FULL_BRIGHT,
                        packedOverlay, poseStack, bufferSource, level, 0);
        poseStack.popPose();
        poseStack.popPose();
    }
}
