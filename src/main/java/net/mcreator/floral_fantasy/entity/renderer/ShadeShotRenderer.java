package net.mcreator.floral_fantasy.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.floral_fantasy.item.ShadeShotItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShadeShotRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShadeShotItem.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<ShadeShotItem.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("floral_fantasy:textures/shade.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ShadeShotItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelshade();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ShadeShotItem.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelshade extends EntityModel<Entity> {
		private final ModelRenderer shade;
		private final ModelRenderer head;
		private final ModelRenderer armgroup1;
		private final ModelRenderer armgroup2;
		public Modelshade() {
			textureWidth = 128;
			textureHeight = 128;
			shade = new ModelRenderer(this);
			shade.setRotationPoint(0.0F, 16.0F, -0.95F);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			shade.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			armgroup1 = new ModelRenderer(this);
			armgroup1.setRotationPoint(0.0F, 0.0F, -7.0F);
			shade.addChild(armgroup1);
			armgroup1.setTextureOffset(0, 30).addBox(-1.0F, 6.0F, 0.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			armgroup1.setTextureOffset(28, 16).addBox(6.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			armgroup1.setTextureOffset(0, 16).addBox(-8.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			armgroup1.setTextureOffset(32, 0).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			armgroup2 = new ModelRenderer(this);
			armgroup2.setRotationPoint(0.0F, 0.0F, 7.0F);
			shade.addChild(armgroup2);
			armgroup2.setTextureOffset(22, 44).addBox(3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
			armgroup2.setTextureOffset(0, 44).addBox(3.0F, 3.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
			armgroup2.setTextureOffset(50, 30).addBox(-5.0F, 3.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
			armgroup2.setTextureOffset(28, 30).addBox(-5.0F, -5.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			shade.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.armgroup2.rotateAngleZ = f2;
			this.armgroup1.rotateAngleZ = f2 / 20.f;
			this.shade.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.shade.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
