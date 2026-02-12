package net.shackles_dev.tutorialbox.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;

public class ModSounds {
    public static final SoundEvent WAND_LIFE_USE = registerSoundEvent("wand_use");
    public static final SoundEvent WAND_DEATH_USE = registerSoundEvent("wand_use");

    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");
    public static final SoundEvent MAGIC_BLOCK_USE = registerSoundEvent("magic_block_use");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    public static final SoundEvent DREAMING_STARS = registerSoundEvent("dreaming_stars");
    public static final RegistryKey<JukeboxSong> DREAMING_STARS_KEY = RegistryKey.of(
            RegistryKeys.JUKEBOX_SONG ,Identifier.of(TutorialBox.MOD_ID, "dreaming_stars"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(TutorialBox.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModdedSounds() {
        TutorialBox.LOGGER.info("tuning sounds for " + TutorialBox.MOD_ID + '!');
    }
}
