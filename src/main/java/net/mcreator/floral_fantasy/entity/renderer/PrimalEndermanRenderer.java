
package net.mcreator.floral_fantasy.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.floral_fantasy.entity.PrimalEndermanEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PrimalEndermanRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PrimalEndermanEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelprimal_enderman(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("floral_fantasy:textures/primal_enderman.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("floral_fantasy:textures/primal_enderman_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelprimal_enderman extends EntityModel<Entity> {
		private final ModelRenderer primal_enderman;
		private final ModelRenderer head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer arms;
		private final ModelRenderer left_arm;
		private final ModelRenderer left_arm2;
		private final ModelRenderer right_arm;
		private final ModelRenderer right_arm2;
		private final ModelRenderer legs;
		private final ModelRenderer left_leg;
		private final ModelRenderer left_leg2;
		private final ModelRenderer right_leg;
		private final ModelRenderer right_leg2;

		public Modelprimal_enderman() {
			textureWidth = 64;
			textureHeight = 64;
			primal_enderman = new ModelRenderer(this);
			primal_enderman.setRotationPoint(0.0F, 2.0F, 3.0F);
			setRotationAngle(primal_enderman, 0.1745F, 0.0F, 0.0F);
			primal_enderman.setTextureOffset(0, 24).addBox(-4.0F, -16.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -16.25F, -1.25F);
			primal_enderman.addChild(head);
			setRotationAngle(head, 0.1745F, 0.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -2.3473F, 2.0304F);
			head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1309F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 14).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -2.3473F, 2.0304F);
			head.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0873F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 0.0F, 0.0F);
			primal_enderman.addChild(arms);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, -16.0F, 0.0F);
			arms.addChild(left_arm);
			setRotationAngle(left_arm, -0.1262F, -0.1354F, -0.0265F);
			left_arm.setTextureOffset(24, 24).addBox(0.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			left_arm2 = new ModelRenderer(this);
			left_arm2.setRotationPoint(1.0F, 16.0F, 1.0F);
			left_arm.addChild(left_arm2);
			setRotationAngle(left_arm2, -0.1745F, 0.0F, 0.0F);
			left_arm2.setTextureOffset(32, 36).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, -16.0F, 0.0F);
			arms.addChild(right_arm);
			setRotationAngle(right_arm, -0.1252F, 0.1308F, 0.044F);
			right_arm.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			right_arm2 = new ModelRenderer(this);
			right_arm2.setRotationPoint(-1.0F, 16.0F, 1.0F);
			right_arm.addChild(right_arm2);
			setRotationAngle(right_arm2, -0.1745F, 0.0F, 0.0F);
			right_arm2.setTextureOffset(32, 18).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 0.0F, 0.0F);
			primal_enderman.addChild(legs);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, -4.0F, 0.0F);
			legs.addChild(left_leg);
			setRotationAngle(left_leg, -0.3026F, -0.1795F, 0.0107F);
			left_leg.setTextureOffset(40, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(0.0F, 13.0F, 0.0F);
			left_leg.addChild(left_leg2);
			setRotationAngle(left_leg2, 0.2618F, 0.0F, 0.0F);
			left_leg2.setTextureOffset(40, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, -4.0F, 0.0F);
			legs.addChild(right_leg);
			setRotationAngle(right_leg, -0.2584F, 0.1377F, 0.0085F);
			right_leg.setTextureOffset(0, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(0.0F, 13.0F, 0.0F);
			right_leg.addChild(right_leg2);
			setRotationAngle(right_leg2, 0.1745F, 0.0F, 0.0F);
			right_leg2.setTextureOffset(8, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			primal_enderman.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
