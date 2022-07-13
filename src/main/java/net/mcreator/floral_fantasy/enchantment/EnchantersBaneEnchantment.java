
package net.mcreator.floral_fantasy.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.floral_fantasy.FloralFantasyModElements;

@FloralFantasyModElements.ModElement.Tag
public class EnchantersBaneEnchantment extends FloralFantasyModElements.ModElement {
	@ObjectHolder("floral_fantasy:enchanters_bane")
	public static final Enchantment enchantment = null;

	public EnchantersBaneEnchantment(FloralFantasyModElements instance) {
		super(instance, 318);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("enchanters_bane"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.FIRE_PROTECTION)
				return true;
			if (ench == Enchantments.BLAST_PROTECTION)
				return true;
			if (ench == Enchantments.PROJECTILE_PROTECTION)
				return true;
			if (ench == Enchantments.THORNS)
				return true;
			if (ench == Enchantments.FROST_WALKER)
				return true;
			if (ench == Enchantments.BINDING_CURSE)
				return true;
			if (ench == Enchantments.SMITE)
				return true;
			if (ench == Enchantments.BANE_OF_ARTHROPODS)
				return true;
			if (ench == Enchantments.KNOCKBACK)
				return true;
			if (ench == Enchantments.SWEEPING)
				return true;
			if (ench == Enchantments.EFFICIENCY)
				return true;
			if (ench == Enchantments.UNBREAKING)
				return true;
			if (ench == Enchantments.PUNCH)
				return true;
			if (ench == Enchantments.FLAME)
				return true;
			if (ench == Enchantments.LUCK_OF_THE_SEA)
				return true;
			if (ench == Enchantments.LURE)
				return true;
			if (ench == Enchantments.LOYALTY)
				return true;
			if (ench == Enchantments.IMPALING)
				return true;
			if (ench == Enchantments.MULTISHOT)
				return true;
			if (ench == Enchantments.PIERCING)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			if (ench == ShatteringCurseEnchantment.enchantment)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return true;
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
			return false;
		}
	}
}
