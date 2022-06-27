
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class UnripeSourBerriesItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:unripe_sour_berries")
	public static final Item block = null;

	public UnripeSourBerriesItem(FloralFantasyModElements instance) {
		super(instance, 257);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.2f)

							.build()));
			setRegistryName("unripe_sour_berries");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 24;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
