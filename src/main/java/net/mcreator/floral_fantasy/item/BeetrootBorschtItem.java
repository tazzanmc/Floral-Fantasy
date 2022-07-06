
package net.mcreator.floral_fantasy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.floral_fantasy.FloralFantasyModElements;

@FloralFantasyModElements.ModElement.Tag
public class BeetrootBorschtItem extends FloralFantasyModElements.ModElement {
	@ObjectHolder("floral_fantasy:beetroot_borscht")
	public static final Item block = null;

	public BeetrootBorschtItem(FloralFantasyModElements instance) {
		super(instance, 304);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(8.4f)

							.build()));
			setRegistryName("beetroot_borscht");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 36;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.BOWL);
			super.onItemUseFinish(itemstack, world, entity);
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
