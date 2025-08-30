package com.choccymilch.choccysmixmod.item;

import com.choccymilch.choccysmixmod.ChoccysMixMod;
import com.choccymilch.choccysmixmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChoccysMixMod.MOD_ID);

    // Food items creative mode tab
    public static final Supplier<CreativeModeTab> CHOCCYS_TREATS_TAB = CREATIVE_MODE_TAB.register("choccys_treats_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CARAMEL_APPLE.get()))
            .title(Component.translatable("creativetab.choccysmixmod.choccys_treats"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.CHEESE);
                output.accept((ItemLike) ModItems.CARAMEL);
                output.accept((ItemLike) ModItems.CARAMEL_APPLE);
                output.accept((ItemLike) ModItems.APPLE_PIE);
            }).build());

    // Blocks creative mode tab
    public static final Supplier<CreativeModeTab> CHOCCYS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("choccys_blocks_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CHEESE_BLOCK.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ChoccysMixMod.MOD_ID, "choccys_treats_tab"))
            .title(Component.translatable("creativetab.choccysmixmod.choccys_blocks"))
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.CHEESE_BLOCK);
                output.accept(ModBlocks.CHEDDARITE_BLOCK);
                output.accept(ModBlocks.CHEESIUM_BLOCK);
            }).build());

    // Choccy's Ingredients creative mode tab
    public static final Supplier<CreativeModeTab> CHOCCYS_INGREDIENTS_TAB = CREATIVE_MODE_TAB.register("choccys_ingredients_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CURD.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ChoccysMixMod.MOD_ID, "choccys_blocks_tab"))
            .title(Component.translatable("creativetab.choccysmixmod.choccys_ingredients"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.CURD);
                output.accept(ModItems.CHEDDARITE);
                output.accept(ModItems.CHEESIUM);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
