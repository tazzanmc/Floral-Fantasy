package net.mcreator.floral_fantasy.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.potion.FeebleMindednessPotionEffect;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class FeebleMindednessInfusionFoodEatenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure FeebleMindednessInfusionFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(FeebleMindednessPotionEffect.potion, (int) 200, (int) 0));
	}
}
