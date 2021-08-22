package com.devlizard.tutorial;

import com.devlizard.tutorial.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* LESSON 0.0
* What is a class, OOP, constructor methods
* @Mod entry point
* Clean up class
* (public v private) (static v non) (final v non) Type name = value (MOD_ID)
* */
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "dltutorial";

    public TutorialMod() {
        RegistryHandler.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

//    LESSON 2
    public static final ItemGroup TAB = new ItemGroup("tutorialTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.PUMPKIN);
        }
    };

    public static class TabGroup extends ItemGroup {

        public TabGroup() {
            super("tutorialTab");
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.PUMPKIN);
        }
    }
}
