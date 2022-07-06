
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

import net.mcreator.floral_fantasy.entity.OvergrownSkeletonEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class OvergrownSkeletonRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(OvergrownSkeletonEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelovergrown_skeleton(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("floral_fantasy:textures/overgrown_skeleton.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelovergrown_skeleton extends EntityModel<Entity> {
		private final ModelRenderer overgrown_skeleton;
		private final ModelRenderer body;
		private final ModelRenderer body_r1;
		private final ModelRenderer back_flower_4_r1;
		private final ModelRenderer back_flower_3_r1;
		private final ModelRenderer back_flower_2_r1;
		private final ModelRenderer back_flower_1_r1;
		private final ModelRenderer arms;
		private final ModelRenderer leftvine;
		private final ModelRenderer leftvine7;
		private final ModelRenderer left_vine_7_r1;
		private final ModelRenderer leftvine6;
		private final ModelRenderer left_vine_6_r1;
		private final ModelRenderer leftvine5;
		private final ModelRenderer left_vine_5_r1;
		private final ModelRenderer leftvine4;
		private final ModelRenderer left_vine_4_r1;
		private final ModelRenderer leftvine3;
		private final ModelRenderer back_flower_4_r2;
		private final ModelRenderer left_vine_3_r1;
		private final ModelRenderer leftvine2;
		private final ModelRenderer left_vine_2_r1;
		private final ModelRenderer leftvine1;
		private final ModelRenderer left_vine_1_r1;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightvine;
		private final ModelRenderer rightvine7;
		private final ModelRenderer right_vine_7_r1;
		private final ModelRenderer rightvine6;
		private final ModelRenderer right_vine_6_r1;
		private final ModelRenderer rightvine5;
		private final ModelRenderer flower_r1;
		private final ModelRenderer right_vine_5_r1;
		private final ModelRenderer rightvine4;
		private final ModelRenderer right_vine_4_r1;
		private final ModelRenderer rightvine3;
		private final ModelRenderer right_vine_3_r1;
		private final ModelRenderer rightvine2;
		private final ModelRenderer right_vine_2_r1;
		private final ModelRenderer rightvine1;
		private final ModelRenderer right_vine_1_r1;
		private final ModelRenderer rightarm;
		private final ModelRenderer legs;
		private final ModelRenderer leftleg;
		private final ModelRenderer leftleg2;
		private final ModelRenderer rightleg;
		private final ModelRenderer rightleg2;
		private final ModelRenderer head;
		private final ModelRenderer flower_r2;

		public Modelovergrown_skeleton() {
			textureWidth = 128;
			textureHeight = 128;
			overgrown_skeleton = new ModelRenderer(this);
			overgrown_skeleton.setRotationPoint(0.0F, 24.0F, -6.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -12.0F, 4.0F);
			overgrown_skeleton.addChild(body);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(0.0F, -6.0F, -2.0F);
			body.addChild(body_r1);
			setRotationAngle(body_r1, 0.3927F, 0.0F, 0.0F);
			body_r1.setTextureOffset(64, 0).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			back_flower_4_r1 = new ModelRenderer(this);
			back_flower_4_r1.setRotationPoint(-3.6972F, 0.1023F, 2.2031F);
			body.addChild(back_flower_4_r1);
			setRotationAngle(back_flower_4_r1, 0.1804F, -0.3527F, -0.2989F);
			back_flower_4_r1.setTextureOffset(8, 83).addBox(-1.25F, -2.75F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
			back_flower_3_r1 = new ModelRenderer(this);
			back_flower_3_r1.setRotationPoint(2.5861F, -2.925F, 1.6063F);
			body.addChild(back_flower_3_r1);
			setRotationAngle(back_flower_3_r1, 0.3667F, 0.4283F, -0.0134F);
			back_flower_3_r1.setTextureOffset(32, 63).addBox(-1.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			back_flower_2_r1 = new ModelRenderer(this);
			back_flower_2_r1.setRotationPoint(-2.5F, -7.142F, -0.7105F);
			body.addChild(back_flower_2_r1);
			setRotationAngle(back_flower_2_r1, 0.3932F, -0.0639F, -0.0737F);
			back_flower_2_r1.setTextureOffset(42, 63).addBox(-2.6F, -2.5F, 0.1F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			back_flower_1_r1 = new ModelRenderer(this);
			back_flower_1_r1.setRotationPoint(3.0736F, -11.1048F, -1.4653F);
			body.addChild(back_flower_1_r1);
			setRotationAngle(back_flower_1_r1, 0.4805F, 0.2267F, 0.2321F);
			back_flower_1_r1.setTextureOffset(12, 63).addBox(-2.5F, -3.6F, -0.6F, 6.0F, 6.0F, 0.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 4.0F, -2.0F);
			body.addChild(arms);
			leftvine = new ModelRenderer(this);
			leftvine.setRotationPoint(4.0F, -14.0F, -2.0F);
			arms.addChild(leftvine);
			leftvine7 = new ModelRenderer(this);
			leftvine7.setRotationPoint(0.2426F, -0.1315F, -0.5148F);
			leftvine.addChild(leftvine7);
			left_vine_7_r1 = new ModelRenderer(this);
			left_vine_7_r1.setRotationPoint(0.0F, -0.25F, 0.25F);
			leftvine7.addChild(left_vine_7_r1);
			setRotationAngle(left_vine_7_r1, 0.336F, 0.0665F, -0.3873F);
			left_vine_7_r1.setTextureOffset(0, 77).addBox(-0.4269F, -0.1854F, -1.4957F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine6 = new ModelRenderer(this);
			leftvine6.setRotationPoint(1.8574F, 2.4374F, 1.238F);
			leftvine7.addChild(leftvine6);
			left_vine_6_r1 = new ModelRenderer(this);
			left_vine_6_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			leftvine6.addChild(left_vine_6_r1);
			setRotationAngle(left_vine_6_r1, 0.1745F, 0.0F, 0.0F);
			left_vine_6_r1.setTextureOffset(8, 77).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine5 = new ModelRenderer(this);
			leftvine5.setRotationPoint(0.0F, 3.7504F, 0.2458F);
			leftvine6.addChild(leftvine5);
			left_vine_5_r1 = new ModelRenderer(this);
			left_vine_5_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			leftvine5.addChild(left_vine_5_r1);
			setRotationAngle(left_vine_5_r1, -0.0436F, 0.0F, 0.0F);
			left_vine_5_r1.setTextureOffset(16, 77).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine4 = new ModelRenderer(this);
			leftvine4.setRotationPoint(0.0F, 3.4317F, 0.1603F);
			leftvine5.addChild(leftvine4);
			left_vine_4_r1 = new ModelRenderer(this);
			left_vine_4_r1.setRotationPoint(0.0F, 2.0F, -1.0F);
			leftvine4.addChild(left_vine_4_r1);
			setRotationAngle(left_vine_4_r1, -0.4363F, 0.0F, 0.0F);
			left_vine_4_r1.setTextureOffset(24, 77).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine3 = new ModelRenderer(this);
			leftvine3.setRotationPoint(0.0F, 3.4317F, -1.8397F);
			leftvine4.addChild(leftvine3);
			back_flower_4_r2 = new ModelRenderer(this);
			back_flower_4_r2.setRotationPoint(3.7627F, -5.9425F, 2.9938F);
			leftvine3.addChild(back_flower_4_r2);
			setRotationAngle(back_flower_4_r2, 2.3161F, 1.111F, 2.1993F);
			back_flower_4_r2.setTextureOffset(32, 63).addBox(4.25F, 2.5F, -1.75F, 5.0F, 5.0F, 0.0F, 0.0F, false);
			left_vine_3_r1 = new ModelRenderer(this);
			left_vine_3_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			leftvine3.addChild(left_vine_3_r1);
			setRotationAngle(left_vine_3_r1, -0.0436F, 0.0F, 0.0F);
			left_vine_3_r1.setTextureOffset(32, 77).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine2 = new ModelRenderer(this);
			leftvine2.setRotationPoint(0.0F, 3.2534F, -0.2478F);
			leftvine3.addChild(leftvine2);
			left_vine_2_r1 = new ModelRenderer(this);
			left_vine_2_r1.setRotationPoint(0.0F, 1.5F, 1.25F);
			leftvine2.addChild(left_vine_2_r1);
			setRotationAngle(left_vine_2_r1, 0.7418F, 0.0F, 0.0F);
			left_vine_2_r1.setTextureOffset(40, 77).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftvine1 = new ModelRenderer(this);
			leftvine1.setRotationPoint(-2.1F, 2.5768F, 1.9582F);
			leftvine2.addChild(leftvine1);
			left_vine_1_r1 = new ModelRenderer(this);
			left_vine_1_r1.setRotationPoint(0.0F, -1.0F, 4.0F);
			leftvine1.addChild(left_vine_1_r1);
			setRotationAngle(left_vine_1_r1, 1.5272F, 0.0F, 0.0F);
			left_vine_1_r1.setTextureOffset(48, 77).addBox(1.1F, -4.0F, -2.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(2.0F, 0.25F, 4.0F);
			leftvine1.addChild(leftarm);
			setRotationAngle(leftarm, 1.5272F, 0.0F, 0.0F);
			leftarm.setTextureOffset(0, 16).addBox(-1.9F, -0.0446F, -1.9573F, 4.0F, 14.0F, 4.0F, 0.0F, false);
			leftarm.setTextureOffset(50, 34).addBox(-0.9F, 4.9554F, -0.9573F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			leftarm.setTextureOffset(34, 34).addBox(-2.9F, 9.9554F, -2.9573F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 52).addBox(0.1F, 11.9554F, -0.9573F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			leftarm.setTextureOffset(16, 44).addBox(1.1F, 8.9554F, 0.0427F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			leftarm.setTextureOffset(40, 52).addBox(-2.9F, 3.9554F, -2.9573F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(44, 44).addBox(-3.9F, 6.9554F, -3.9573F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 63).addBox(0.1F, -0.7946F, -2.9573F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			rightvine = new ModelRenderer(this);
			rightvine.setRotationPoint(-4.0F, -14.0F, -2.0F);
			arms.addChild(rightvine);
			rightvine7 = new ModelRenderer(this);
			rightvine7.setRotationPoint(-0.2697F, -0.6259F, -0.1241F);
			rightvine.addChild(rightvine7);
			right_vine_7_r1 = new ModelRenderer(this);
			right_vine_7_r1.setRotationPoint(0.0F, 0.2938F, -0.25F);
			rightvine7.addChild(right_vine_7_r1);
			setRotationAngle(right_vine_7_r1, 0.1745F, 0.0F, 0.3491F);
			right_vine_7_r1.setTextureOffset(48, 71).addBox(-1.8533F, -0.4199F, -0.8697F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine6 = new ModelRenderer(this);
			rightvine6.setRotationPoint(-1.8803F, 2.9318F, 0.8473F);
			rightvine7.addChild(rightvine6);
			right_vine_6_r1 = new ModelRenderer(this);
			right_vine_6_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			rightvine6.addChild(right_vine_6_r1);
			setRotationAngle(right_vine_6_r1, 0.1745F, 0.0F, 0.0F);
			right_vine_6_r1.setTextureOffset(40, 71).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine5 = new ModelRenderer(this);
			rightvine5.setRotationPoint(0.0F, 3.7504F, 0.2458F);
			rightvine6.addChild(rightvine5);
			flower_r1 = new ModelRenderer(this);
			flower_r1.setRotationPoint(-1.1712F, 1.3168F, -1.2449F);
			rightvine5.addChild(flower_r1);
			setRotationAngle(flower_r1, -2.6081F, 0.4481F, -3.107F);
			flower_r1.setTextureOffset(14, 52).addBox(0.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
			right_vine_5_r1 = new ModelRenderer(this);
			right_vine_5_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			rightvine5.addChild(right_vine_5_r1);
			setRotationAngle(right_vine_5_r1, -0.0436F, 0.0F, 0.0F);
			right_vine_5_r1.setTextureOffset(32, 71).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine4 = new ModelRenderer(this);
			rightvine4.setRotationPoint(0.0F, 3.4317F, -0.0897F);
			rightvine5.addChild(rightvine4);
			right_vine_4_r1 = new ModelRenderer(this);
			right_vine_4_r1.setRotationPoint(0.0F, 2.0F, -0.75F);
			rightvine4.addChild(right_vine_4_r1);
			setRotationAngle(right_vine_4_r1, -0.4363F, 0.0F, 0.0F);
			right_vine_4_r1.setTextureOffset(24, 71).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine3 = new ModelRenderer(this);
			rightvine3.setRotationPoint(0.0F, 3.4317F, -1.5897F);
			rightvine4.addChild(rightvine3);
			right_vine_3_r1 = new ModelRenderer(this);
			right_vine_3_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
			rightvine3.addChild(right_vine_3_r1);
			setRotationAngle(right_vine_3_r1, -0.0436F, 0.0F, 0.0F);
			right_vine_3_r1.setTextureOffset(16, 71).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine2 = new ModelRenderer(this);
			rightvine2.setRotationPoint(0.0F, 3.2534F, -0.2478F);
			rightvine3.addChild(rightvine2);
			right_vine_2_r1 = new ModelRenderer(this);
			right_vine_2_r1.setRotationPoint(0.0F, 1.5F, 1.25F);
			rightvine2.addChild(right_vine_2_r1);
			setRotationAngle(right_vine_2_r1, 0.7418F, 0.0F, 0.0F);
			right_vine_2_r1.setTextureOffset(8, 71).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightvine1 = new ModelRenderer(this);
			rightvine1.setRotationPoint(-2.1F, 2.8268F, 1.9582F);
			rightvine2.addChild(rightvine1);
			right_vine_1_r1 = new ModelRenderer(this);
			right_vine_1_r1.setRotationPoint(0.0F, -1.25F, 4.0F);
			rightvine1.addChild(right_vine_1_r1);
			setRotationAngle(right_vine_1_r1, 1.5272F, 0.0F, 0.0F);
			right_vine_1_r1.setTextureOffset(0, 71).addBox(1.1F, -4.0F, -2.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(2.25F, 0.25F, 5.0F);
			rightvine1.addChild(rightarm);
			setRotationAngle(rightarm, 1.5272F, 0.0F, 0.0F);
			rightarm.setTextureOffset(16, 16).addBox(-2.1F, -1.0436F, -2.001F, 4.0F, 14.0F, 4.0F, 0.0F, false);
			rightarm.setTextureOffset(18, 34).addBox(-3.1F, 7.9564F, -3.001F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			rightarm.setTextureOffset(30, 44).addBox(-0.1F, 7.9564F, -1.001F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			rightarm.setTextureOffset(32, 16).addBox(-3.1F, -2.0436F, -3.001F, 4.0F, 3.0F, 6.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 44).addBox(-4.1F, -0.0436F, -0.001F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 83).addBox(-3.1F, 3.9564F, 0.999F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			rightarm.setTextureOffset(0, 34).addBox(-1.1F, 4.9564F, -4.001F, 5.0F, 5.0F, 4.0F, 0.0F, false);
			rightarm.setTextureOffset(58, 44).addBox(-1.1F, 2.9564F, -3.001F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			rightarm.setTextureOffset(16, 83).addBox(0.9F, 9.9564F, -3.001F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 4.0F, -2.0F);
			body.addChild(legs);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(-2.0F, -4.0F, 2.0F);
			legs.addChild(leftleg);
			setRotationAngle(leftleg, 0.3927F, 0.0F, 0.0F);
			leftleg.setTextureOffset(24, 63).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			leftleg2 = new ModelRenderer(this);
			leftleg2.setRotationPoint(0.0F, 5.5F, 0.0F);
			leftleg.addChild(leftleg2);
			setRotationAngle(leftleg2, 0.3927F, 0.0F, 0.0F);
			leftleg2.setTextureOffset(24, 52).addBox(-1.0F, 0.0793F, -1.1152F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(2.0F, -4.0F, 2.0F);
			legs.addChild(rightleg);
			setRotationAngle(rightleg, -0.3927F, 0.0F, 0.0F);
			rightleg.setTextureOffset(52, 63).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			rightleg2 = new ModelRenderer(this);
			rightleg2.setRotationPoint(0.0F, 4.25F, -0.25F);
			rightleg.addChild(rightleg2);
			setRotationAngle(rightleg2, 0.7854F, 0.0F, 0.0F);
			rightleg2.setTextureOffset(32, 52).addBox(-1.0F, 0.0F, -1.0607F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -11.0F, -3.5F);
			body.addChild(head);
			setRotationAngle(head, 0.2128F, 0.0665F, -0.1615F);
			head.setTextureOffset(32, 0).addBox(-5.0F, -1.7954F, -8.9508F, 10.0F, 3.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-4.0F, -7.7954F, -7.9508F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			flower_r2 = new ModelRenderer(this);
			flower_r2.setRotationPoint(-4.1835F, -7.6338F, -7.7919F);
			head.addChild(flower_r2);
			setRotationAngle(flower_r2, -2.6815F, 0.538F, -2.7865F);
			flower_r2.setTextureOffset(14, 52).addBox(0.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			overgrown_skeleton.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftvine.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rightvine.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
