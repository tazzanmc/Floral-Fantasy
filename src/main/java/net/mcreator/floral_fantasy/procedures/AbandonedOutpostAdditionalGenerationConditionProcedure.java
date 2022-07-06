package net.mcreator.floral_fantasy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class AbandonedOutpostAdditionalGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure AbandonedOutpostAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure AbandonedOutpostAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure AbandonedOutpostAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure AbandonedOutpostAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world.getBlockState(new BlockPos(x - 8, y - 2, z - 8)).isSolid()) {
			return true;
		}
		return false;
	}
}
