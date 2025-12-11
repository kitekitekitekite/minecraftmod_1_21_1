package net.jakob.examplemod;

import net.jakob.examplemod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;

import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LightsaberEvents {

    // IGNITE + CLOSE when switching items
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getSlot() != EquipmentSlot.MAINHAND) return;

        ItemStack from = event.getFrom();
        ItemStack to   = event.getTo();

        boolean fromIsSaber = from.getItem() instanceof LightsaberItem;
        boolean toIsSaber   = to.getItem() instanceof LightsaberItem;

        Level level = player.level();
        if (level.isClientSide) return; // run this on SERVER

        // Ignite: non-saber -> saber
        if (!fromIsSaber && toIsSaber) {
            level.playSound(
                    null, // null = everyone nearby hears it
                    player.getX(), player.getY(), player.getZ(),
                    ModSounds.LIGHTSABER_IGNITE.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }

        // Close: saber -> non-saber
        if (fromIsSaber && !toIsSaber) {
            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    ModSounds.LIGHTSABER_CLOSE.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }
    }

    // STRIKE sound when you hit an entity
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();

        if (!(stack.getItem() instanceof LightsaberItem)) return;

        Level level = player.level();
        if (level.isClientSide) return; // also server-side here

        level.playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                ModSounds.LIGHTSABER_SWING.get(),
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );
    }

    // SWING IN AIR sound (client-only event)
    @SubscribeEvent
    public static void onLeftClickEmpty(PlayerInteractEvent.LeftClickEmpty event) {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();

        if (!(stack.getItem() instanceof LightsaberItem)) return;

        Level level = player.level();
        // LeftClickEmpty is client-side, so we use playLocalSound
        level.playLocalSound(
                player.getX(), player.getY(), player.getZ(),
                ModSounds.LIGHTSABER_SWING.get(),
                SoundSource.PLAYERS,
                1.0F,
                1.0F,
                false
        );
    }
}