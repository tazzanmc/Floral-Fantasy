package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.block.HydrangeaBushBlock;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;
import java.util.HashMap;

public class HydrangeaDuplicateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBonemeal(BonemealEvent event) {
			PlayerEntity entity = event.getPlayer();
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			World world = event.getWorld();
			ItemStack itemstack = event.getStack();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("itemstack", itemstack);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getBlock());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure HydrangeaDuplicate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure HydrangeaDuplicate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure HydrangeaDuplicate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure HydrangeaDuplicate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure HydrangeaDuplicate!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency itemstack for procedure HydrangeaDuplicate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == HydrangeaBushBlock.block) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			(itemstack).shrink((int) 1);
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(HydrangeaBushBlock.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), (int) 10, 0.25, 0.25, 0.25, 1);
			}
		}
	}
}
