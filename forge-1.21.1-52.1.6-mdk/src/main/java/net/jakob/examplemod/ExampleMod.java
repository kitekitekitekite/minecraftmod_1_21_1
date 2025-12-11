package net.jakob.examplemod;

import com.mojang.logging.LogUtils;
import net.jakob.examplemod.block.ModBlocks;
import net.jakob.examplemod.item.Moditems;
import net.jakob.examplemod.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



@Mod(ExampleMod.MODID)
public class ExampleMod {


    public static final String MODID = "examplemod";


    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();


        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);





        // setup + creative tabs
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);


        MinecraftForge.EVENT_BUS.register(this);

        // config
        Object Config;
        context.registerConfig(ModConfig.Type.COMMON, net.jakob.examplemod.Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Put items into creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Ingredients
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Moditems.BLUE_LIGHTSABER_CRYSTAL);
            event.accept(Moditems.RED_LIGHTSABER_CRYSTAL);
        }

        //  Tools & Utilities
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(Moditems.CANTINA_MUSIC_DISC);
        }

        // Combat
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(Moditems.BLUE_LIGHTSABER);
            event.accept(Moditems.RED_LIGHTSABER);
        }

        // Blocks
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TATOOINE_BUILDING_BLOCK);
            event.accept(ModBlocks.TATOOINE_DOOR_CONTROLLER);
        }
    }
}
