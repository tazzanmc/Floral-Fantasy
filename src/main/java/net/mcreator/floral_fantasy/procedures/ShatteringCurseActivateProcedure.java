package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.floral_fantasy.enchantment.ShatteringCurseEnchantment;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class ShatteringCurseActivateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity immediatesourceentity = event.getSource().getImmediateSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("immediatesourceentity", immediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure ShatteringCurseActivate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)) != 0)) {
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) (EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY))
						+ 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		if ((EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)) != 0)) {
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) (EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY))
						+ 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		if ((EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)) != 0)) {
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) (EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY))
						+ 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		if ((EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)) != 0)) {
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD)
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) (EnchantmentHelper.getEnchantmentLevel(ShatteringCurseEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY))
						+ 1), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
