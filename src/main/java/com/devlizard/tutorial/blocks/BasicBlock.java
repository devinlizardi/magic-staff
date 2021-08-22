package com.devlizard.tutorial.blocks;

import com.devlizard.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class BasicBlock extends Block {
    private static int MAX_STACK_SIZE = 20;
    public static Item.Properties basicProps = new Item.Properties()
                                                .maxStackSize(MAX_STACK_SIZE)
                                                .group(TutorialMod.TAB);

    public BasicBlock() {
        super(Block.Properties.create(Material.CLAY)
                .harvestLevel(0)
                .hardnessAndResistance(10f)
                .harvestTool(ToolType.PICKAXE));
    }

    // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
    // not strictly required because the default (super method) is MODEL.
    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }
}
