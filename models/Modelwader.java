// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelwader extends EntityModel<Entity> {
	private final ModelRenderer wader;
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer lefthairs;
	private final ModelRenderer righthairs;
	private final ModelRenderer cube_r2;
	private final ModelRenderer middlesegment;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bottomsegment;
	private final ModelRenderer cube_r4;
	private final ModelRenderer legs;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public Modelwader() {
		textureWidth = 64;
		textureHeight = 64;

		wader = new ModelRenderer(this);
		wader.setRotationPoint(0.0F, 12.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -6.0F, 0.0F);
		wader.addChild(head);
		head.setTextureOffset(0, 36).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 6.0F, 10.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-5.0F, -5.0F, 0.0F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3927F);
		cube_r1.setTextureOffset(30, 26).addBox(0.0F, 0.0F, -5.0F, 0.0F, 6.0F, 10.0F, 0.0F, false);

		lefthairs = new ModelRenderer(this);
		lefthairs.setRotationPoint(-5.0F, -5.0F, 0.0F);
		head.addChild(lefthairs);

		righthairs = new ModelRenderer(this);
		righthairs.setRotationPoint(5.0F, -5.0F, 0.0F);
		head.addChild(righthairs);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		righthairs.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3927F);
		cube_r2.setTextureOffset(36, 8).addBox(0.0F, 0.0F, -5.0F, 0.0F, 6.0F, 10.0F, 0.0F, false);

		middlesegment = new ModelRenderer(this);
		middlesegment.setRotationPoint(0.0F, -3.0F, 0.0F);
		wader.addChild(middlesegment);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 3.0F, 0.0F);
		middlesegment.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0436F, 0.0F);
		cube_r3.setTextureOffset(0, 18).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);

		bottomsegment = new ModelRenderer(this);
		bottomsegment.setRotationPoint(0.0F, 3.0F, 0.0F);
		wader.addChild(bottomsegment);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -3.0F, 0.0F);
		bottomsegment.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.0436F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 6.0F, 12.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, -3.0F, 0.0F);
		bottomsegment.addChild(legs);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-2.5F, 6.0F, 0.0F);
		legs.addChild(leftleg);
		leftleg.setTextureOffset(0, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(2.5F, 6.0F, 0.0F);
		legs.addChild(rightleg);
		rightleg.setTextureOffset(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		wader.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}