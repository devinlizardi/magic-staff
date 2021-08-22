package com.devlizard.tutorial.items;

import com.devlizard.tutorial.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

/* LESSON 1.0
* Extends and super()
* LESSON 2.0 CHANGE
*   Item.Properties().group(ItemGroup.MATERIALS)
* */
public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties()
                .group(TutorialMod.TAB)
                .maxDamage(5)
        );
    }
}
