
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class PyreticCompositeItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:pyretic_composite")
	public static final Item block = null;

	public PyreticCompositeItem(FloralFantasyModElements instance) {
		super(instance, 230);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("pyretic_composite");
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
