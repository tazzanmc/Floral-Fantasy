package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;

import net.mcreator.floral_fantasy.particle.AnemonePetalsParticle;
import net.mcreator.floral_fantasy.block.RichDirtBlock;
import net.mcreator.floral_fantasy.block.GrandAnemoneFlowerBlock;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class AnemoneFlowerUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure AnemoneFlowerUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure AnemoneFlowerUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure AnemoneFlowerUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure AnemoneFlowerUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double baseRate = 0;
		double rateWithAmplifier = 0;
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RichDirtBlock.block) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(AnemonePetalsParticle.particle, (x + 0.5), (y + 0.5), (z + 0.5), (int) 1, 0.25, 0.25, 0.25, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(AnemonePetalsParticle.particle, (x + 0.5), (y + 0.5), (z + 0.5), (int) 15, 1, 1, 1, 1);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")),
						SoundCategory.BLOCKS, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.grow")),
						SoundCategory.BLOCKS, (float) 0.5, (float) 1, false);
			}
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = GrandAnemoneFlowerBlock.block.getDefaultState();
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
