
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class ArgentEmberItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:argent_ember")
	public static final Item block = null;

	public ArgentEmberItem(FloralFantasyModElements instance) {
		super(instance, 184);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).isImmuneToFire().rarity(Rarity.UNCOMMON));
			setRegistryName("argent_ember");
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
