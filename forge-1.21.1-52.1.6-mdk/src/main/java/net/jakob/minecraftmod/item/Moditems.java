package net.jakob.minecraftmod.item;

import net.jakob.minecraftmod.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> BLUELIGHTSABERCRYSTAL = ITEMS.register("blue lightsaber crystal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REDLIGHTSABERCRYSTAL = ITEMS.register("red lightsaber crystal", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
