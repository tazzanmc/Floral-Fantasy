
package net.mcreator.floral_fantasy.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.floral_fantasy.entity.ForgottenSkeletonEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ForgottenSkeletonRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ForgottenSkeletonEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelforgotten_skeleton(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("floral_fantasy:textures/forgotten_skeleton.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelforgotten_skeleton extends EntityModel<Entity> {
		private final ModelRenderer forgotten_skeleton;
		private final ModelRenderer body;
		private final ModelRenderer body_r1;
		private final ModelRenderer back_flower_2_r1;
		private final ModelRenderer back_flower_1_r1;
		private final ModelRenderer arms;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightarm;
		private final ModelRenderer legs;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer head;
		private final ModelRenderer flower_r1;
		private final ModelRenderer head_r1;

		public Modelforgotten_skeleton() {
			textureWidth = 64;
			textureHeight = 64;
			forgotten_skeleton = new ModelRenderer(this);
			forgotten_skeleton.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -8.0F, 2.0F);
			forgotten_skeleton.addChild(body);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(0.0F, -10.0F, 0.0F);
			body.addChild(body_r1);
			setRotationAngle(body_r1, 0.3927F, 0.0F, 0.0F);
			body_r1.setTextureOffset(0, 16).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			back_flower_2_r1 = new ModelRenderer(this);
			back_flower_2_r1.setRotationPoint(-2.5F, -11.142F, 1.2895F);
			body.addChild(back_flower_2_r1);
			setRotationAngle(back_flower_2_r1, 0.3932F, -0.0639F, -0.0737F);
			back_flower_2_r1.setTextureOffset(8, 37).addBox(-2.6F, -2.5F, 0.1F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			back_flower_1_r1 = new ModelRenderer(this);
			back_flower_1_r1.setRotationPoint(3.0736F, -15.1048F, 0.5347F);
			body.addChild(back_flower_1_r1);
			setRotationAngle(back_flower_1_r1, 0.4805F, 0.2267F, 0.2321F);
			back_flower_1_r1.setTextureOffset(8, 32).addBox(-2.5F, -2.6F, -0.6F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(arms);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(4.0F, -13.75F, -2.0F);
			arms.addChild(leftarm);
			leftarm.setTextureOffset(30, 28).addBox(0.1F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-4.0F, -13.75F, -2.0F);
			arms.addChild(rightarm);
			rightarm.setTextureOffset(0, 32).addBox(-2.1F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(legs);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-2.0F, -4.0F, 2.0F);
			legs.addChild(left_leg);
			left_leg.setTextureOffset(24, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(2.0F, -4.0F, 2.0F);
			legs.addChild(right_leg);
			right_leg.setTextureOffset(22, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -14.5F, -2.0F);
			body.addChild(head);
			setRotationAngle(head, 0.0F, 0.0F, -0.1309F);
			flower_r1 = new ModelRenderer(this);
			flower_r1.setRotationPoint(4.25F, -4.0F, -8.5F);
			head.addChild(flower_r1);
			setRotationAngle(flower_r1, -0.2533F, 0.7519F, -0.3622F);
			flower_r1.setTextureOffset(8, 27).addBox(0.9F, -2.9F, -3.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(0.0F, -5.5F, 2.0F);
			head.addChild(head_r1);
			setRotationAngle(head_r1, 0.3927F, 0.0F, 0.0F);
			head_r1.setTextureOffset(0, 0).addBox(-4.0F, -3.75F, -11.25F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			forgotten_skeleton.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
