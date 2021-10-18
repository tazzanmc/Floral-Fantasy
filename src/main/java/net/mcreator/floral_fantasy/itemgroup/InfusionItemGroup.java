
package net.mcreator.floral_fantasy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.floral_fantasy.item.InfusionBottleItem;
import net.mcreator.floral_fantasy.FloralFantasyModElements;

@FloralFantasyModElements.ModElement.Tag
public class InfusionItemGroup extends FloralFantasyModElements.ModElement {
	public InfusionItemGroup(FloralFantasyModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabinfusion") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(InfusionBottleItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
