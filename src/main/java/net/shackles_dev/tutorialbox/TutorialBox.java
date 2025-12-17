package net.shackles_dev.tutorialbox;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.component.ModDataComponentTypes;
import net.shackles_dev.tutorialbox.item.ModItemGroups;
import net.shackles_dev.tutorialbox.item.ModItems;
import net.shackles_dev.tutorialbox.util.HammerUsageEvent;
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

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}