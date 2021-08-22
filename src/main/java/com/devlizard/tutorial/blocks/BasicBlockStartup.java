package com.devlizard.tutorial.blocks;

import com.devlizard.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BasicBlockStartup {
    public static BasicBlock basicBlock;
    public static BlockItem basicBlockItem;

    @SubscribeEvent
    public static void onBlockRegistration(final RegistryEvent.Register<Block> blockRegister) {
        basicBlock = (BasicBlock) new BasicBlock().setRegistryName(TutorialMod.MOD_ID,"basic_block");
        blockRegister.getRegistry().register(basicBlock);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegister) {
        final int MAX_STACK_SIZE = 20;
        Item.Properties basicProps = new Item.Properties().maxStackSize(MAX_STACK_SIZE).group(TutorialMod.TAB);

        basicBlockItem = new BlockItem(basicBlock, basicProps);
        basicBlockItem.setRegistryName(basicBlock.getRegistryName());
        itemRegister.getRegistry().register(basicBlockItem);
    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(basicBlock, RenderType.getSolid());
    }
}
