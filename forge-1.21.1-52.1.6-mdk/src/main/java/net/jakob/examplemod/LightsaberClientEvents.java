package net.jakob.examplemod;

import net.jakob.examplemod.sound.ModSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LightsaberClientEvents {

    private static int idleTimer = 0;
    private static final int HUM_INTERVAL = 5;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        ItemStack stack = mc.player.getMainHandItem();
        boolean holdingSaber = stack.getItem() instanceof LightsaberItem;

        if (!holdingSaber) {
            idleTimer = 0; // reset when not holding a lightsaber
            return;
        }

        idleTimer++;
        if (idleTimer >= HUM_INTERVAL) {
            idleTimer = 0;

            mc.level.playLocalSound(
                    mc.player.getX(), mc.player.getY(), mc.player.getZ(),
                    ModSounds.LIGHTSABER_IDLE.get(),
                    SoundSource.PLAYERS,
                    0.8F,
                    1.0F,
                    false
            );
        }
    }
}
