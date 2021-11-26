package com.devlizard.tutorial.blocks;

import com.devlizard.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;
import com.devlizard.tutorial.util.RegistryHandler;

import java.util.stream.Stream;

public class BasicBlock extends Block {
    private static int MAX_STACK_SIZE = 20;
    private static Item.Properties basicProps = new Item.Properties()
                                                .maxStackSize(MAX_STACK_SIZE)
                                                .group(TutorialMod.TAB);

    public BasicBlock() {
        super(Block.Properties.create(Material.CLAY)
                .harvestLevel(0)
                .hardnessAndResistance(10f)
                .harvestTool(ToolType.PICKAXE));
    }

    public static BlockItem buildItem() {
        return new BlockItem(RegistryHandler.BASIC_BLOCK.get(), basicProps);
    }

}
