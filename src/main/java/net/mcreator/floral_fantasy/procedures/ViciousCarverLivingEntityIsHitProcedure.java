package net.mcreator.floral_fantasy.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.potion.CripplingPotionEffect;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class ViciousCarverLivingEntityIsHitProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure ViciousCarverLivingEntityIsHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(CripplingPotionEffect.potion, (int) 300, (int) 0));
	}
}
