package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;

public class WaderRightClickedOnEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency world for procedure WaderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency x for procedure WaderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency y for procedure WaderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency z for procedure WaderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure WaderRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WaderRightClickedOnEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (!(entity.getPersistentData().getBoolean("fed") == true)
				&& (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Blocks.CRIMSON_FUNGUS.asItem()
						|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == Blocks.CRIMSON_FUNGUS.asItem())) {
			entity.getPersistentData().putBoolean("fed", (true));
			if ((entity instanceof TameableEntity) && (sourceentity instanceof PlayerEntity)) {
				((TameableEntity) entity).setTamed(true);
				((TameableEntity) entity).setTamedBy((PlayerEntity) sourceentity);
			}
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Blocks.CRIMSON_FUNGUS);
				((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) sourceentity).container.func_234641_j_());
			}
			if (sourceentity instanceof LivingEntity) {
				((LivingEntity) sourceentity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.eat")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.eat")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, (y + 1), z, (int) 10, 0.35, 0.35, 0.35, 1);
			}
		}
	}
}
