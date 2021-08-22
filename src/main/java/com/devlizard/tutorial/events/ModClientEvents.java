package com.devlizard.tutorial.events;

import com.devlizard.tutorial.TutorialMod;
import com.devlizard.tutorial.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onStaffUse(PlayerInteractEvent.LeftClickBlock event) {
        PlayerEntity player = event.getPlayer();
        World world = event.getWorld();

        if (player.getHeldItemMainhand().getItem() == RegistryHandler.STAFF.get()) {
            LightningBoltEntity bolt = new LightningBoltEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), false);
            TNTEntity tnt = new TNTEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), player);
            world.addEntity(bolt);
            world.addEntity(tnt);

            // player.sendMessage();
            for (int i = 0; i < 10; i++) {
                int r = (int) Math.round(Math.floor(Math.random() * 3));
                Block randomBlock = getRandomBlock(r);
                world.setBlockState(event.getPos().add(0, i, 0), randomBlock.getDefaultState());
            }
        }
    }

    private static Block getRandomBlock(int i) {
        Block b;
        switch (i) {
            case 0:
                b = Blocks.TNT;
                break;
            case 1:
                b = Blocks.ACACIA_LOG;
                break;
            default:
                b = Blocks.SPRUCE_PLANKS;
        }
        return b;
    }
}
