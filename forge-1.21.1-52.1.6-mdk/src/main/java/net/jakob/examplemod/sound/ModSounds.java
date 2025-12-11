package net.jakob.examplemod.sound;

import net.jakob.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

    public class ModSounds {
        public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
                DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ExampleMod.MODID);

        public static final RegistryObject<SoundEvent> LIGHTSABER_IGNITE =
                registerSoundEvent("lightsaber_ignite");

        public static final RegistryObject<SoundEvent> LIGHTSABER_CLOSE =
                registerSoundEvent("lightsaber_close");

        public static final RegistryObject<SoundEvent> LIGHTSABER_SWING =
                registerSoundEvent("lightsaber_swing");

        public static final RegistryObject<SoundEvent> LIGHTSABER_IDLE =
                registerSoundEvent("lightsaber_idle");


        public static final RegistryObject<SoundEvent> CANTINA = registerSoundEvent("cantina");
        public static final ResourceKey<JukeboxSong> CANTINA_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
                ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, "cantina"));

        private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
            return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, name)));
        }

        public static void register(IEventBus eventBus) {
            SOUND_EVENTS.register(eventBus);
        }
    }


















