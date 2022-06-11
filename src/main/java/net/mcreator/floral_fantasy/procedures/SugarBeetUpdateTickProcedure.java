package net.mcreator.floral_fantasy.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.floral_fantasy.block.SugarBeetStage3Block;
import net.mcreator.floral_fantasy.block.SugarBeetStage2Block;
import net.mcreator.floral_fantasy.block.SugarBeetStage1Block;
import net.mcreator.floral_fantasy.block.SugarBeetStage0Block;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class SugarBeetUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure SugarBeetUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure SugarBeetUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure SugarBeetUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure SugarBeetUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomGrowth = 0;
		if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.FARMLAND))) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage0Block.block)
					|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage1Block.block)
							|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage2Block.block)))) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage3Block.block)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
							new BlockPos((int) x, (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		} else if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.SAND)
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.RED_SAND))
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRAVEL) || ((((world
						.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.ANVIL)
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CHIPPED_ANVIL)
								|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.DAMAGED_ANVIL)))
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WHITE_CONCRETE_POWDER)
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.ORANGE_CONCRETE_POWDER)
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
												.getBlock() == Blocks.MAGENTA_CONCRETE_POWDER)
												|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
														.getBlock() == Blocks.LIGHT_BLUE_CONCRETE_POWDER)
														|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																.getBlock() == Blocks.YELLOW_CONCRETE_POWDER)
																|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																		.getBlock() == Blocks.LIME_CONCRETE_POWDER)
																		|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																				.getBlock() == Blocks.PINK_CONCRETE_POWDER)
																				|| (((world
																						.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																								.getBlock() == Blocks.GRAY_CONCRETE_POWDER)
																						|| (((world.getBlockState(
																								new BlockPos((int) x, (int) (y + 1), (int) z)))
																										.getBlock() == Blocks.LIGHT_GRAY_CONCRETE_POWDER)
																								|| (((world.getBlockState(new BlockPos((int) x,
																										(int) (y + 1), (int) z)))
																												.getBlock() == Blocks.CYAN_CONCRETE_POWDER)
																										|| (((world.getBlockState(new BlockPos(
																												(int) x, (int) (y + 1), (int) z)))
																														.getBlock() == Blocks.PURPLE_CONCRETE_POWDER)
																												|| (((world.getBlockState(
																														new BlockPos((int) x,
																																(int) (y + 1),
																																(int) z)))
																																		.getBlock() == Blocks.BLUE_CONCRETE_POWDER)
																														|| (((world.getBlockState(
																																new BlockPos((int) x,
																																		(int) (y + 1),
																																		(int) z)))
																																				.getBlock() == Blocks.BROWN_CONCRETE_POWDER)
																																|| (((world
																																		.getBlockState(
																																				new BlockPos(
																																						(int) x,
																																						(int) (y + 1),
																																						(int) z)))
																																								.getBlock() == Blocks.GREEN_CONCRETE_POWDER)
																																		|| (((world
																																				.getBlockState(
																																						new BlockPos(
																																								(int) x,
																																								(int) (y + 1),
																																								(int) z)))
																																										.getBlock() == Blocks.RED_CONCRETE_POWDER)
																																				|| ((world
																																						.getBlockState(
																																								new BlockPos(
																																										(int) x,
																																										(int) (y + 1),
																																										(int) z)))
																																												.getBlock() == Blocks.BLACK_CONCRETE_POWDER)))))))))))))))))))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
			}
		} else if (((!(world.isRemote())) && ((world.getLight(new BlockPos((int) x, (int) (y + 1), (int) z))) > 7))) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("ffGrowthTimer", ((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ffGrowthTimer")) + 1));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ffGrowthTimer")) >= 5)) {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage0Block.block)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = SugarBeetStage1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage1Block.block)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = SugarBeetStage2Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SugarBeetStage2Block.block)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = SugarBeetStage3Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
				}
			}
		}
	}
}
