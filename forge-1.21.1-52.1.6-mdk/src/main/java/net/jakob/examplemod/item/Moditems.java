package net.jakob.examplemod.item;

import net.jakob.examplemod.ExampleMod;
import net.jakob.examplemod.LightsaberItem;
import net.jakob.examplemod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> BLUE_LIGHTSABER_CRYSTAL = ITEMS.register("blue_lightsaber_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_LIGHTSABER_CRYSTAL = ITEMS.register("red_lightsaber_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CANTINA_MUSIC_DISC = ITEMS.register("cantina_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.CANTINA_KEY).stacksTo(1)));

    public static final RegistryObject<Item> BLUE_LIGHTSABER =
            ITEMS.register("blue_lightsaber", () ->
                    new LightsaberItem(
                            Tiers.NETHERITE,
                            new Item.Properties().attributes(
                                    SwordItem.createAttributes(Tiers.NETHERITE, 20, -2.4F)
                            )
                    )
            );

    public static final RegistryObject<Item> RED_LIGHTSABER =
            ITEMS.register("red_lightsaber", () ->
                    new LightsaberItem(
                            Tiers.NETHERITE,
                            new Item.Properties().attributes(
                                    SwordItem.createAttributes(Tiers.NETHERITE, 20, -2.4F)
                            )
                    )
            );





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}

