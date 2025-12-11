package net.jakob.examplemod.block;

import net.jakob.examplemod.ExampleMod;
import net.jakob.examplemod.item.Moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> TATOOINE_BUILDING_BLOCK = registerBlock("tatooine_building_block",
            () -> new Block(BlockBehaviour.Properties.of()
            ));

    public static final RegistryObject<Block>  TATOOINE_DOOR_CONTROLLER = registerBlock("tatooine_door_controller",
            () -> new Block(BlockBehaviour.Properties.of()
            ));


   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
       RegistryObject<T> toReturn = BLOCKS.register(name, block);
       registerBlockItem(name, toReturn);
       return toReturn;
   }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));


    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
