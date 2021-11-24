
package net.mcreator.floral_fantasy.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurgingPotionPotion {

	@ObjectHolder("floral_fantasy:purging_potion")
	public static final Potion potionType = null;

	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		public PotionCustom() {
			super(new EffectInstance(PurgingPotionEffect.potion, 2400, 0, false, true));
			setRegistryName("purging_potion");
		}

	}
}