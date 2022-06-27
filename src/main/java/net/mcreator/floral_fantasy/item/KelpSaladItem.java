
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class KelpSaladItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:kelp_salad")
	public static final Item block = null;

	public KelpSaladItem(FloralFantasyModElements instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.COMMON).food((new Food.Builder()).hunger(5).saturation(6f)

					.build()));
			setRegistryName("kelp_salad");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 28;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
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
