package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.state.Property;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.floral_fantasy.item.UnripeSourBerriesItem;
import net.mcreator.floral_fantasy.item.SourBerriesItem;
import net.mcreator.floral_fantasy.block.SourBerryBushStage4Block;
import net.mcreator.floral_fantasy.block.SourBerryBushStage3Block;
import net.mcreator.floral_fantasy.block.SourBerryBushStage1Block;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class SourBerryBushStage3OnBlockRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure SourBerryBushStage3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure SourBerryBushStage3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure SourBerryBushStage3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure SourBerryBushStage3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure SourBerryBushStage3OnBlockRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double randomNumber = 0;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SourBerryBushStage4Block.block) {
			if (!world.isRemote()) {
				randomNumber = Math.random();
				if (randomNumber >= 0.66) {
					for (int index0 = 0; index0 < (int) (3); index0++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
									new ItemStack(SourBerriesItem.block));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
				} else if (randomNumber >= 0.33) {
					for (int index1 = 0; index1 < (int) (2); index1++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
									new ItemStack(SourBerriesItem.block));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
								new ItemStack(SourBerriesItem.block));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world)
							.playSound(null, new BlockPos(x, y, z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
									SoundCategory.BLOCKS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
							SoundCategory.BLOCKS, (float) 1, (float) 1, false);
				}
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = SourBerryBushStage1Block.block.getDefaultState();
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
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SourBerryBushStage3Block.block) {
			if (randomNumber >= 0.66) {
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
								new ItemStack(UnripeSourBerriesItem.block));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			} else if (randomNumber >= 0.33) {
				for (int index3 = 0; index3 < (int) (2); index3++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
								new ItemStack(UnripeSourBerriesItem.block));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.05), (y + 0.05), (z + 0.05),
							new ItemStack(UnripeSourBerriesItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
						SoundCategory.BLOCKS, (float) 1, (float) 1, false);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = SourBerryBushStage1Block.block.getDefaultState();
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
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
	}
}
