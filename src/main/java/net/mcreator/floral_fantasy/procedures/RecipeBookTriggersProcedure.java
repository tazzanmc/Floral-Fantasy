package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.floral_fantasy.item.ShadeRodItem;
import net.mcreator.floral_fantasy.item.AncientBoneItem;
import net.mcreator.floral_fantasy.block.WeepingBellBlock;
import net.mcreator.floral_fantasy.block.HydrangeaBushBlock;
import net.mcreator.floral_fantasy.block.GrandAnemoneFlowerBlock;
import net.mcreator.floral_fantasy.block.DeathBloomBlock;
import net.mcreator.floral_fantasy.block.AnemoneFlowerBlock;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;
import java.util.HashMap;

public class RecipeBookTriggersProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPickup(EntityItemPickupEvent event) {
			PlayerEntity entity = event.getPlayer();
			ItemStack itemstack = event.getItem().getItem();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("itemstack", itemstack);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure RecipeBookTriggers!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency itemstack for procedure RecipeBookTriggers!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == DeathBloomBlock.block.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:purple_dye_from_death_bloom")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:death_bloom_pie")});
			}
		}
		if (((itemstack).getItem() == AnemoneFlowerBlock.block.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:pink_dye_anemone_flower")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:sweet_anemone_pie")});
			}
		}
		if (((itemstack).getItem() == Blocks.CORNFLOWER.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:cornflower_cake")});
			}
		}
		if (((itemstack).getItem() == Blocks.POPPY.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:poppy_pastry")});
			}
		}
		if (((itemstack).getItem() == HydrangeaBushBlock.block.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:hydrangea_muffin")});
			}
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:blue_dye_hydrangea")});
			}
		}
		if (((itemstack).getItem() == Blocks.DANDELION.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:dandy_dandelion_crumble")});
			}
		}
		if (((itemstack).getItem() == WeepingBellBlock.block.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:lime_dye_weeping_bell")});
			}
		}
		if (((itemstack).getItem() == GrandAnemoneFlowerBlock.block.asItem())) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity)
						.unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:pink_dye_grand_anemone_flower")});
			}
		}
		if (((itemstack).getItem() == AncientBoneItem.block)) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:rich_dirt")});
			}
		}
		if ((((itemstack).getItem() == ShadeRodItem.block) || ((itemstack).getItem() == Items.NETHERITE_INGOT))) {
			if (entity instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("floral_fantasy:infuser")});
			}
		}
	}
}
