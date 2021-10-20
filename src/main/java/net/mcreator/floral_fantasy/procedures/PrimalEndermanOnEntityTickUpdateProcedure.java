package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;
import java.util.Collections;

public class PrimalEndermanOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure PrimalEndermanOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure PrimalEndermanOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure PrimalEndermanOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure PrimalEndermanOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure PrimalEndermanOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 1, 0.5, 1, 0.5, 1);
		}
		if ((Math.random() < 0.0005)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 25, 0.5, 1, 0.5, 1);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
								SoundCategory.HOSTILE, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
						SoundCategory.HOSTILE, (float) 1, (float) 1, false);
			}
			if ((5 >= (Math.random() * 10))) {
				if ((5 >= (Math.random() * 10))) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x + (Math.random() * 10)), y, (z + (Math.random() * 10)));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + (Math.random() * 10)), y, (z + (Math.random() * 10)),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				} else {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x + (Math.random() * 10)), y, (z - (Math.random() * 10)));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + (Math.random() * 10)), y, (z - (Math.random() * 10)),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				}
			} else {
				if ((5 >= (Math.random() * 10))) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x - (Math.random() * 10)), y, (z + (Math.random() * 10)));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - (Math.random() * 10)), y, (z + (Math.random() * 10)),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				} else {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((x - (Math.random() * 10)), y, (z - (Math.random() * 10)));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - (Math.random() * 10)), y, (z - (Math.random() * 10)),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 25, 0.5, 1, 0.5, 1);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
								SoundCategory.HOSTILE, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("ambient.basalt_deltas.additions")),
						SoundCategory.HOSTILE, (float) 1, (float) 1, false);
			}
		}
		if ((entity.isInWaterRainOrBubbleColumn())) {
			entity.attackEntityFrom(DamageSource.DROWN, (float) 1);
		}
	}
}
