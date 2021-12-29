
package net.mcreator.floral_fantasy.item;

@FloralFantasyModElements.ModElement.Tag
public class VolatileEmberItem extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:volatile_ember")
	public static final Item block = null;

	public VolatileEmberItem(FloralFantasyModElements instance) {
		super(instance, 233);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(32).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("volatile_ember");
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
