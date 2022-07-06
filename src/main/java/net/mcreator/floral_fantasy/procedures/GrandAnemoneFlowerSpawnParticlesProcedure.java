package net.mcreator.floral_fantasy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.floral_fantasy.particle.AnemonePetalsParticle;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class GrandAnemoneFlowerSpawnParticlesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure GrandAnemoneFlowerSpawnParticles!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure GrandAnemoneFlowerSpawnParticles!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure GrandAnemoneFlowerSpawnParticles!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure GrandAnemoneFlowerSpawnParticles!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double randomLocation = 0;
		if (world.isRemote()) {
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.AIR) {
				randomLocation = Math.random();
				if (randomLocation <= 1 && randomLocation >= 0.8) {
					world.addParticle(AnemonePetalsParticle.particle, (x + 0.125), (y + 0.5), (z + 0.125), 0, 0.5, 0);
				} else if (randomLocation < 0.8 && randomLocation >= 0.6) {
					world.addParticle(AnemonePetalsParticle.particle, (x + 0.125), (y + 0.5), (z + 0.875), 0, 0.5, 0);
				} else if (randomLocation < 0.6 && randomLocation >= 0.4) {
					world.addParticle(AnemonePetalsParticle.particle, (x + 0.5), (y + 0.5), (z + 0.5), 0, 0.5, 0);
				} else if (randomLocation < 0.4 && randomLocation >= 0.2) {
					world.addParticle(AnemonePetalsParticle.particle, (x + 0.875), (y + 0.5), (z + 0.125), 0, 0.5, 0);
				} else if (randomLocation < 0.2 && randomLocation >= 0) {
					world.addParticle(AnemonePetalsParticle.particle, (x + 0.875), (y + 0.5), (z + 0.875), 0, 0.5, 0);
				}
			}
		}
	}
}
