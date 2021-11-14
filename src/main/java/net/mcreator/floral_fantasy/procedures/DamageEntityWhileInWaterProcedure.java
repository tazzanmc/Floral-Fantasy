package net.mcreator.floral_fantasy.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class DamageEntityWhileInWaterProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure DamageEntityWhileInWater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isInWaterRainOrBubbleColumn())) {
			entity.attackEntityFrom(DamageSource.DROWN, (float) 1);
		}
	}
}
