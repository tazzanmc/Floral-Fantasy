
package net.mcreator.floral_fantasy.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.floral_fantasy.procedures.InfuserBreathMeterShowProcedure;
import net.mcreator.floral_fantasy.procedures.InfuserBlazeMeterShowProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class GUIInfuserGuiWindow extends ContainerScreen<GUIInfuserGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GUIInfuserGui.guistate;
	public GUIInfuserGuiWindow(GUIInfuserGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_gui.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 175, 165, 175, 165);
		if (InfuserBlazeMeterShowProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_blaze_meter.png"));
			this.blit(ms, this.guiLeft + 58, this.guiTop + 70, 0, 0, 18, 4, 18, 4);
		}
		if (InfuserBreathMeterShowProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_breath_meter.png"));
			this.blit(ms, this.guiLeft + 98, this.guiTop + 70, 0, 0, 18, 4, 18, 4);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_progress_arrow.png"));
		this.blit(ms, this.guiLeft + 83, this.guiTop + 17, 0, 0, 8, 19, 8, 19);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_blaze_bubbles.png"));
		this.blit(ms, this.guiLeft + 61, this.guiTop + 40, 0, 0, 12, 29, 12, 29);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("floral_fantasy:textures/infuser_breath_bubbles.png"));
		this.blit(ms, this.guiLeft + 102, this.guiTop + 40, 0, 0, 12, 29, 12, 29);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Infuser", 68, 5, -11184811);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
