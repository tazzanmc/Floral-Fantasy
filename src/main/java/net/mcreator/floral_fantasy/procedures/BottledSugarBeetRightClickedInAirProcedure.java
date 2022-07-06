package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.item.SugarBeetItem;
import net.mcreator.floral_fantasy.item.BottledSugarBeetItem;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class BottledSugarBeetRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure BottledSugarBeetRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure BottledSugarBeetRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure BottledSugarBeetRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure BottledSugarBeetRightClickedInAir!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure BottledSugarBeetRightClickedInAir!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == BottledSugarBeetItem.block) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.25), (z + 0.5), new ItemStack(SugarBeetItem.block));
				entityToSpawn.setPickupDelay((int) 0);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 1.25), (z + 0.5), new ItemStack(Items.GLASS_BOTTLE));
				entityToSpawn.setPickupDelay((int) 0);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honey_bottle.drink")),
						SoundCategory.PLAYERS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honey_bottle.drink")),
						SoundCategory.PLAYERS, (float) 1, (float) 1, false);
			}
		}
	}
}
