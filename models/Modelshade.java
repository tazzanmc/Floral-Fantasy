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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		shade.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.armgroup2.rotateAngleZ = f2;
		this.armgroup1.rotateAngleZ = f2 / 20.f;
		this.shade.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.shade.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}