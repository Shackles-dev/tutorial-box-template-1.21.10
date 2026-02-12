package net.shackles_dev.tutorialbox;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.component.ModDataComponentTypes;
import net.shackles_dev.tutorialbox.effect.ModEffects;
import net.shackles_dev.tutorialbox.enchantment.ModEnchantmentEffects;
import net.shackles_dev.tutorialbox.enchantment.ModEnchantments;
import net.shackles_dev.tutorialbox.item.ModItemGroups;
import net.shackles_dev.tutorialbox.item.ModItems;
import net.shackles_dev.tutorialbox.potion.ModPotions;
import net.shackles_dev.tutorialbox.sound.ModSounds;
import net.shackles_dev.tutorialbox.util.HammerUsageEvent;
import net.shackles_dev.tutorialbox.util.VoidHammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialBox implements ModInitializer {
	public static final String MOD_ID = "tutorialbox";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModdedItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerComponentDataTypes();
		ModSounds.registerModdedSounds();
		ModEffects.registerModdedEffects();
		ModPotions.registerModdedPotions();
		ModEnchantmentEffects.registerModdedEnchantmentEffects();
		ModEnchantments.registerModdedEnchantments();

		FuelRegistry.INSTANCE.add(ModItems.URANIUM, 80000);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new VoidHammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, entityHitResult) -> {

			if(entity instanceof SheepEntity target && !world.isClient) {
				if(player.getMainHandStack().getItem() == ModItems.VOID_SWORD) {
					player.sendMessage(Text.literal("hello " + player.getName().getLiteralString() + "!"));
					target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 500, 1));
					player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 250, 0));
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.MUNDANE, Items.TOTEM_OF_UNDYING, ModPotions.TOTEM_POTION);
		});
	}
}