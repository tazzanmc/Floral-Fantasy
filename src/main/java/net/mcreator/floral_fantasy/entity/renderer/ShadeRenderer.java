package net.mcreator.floral_fantasy.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.floral_fantasy.entity.ShadeEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShadeRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShadeEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelshade(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("floral_fantasy:textures/shade.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("floral_fantasy:textures/shade.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
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
