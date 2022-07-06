package net.mcreator.floral_fantasy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.floral_fantasy.item.SweetAnemonePieItem;
import net.mcreator.floral_fantasy.item.PoppyPastryItem;
import net.mcreator.floral_fantasy.item.HydrangeaMuffinItem;
import net.mcreator.floral_fantasy.item.DeathBloomPieItem;
import net.mcreator.floral_fantasy.item.DandyDandelionCrumbleItem;
import net.mcreator.floral_fantasy.item.CornflowerCakeItem;
import net.mcreator.floral_fantasy.FloralFantasyMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class TriggerBakeAllAdvancementProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
			Entity entity = event.getPlayer();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			ItemStack itemStack = event.getCrafting();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("itemstack", itemStack);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency entity for procedure TriggerBakeAllAdvancement!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FloralFantasyMod.LOGGER.warn("Failed to load dependency itemstack for procedure TriggerBakeAllAdvancement!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		boolean poppy_pastry_crafted = false;
		boolean sweet_anemone_pie_crafted = false;
		boolean deathbloom_pie_crafted = false;
		boolean cornflower_cake_crafted = false;
		boolean hydrangea_muffin_crafted = false;
		boolean dandy_dandelion_crumble_crafted = false;
		if (itemstack.getItem() == PoppyPastryItem.block) {
			poppy_pastry_crafted = (true);
		}
		if (itemstack.getItem() == SweetAnemonePieItem.block) {
			sweet_anemone_pie_crafted = (true);
		}
		if (itemstack.getItem() == DeathBloomPieItem.block) {
			deathbloom_pie_crafted = (true);
		}
		if (itemstack.getItem() == CornflowerCakeItem.block) {
			cornflower_cake_crafted = (true);
		}
		if (itemstack.getItem() == HydrangeaMuffinItem.block) {
			hydrangea_muffin_crafted = (true);
		}
		if (itemstack.getItem() == DandyDandelionCrumbleItem.block) {
			dandy_dandelion_crumble_crafted = (true);
		}
		if (poppy_pastry_crafted == true && hydrangea_muffin_crafted == true && sweet_anemone_pie_crafted == true
				&& dandy_dandelion_crumble_crafted == true && deathbloom_pie_crafted == true && cornflower_cake_crafted == true) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("floral_fantasy:all_pastries"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
