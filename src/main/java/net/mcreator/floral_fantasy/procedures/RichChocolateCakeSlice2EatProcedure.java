package net.mcreator.floral_fantasy.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.floral_fantasy.block.RichChocolateCakeSlice3Block;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class RichChocolateCakeSlice2EatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure RichChocolateCakeSlice2Eat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure RichChocolateCakeSlice2Eat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure RichChocolateCakeSlice2Eat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure RichChocolateCakeSlice2Eat!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure RichChocolateCakeSlice2Eat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 1, (int) 0, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 6000, (int) 0));
		{
			BlockPos _bp = new BlockPos(x, y, z);
			BlockState _bs = RichChocolateCakeSlice3Block.block.getDefaultState();
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
