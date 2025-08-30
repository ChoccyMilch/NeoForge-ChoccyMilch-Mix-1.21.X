package com.choccymilch.choccysmixmod.item;

import com.choccymilch.choccysmixmod.ChoccysMixMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

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

    public static final Supplier<Item> APPLE_PIE = ITEMS.registerItem("apple_pie", Item::new,
            new Item.Properties()
                    .rarity(Rarity.RARE)
                    .food
                            (new FoodProperties
                                    .Builder()
                                    .nutrition(8)
                                    .saturationModifier(0.8f)
                                    .alwaysEdible()
                                            .build()
                                    , Consumables.defaultFood()
                                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1000, 2), 1.0f)
                                    ).build()
                            )

    );

    public static final Supplier<Item> CARAMEL = ITEMS.registerItem("caramel", Item::new,
            new Item.Properties()
                    .rarity(Rarity.RARE)
                    .food
                            (new FoodProperties
                                            .Builder()
                                            .nutrition(2)
                                            .saturationModifier(0.2f)
                                            .alwaysEdible()
                                            .build()
                                    , Consumables.defaultFood()
                                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 200, 2), 1.0f)
                                            ).build()
                            )

    );

    public static final Supplier<Item> CARAMEL_APPLE = ITEMS.registerItem("caramel_apple", Item::new,
            new Item.Properties()
                    .rarity(Rarity.RARE)
                    .food
                            (new FoodProperties
                                            .Builder()
                                            .nutrition(6)
                                            .saturationModifier(0.6f)
                                            .alwaysEdible()
                                            .build()
                                    , Consumables.defaultFood()
                                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 500, 2), 1.0f)
                                            ).build()
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
