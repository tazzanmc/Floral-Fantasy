
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class BottleOfMolassesItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:bottle_of_molasses")
	public static final Item block = null;

	public BottleOfMolassesItem(FloralFantasyModElements instance) {
		super(instance, 279);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.6f).setAlwaysEdible()

							.build()));
			setRegistryName("bottle_of_molasses");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 40;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
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
