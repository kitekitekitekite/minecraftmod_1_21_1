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

    public static final RegistryObject<Item> BLUE_LIGHTSABER_CRYSTAL = ITEMS.register("blue_lightsaber_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_LIGHTSABER_CRYSTAL = ITEMS.register("red_lightsaber_crystal", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
