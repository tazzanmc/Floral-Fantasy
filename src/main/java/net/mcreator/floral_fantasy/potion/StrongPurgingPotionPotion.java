
package net.mcreator.floral_fantasy.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StrongPurgingPotionPotion {

	@ObjectHolder("floral_fantasy:strong_purging_potion")
	public static final Potion potionType = null;

	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		public PotionCustom() {
			super(new EffectInstance(PurgingPotionEffect.potion, 1200, 1, false, true));
			setRegistryName("strong_purging_potion");
		}

	}
}