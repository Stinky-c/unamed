package com.buckydev.unamed.blocks.test;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.items.IItemHandler;

@OnlyIn(Dist.CLIENT)
public class TestBlockEntityRenderer implements BlockEntityRenderer<TestBlockEntity> {
    private final BlockEntityRendererProvider.Context context;

    public TestBlockEntityRenderer(Context context) {
        this.context = context;
    }

    @Override
    public void render(TestBlockEntity be, float partialTick, PoseStack poseStack,
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
//        float angle = ((millis / 45) % 360);
//        float v = context.getBlockEntityRenderDispatcher().camera.getYRot();

        Camera camera = context.getBlockEntityRenderDispatcher().camera;

        Vec3 cameraPosition = camera.getPosition();
        BlockPos pos = be.getBlockPos();
        double x1 = pos.getX(), y1 = pos.getZ();
        double x2 = cameraPosition.x, y2 = cameraPosition.y;

        double rotRad = Math.atan2(y1 - y2, x1 - x2);
        double rotDeg = Math.toDegrees(rotRad);
        poseStack.mulPose(Axis.YN.rotationDegrees((float) rotDeg));
        context.getItemRenderer()
                .renderStatic(stack, ItemDisplayContext.FIXED, LightTexture.FULL_BRIGHT,
                        packedOverlay, poseStack, bufferSource, level, 0);
        poseStack.popPose();
        poseStack.popPose();
    }
}
