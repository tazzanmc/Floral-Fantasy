
package net.mcreator.floral_fantasy.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.floral_fantasy.FloralFantasyModElements;

@FloralFantasyModElements.ModElement.Tag
public class SteeledEnchantment extends FloralFantasyModElements.ModElement {
	@ObjectHolder("floral_fantasy:steeled")
	public static final Enchantment enchantment = null;

	public SteeledEnchantment(FloralFantasyModElements instance) {
		super(instance, 312);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("steeled"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.WEARABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.RESPIRATION)
				return true;
			if (ench == Enchantments.AQUA_AFFINITY)
				return true;
			if (ench == Enchantments.THORNS)
				return true;
			if (ench == Enchantments.DEPTH_STRIDER)
				return true;
			if (ench == Enchantments.FROST_WALKER)
				return true;
			if (ench == Enchantments.BINDING_CURSE)
				return true;
			if (ench == Enchantments.SHARPNESS)
				return true;
			if (ench == Enchantments.SMITE)
				return true;
			if (ench == Enchantments.BANE_OF_ARTHROPODS)
				return true;
			if (ench == Enchantments.KNOCKBACK)
				return true;
			if (ench == Enchantments.FIRE_ASPECT)
				return true;
			if (ench == Enchantments.LOOTING)
				return true;
			if (ench == Enchantments.SWEEPING)
				return true;
			if (ench == Enchantments.EFFICIENCY)
				return true;
			if (ench == Enchantments.SILK_TOUCH)
				return true;
			if (ench == Enchantments.UNBREAKING)
				return true;
			if (ench == Enchantments.FORTUNE)
				return true;
			if (ench == Enchantments.POWER)
				return true;
			if (ench == Enchantments.PUNCH)
				return true;
			if (ench == Enchantments.FLAME)
				return true;
			if (ench == Enchantments.INFINITY)
				return true;
			if (ench == Enchantments.LUCK_OF_THE_SEA)
				return true;
			if (ench == Enchantments.LURE)
				return true;
			if (ench == Enchantments.LOYALTY)
				return true;
			if (ench == Enchantments.IMPALING)
				return true;
			if (ench == Enchantments.RIPTIDE)
				return true;
			if (ench == Enchantments.CHANNELING)
				return true;
			if (ench == Enchantments.MULTISHOT)
				return true;
			if (ench == Enchantments.QUICK_CHARGE)
				return true;
			if (ench == Enchantments.PIERCING)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			if (ench == Enchantments.SOUL_SPEED)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == Items.SHIELD)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
