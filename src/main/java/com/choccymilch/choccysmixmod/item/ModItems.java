package com.choccymilch.choccysmixmod.item;

import com.choccymilch.choccysmixmod.ChoccysMixMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChoccysMixMod.MOD_ID);

    // Food items
    public static final DeferredItem<Item> CHEESE = ITEMS.registerSimpleItem("cheese", new Item.Properties().food(new FoodProperties.Builder()
                    // Heals 3 hearts.
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .alwaysEdible().build()
            )
    );

    public static final DeferredItem<Item> APPLE_PIE = ITEMS.registerSimpleItem("apple_pie", new Item.Properties().food(new FoodProperties.Builder()
                    // Heals 3 hearts.
                    .nutrition(6)
                    .saturationModifier(0.6f)
                    .alwaysEdible().build()
            )
    );

    // Crafting/Ingredient items
    public static final DeferredItem<Item> CURD = ITEMS.registerItem("cheese_curd", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHEESIUM = ITEMS.registerItem("cheesium", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHEDDARITE = ITEMS.registerItem("cheddarite", Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
