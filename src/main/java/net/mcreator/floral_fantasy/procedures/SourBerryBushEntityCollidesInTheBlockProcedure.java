package net.mcreator.floral_fantasy.procedures;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class SourBerryBushEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure SourBerryBushEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
	}
}
