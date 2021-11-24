package net.mcreator.floral_fantasy.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.potion.CripplingPotionEffect;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;
import java.util.Collection;

public class EffectCripplingStartedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure EffectCripplingStarted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)
				.setBaseValue((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - (1 + (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == CripplingPotionEffect.potion)
									return effect.getAmplifier();
							}
						}
						return 0;
					}
				}.check(entity)))));
		entity.attackEntityFrom(DamageSource.MAGIC, (float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				- (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - (1 + (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == CripplingPotionEffect.potion)
									return effect.getAmplifier();
							}
						}
						return 0;
					}
				}.check(entity))))));
	}
}
