
package net.mcreator.floral_fantasy.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LongPurgingPotionPotion {

	@ObjectHolder("floral_fantasy:long_purging_potion")
	public static final Potion potionType = null;

	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		public PotionCustom() {
			super(new EffectInstance(PurgingPotionEffect.potion, 3600, 0, false, true));
			setRegistryName("long_purging_potion");
		}

	}
}