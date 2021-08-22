package com.devlizard.tutorial.util;

import com.devlizard.tutorial.TutorialMod;
import com.devlizard.tutorial.items.ItemBase;
import com.devlizard.tutorial.items.Mushyroom;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/* LESSON 0.1
* DeferredRegister as data structure
* Insert RegistryObjects to DeferredRegister
*   This means it can be accessed around the mod
* */
public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);


    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        //BLOCKS.register(modEventBus);
    }

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> STAFF = ITEMS.register("staff", ItemBase::new);
    public static final RegistryObject<Item> MUSHYROOM = ITEMS.register("mushyroom", Mushyroom::new);

}
