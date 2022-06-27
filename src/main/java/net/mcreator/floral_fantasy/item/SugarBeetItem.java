
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class SugarBeetItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:sugar_beet")
	public static final Item block = null;

	public SugarBeetItem(FloralFantasyModElements instance) {
		super(instance, 276);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(1.2f)

							.build()));
			setRegistryName("sugar_beet");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
