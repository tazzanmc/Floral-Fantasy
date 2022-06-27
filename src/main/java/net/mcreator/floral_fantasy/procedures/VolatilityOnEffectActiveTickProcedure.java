package net.mcreator.floral_fantasy.procedures;

public class VolatilityOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure VolatilityOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure VolatilityOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure VolatilityOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure VolatilityOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure VolatilityOnEffectActiveTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((Math.random() < (((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == VolatilityPotionEffect.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(entity)) + 1) * 0.01))) {
			if ((Math.random() <= 0.5)) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((((entity.getPosX()) + Math.random()) + 0.25), (((entity.getPosY()) + Math.random()) + 0.25),
							(((entity.getPosZ()) + Math.random()) + 0.25));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((((entity.getPosX()) + Math.random()) + 0.25),
								(((entity.getPosY()) + Math.random()) + 0.25), (((entity.getPosZ()) + Math.random()) + 0.25), _ent.rotationYaw,
								_ent.rotationPitch, Collections.emptySet());
					}
				}
			} else {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((((entity.getPosX()) - Math.random()) - 0.25), (((entity.getPosY()) - Math.random()) + 0.25),
							(((entity.getPosZ()) - Math.random()) - 0.25));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((((entity.getPosX()) - Math.random()) - 0.25),
								(((entity.getPosY()) - Math.random()) + 0.25), (((entity.getPosZ()) - Math.random()) - 0.25), _ent.rotationYaw,
								_ent.rotationPitch, Collections.emptySet());
					}
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
						SoundCategory.PLAYERS, (float) 0.5, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
						SoundCategory.PLAYERS, (float) 0.5, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 15, 0.5, 0.5, 0.5, 0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.DRAGON_BREATH, x, y, z, (int) 5, 0.5, 0.5, 0.5, 0);
			}
		}
	}

}
