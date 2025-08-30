package com.choccymilch.choccysmixmod.block;

import com.choccymilch.choccysmixmod.ChoccysMixMod;
import com.choccymilch.choccysmixmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ChoccysMixMod.MOD_ID);

    public static final DeferredBlock<Block> CHEESE_BLOCK = registerBlock("cheese_block", properties -> new Block(properties),
            BlockBehaviour.Properties.of()
                    .strength(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SLIME_BLOCK));

    public static final DeferredBlock<Block> CHEESIUM_BLOCK = registerBlock("cheesium_block",properties -> new Block(properties),
            BlockBehaviour.Properties.of()
                    .strength(50.0f, 1200.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK));

    public static final DeferredBlock<Block> CHEDDARITE_BLOCK = registerBlock("cheddarite_block", properties -> new Block(properties),
            BlockBehaviour.Properties.of()
                    .strength(60.0f, 1400.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANCIENT_DEBRIS));

    public static final DeferredBlock<Block> CHEDDARITE_ORE = registerBlock("cheddarite_ore", properties -> new Block(properties),
            BlockBehaviour.Properties.of()
                    .strength(60.0f, 1400.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANCIENT_DEBRIS));

    // Helper method to actually register the block
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends T> blockFactory, BlockBehaviour.Properties blockProperties) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, blockFactory, blockProperties);
        registerBlockItem(name, block);
        return block;
    }
    // Generic
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
