package com.choccymilch.choccysmixmod.item;

import com.choccymilch.choccysmixmod.ChoccysMixMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChoccysMixMod.MOD_ID);

    public static final DeferredItem<Item> CHEESE = ITEMS.registerSimpleItem("cheese", new Item.Properties().food(new FoodProperties.Builder()
                    // Heals 3 hearts.
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .alwaysEdible().build()
            )
    );

    public static final DeferredItem<Item> CURD = ITEMS.registerItem("cheese_curd", Item::new, new Item.Properties());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
