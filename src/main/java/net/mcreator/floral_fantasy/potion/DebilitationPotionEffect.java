
package net.mcreator.floral_fantasy.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.World;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.LivingEntity;

import net.mcreator.floral_fantasy.procedures.EffectDebilitationStartedProcedure;
import net.mcreator.floral_fantasy.procedures.EffectDebilitationEndedProcedure;
import net.mcreator.floral_fantasy.procedures.DebilitationOnEffectActiveTickProcedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DebilitationPotionEffect {
	@ObjectHolder("floral_fantasy:debilitation")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {
		public EffectCustom() {
			super(EffectType.HARMFUL, -13291215);
			setRegistryName("debilitation");
		}

		@Override
		public String getName() {
			return "effect.debilitation";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public void applyAttributesModifiersToEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			EffectDebilitationStartedProcedure.executeProcedure(Collections.emptyMap());
		}

		@Override
		public void performEffect(LivingEntity entity, int amplifier) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			DebilitationOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			EffectDebilitationEndedProcedure.executeProcedure(Collections.emptyMap());
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
