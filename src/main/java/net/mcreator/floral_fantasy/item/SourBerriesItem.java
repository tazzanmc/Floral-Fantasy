
package net.mcreator.floral_fantasy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.mcreator.floral_fantasy.FloralFantasyModElements;

@FloralFantasyModElements.ModElement.Tag
public class SourBerriesItem extends FloralFantasyModElements.ModElement {
	@ObjectHolder("floral_fantasy:sour_berries")
	public static final Item block = null;

	public SourBerriesItem(FloralFantasyModElements instance) {
		super(instance, 310);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.4f)

							.build()));
			setRegistryName("sour_berries");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 32;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}
	}
}
