package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.floral_fantasy.enchantment.ShatteringCurseEnchantment;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class ShatteringCurseItemsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double duration = event.getDuration();
				ItemStack itemstack = event.getItem();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("itemstack", itemstack);
				dependencies.put("duration", duration);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShatteringCurseItems!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment, itemstack) != 0)) {
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) (EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment, itemstack) + 1),
						new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
