
package net.mcreator.floral_fantasy.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FloralFantasyModElements.ModElement.Tag
public class SiltBlock extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:silt")
	public static final Block block = null;

	public SiltBlock(FloralFantasyModElements instance) {
		super(instance, 177);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FallingBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.SAND).sound(SoundType.SAND).hardnessAndResistance(0.5f, 0.6f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.SHOVEL).setRequiresTool());

			setRegistryName("silt");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
