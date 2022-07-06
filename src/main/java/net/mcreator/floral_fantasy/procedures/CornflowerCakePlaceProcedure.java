package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.item.CornflowerCakeItem;
import net.mcreator.floral_fantasy.block.CornflowerCakeFullBlock;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class CornflowerCakePlaceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure CornflowerCakePlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure CornflowerCakePlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure CornflowerCakePlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure CornflowerCakePlace!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure CornflowerCakePlace!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
		if (world.getBlockState(new BlockPos(x, y, z)).isSolid()) {
			if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CornflowerCakeItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			world.setBlockState(new BlockPos(x, y + 1, z), CornflowerCakeFullBlock.block.getDefaultState(), 3);
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.place")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
		}
	}
}
