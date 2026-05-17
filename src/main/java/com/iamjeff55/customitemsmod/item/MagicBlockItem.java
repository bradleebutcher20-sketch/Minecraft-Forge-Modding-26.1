package com.iamjeff55.CustomItemsMod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay; // Ensure this import
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer; // Ensure this import

public class MagicBlockItem extends BlockItem {

    public MagicBlockItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(
            final ItemStack itemStack,
            final Item.TooltipContext context,
            final TooltipDisplay display,
            final Consumer<Component> builder,
            final TooltipFlag tooltipFlag
    ) {
        // Add your custom tooltip line
        builder.accept(Component.translatable("tooltip.customitemsmod.magic_block.tooltip"));

        // Call super with all 5 arguments
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
