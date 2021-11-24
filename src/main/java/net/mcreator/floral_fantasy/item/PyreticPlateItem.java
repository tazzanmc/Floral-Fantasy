
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class PyreticPlateItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:pyretic_plate")
	public static final Item block = null;

	public PyreticPlateItem(FloralFantasyModElements instance) {
		super(instance, 187);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("pyretic_plate");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
