
package net.mcreator.floral_fantasy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.floral_fantasy.procedures.HydrangeaMuffinFoodEatenProcedure;
import net.mcreator.floral_fantasy.FloralFantasyModElements;

import java.util.Map;
import java.util.HashMap;

@FloralFantasyModElements.ModElement.Tag
public class HydrangeaMuffinItem extends FloralFantasyModElements.ModElement {
	@ObjectHolder("floral_fantasy:hydrangea_muffin")
	public static final Item block = null;
	public HydrangeaMuffinItem(FloralFantasyModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.5f).build()));
			setRegistryName("hydrangea_muffin");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				HydrangeaMuffinFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
