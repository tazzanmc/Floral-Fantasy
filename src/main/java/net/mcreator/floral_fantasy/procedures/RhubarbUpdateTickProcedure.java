package net.mcreator.floral_fantasy.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.floral_fantasy.block.RhubarbStage3Block;
import net.mcreator.floral_fantasy.block.RhubarbStage2Block;
import net.mcreator.floral_fantasy.block.RhubarbStage1Block;
import net.mcreator.floral_fantasy.block.RhubarbStage0Block;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class RhubarbUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure RhubarbUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure RhubarbUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure RhubarbUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure RhubarbUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double randomGrowth = 0;
		if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.FARMLAND)) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage0Block.block
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage1Block.block
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage2Block.block) {
				world.destroyBlock(new BlockPos(x, y, z), false);
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage3Block.block) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z), false);
				}
			}
			world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.SAND
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.RED_SAND
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.GRAVEL
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.ANVIL
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CHIPPED_ANVIL
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.DAMAGED_ANVIL
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WHITE_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.ORANGE_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.MAGENTA_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.LIGHT_BLUE_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.YELLOW_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.LIME_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.PINK_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.GRAY_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.LIGHT_GRAY_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CYAN_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.PURPLE_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BLUE_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BROWN_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.GREEN_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.RED_CONCRETE_POWDER
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BLACK_CONCRETE_POWDER) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z)), (World) world, new BlockPos(x, y, z));
				world.destroyBlock(new BlockPos(x, y + 1, z), false);
			}
		} else if (!world.isRemote() && world.getLight(new BlockPos(x, y + 1, z)) > 7) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("ffGrowthTimer", (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(x, y, z), "ffGrowthTimer") + 1));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "ffGrowthTimer") >= 5) {
				if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage0Block.block) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = RhubarbStage1Block.block.getDefaultState();
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
				} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage1Block.block) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = RhubarbStage2Block.block.getDefaultState();
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
				} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RhubarbStage2Block.block) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = RhubarbStage3Block.block.getDefaultState();
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
