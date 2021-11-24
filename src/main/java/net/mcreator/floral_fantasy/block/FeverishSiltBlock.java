
package net.mcreator.floral_fantasy.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FloralFantasyModElements.ModElement.Tag
public class FeverishSiltBlock extends FloralFantasyModElements.ModElement {

	@ObjectHolder("floral_fantasy:feverish_silt")
	public static final Block block = null;

	public FeverishSiltBlock(FloralFantasyModElements instance) {
		super(instance, 178);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FallingBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.SAND).sound(SoundType.SAND).hardnessAndResistance(0.45f, 0.6000000000000001f).setLightLevel(s -> 1)
					.harvestLevel(0).harvestTool(ToolType.SHOVEL).setRequiresTool().setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));

			setRegistryName("feverish_silt");
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
