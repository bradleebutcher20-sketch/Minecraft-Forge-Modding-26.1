package com.iamjeff55.CustomItemsMod.item;

import com.iamjeff55.CustomItemsMod.CustomItemsMod;
import com.iamjeff55.CustomItemsMod.block.MagicBlock;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

import static com.iamjeff55.CustomItemsMod.CustomItemsMod.MODID;

public class ModItems {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Limestone Block
    public static final RegistryObject<Block> LIMESTONE_BLOCK = BLOCKS.register("limestone_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("limestone_block"))
                    .strength(3f, 4f)
                    .mapColor(MapColor.STONE)
            )
    );

    public static final RegistryObject<Item> LIMESTONE_BLOCK_ITEM = ITEMS.register("limestone_block",
            () -> new BlockItem(LIMESTONE_BLOCK.get(), new Item.Properties()
                    .setId(ITEMS.key("limestone_block"))
            ));

    // Magic Block
    public static final RegistryObject<Block> MAGIC_BLOCK = BLOCKS.register("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("magic_block"))
                    .strength(3f)
                    .lightLevel(state -> 10)
            ));


    public static final RegistryObject<Item> MAGIC_BLOCK_ITEM = ITEMS.register("magic_block",
            () -> new BlockItem(MAGIC_BLOCK.get(), new Item.Properties()
                    .setId(ITEMS.key("magic_block"))
                    .stacksTo(1)
            ));

    // Limestone Ore
    public static final RegistryObject<Block> LIMESTONE_ORE = BLOCKS.register("limestone_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("limestone_ore"))
                    .strength(3f, 4f)
                    .mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Item> LIMESTONE_ORE_ITEM = ITEMS.register("limestone_ore",
            () -> new BlockItem(LIMESTONE_ORE.get(), new Item.Properties().setId(ITEMS.key("limestone_ore")))
    );

    // Lapis relation
    public static final RegistryObject<Item> LAPIS_SWORD = ITEMS.register("lapis_sword",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("lapis_sword"))
                    .durability(750)
                    .sword(
                            ToolMaterial.IRON,
                            2,
                            4f
                    )
            )
    );

    public static final TagKey<Item> LAPIS_REPAIR_TAG = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("customitemsmod", "lapis")
    );

    public static final TagKey<Block> INCORRECT_FOR_LAPIS_TOOL = TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath("customitemsmod", "incorrect_for_lapis_tool")
    );

    public static final ToolMaterial CUSTOM_TOOL_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_LAPIS_TOOL, // It uses your custom "blocked list"
            1500, 8.0F, 3.0F, 15,
            LAPIS_REPAIR_TAG
    );

    // 4. Item Registration
    public static final RegistryObject<Item> LAPIS_PICKAXE = ITEMS.register("lapis_pickaxe",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("lapis_pickaxe"))
                    .pickaxe(CUSTOM_TOOL_MATERIAL, 1.0F, -2.8F)
            )
    );

    // Limestone
    public static final RegistryObject<Item> LIMESTONE = ITEMS.register("limestone",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("limestone"))
            )
    );

    // Chisel
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .setId(ITEMS.key("chisel"))
                    .durability(32)
            )
    );

    // Fuel Item
    public static final RegistryObject<Item> BARK = ITEMS.register("bark",
            () -> new FuelItem(
                    new Item.Properties().setId(ITEMS.key("bark")), // Link the ID here
                    250
            ));

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new HammerItem(
                    new Item.Properties()
                            .setId(ITEMS.key("hammer"))
                            .durability(2048)
            )
    );

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2) // Amount of hunger restored (1 = half a shank)
                            .alwaysEdible()
                            .saturationModifier(0.3F) // Saturation modifier
                            .build())
                    .setId(ITEMS.key("blueberry"))
            ));

    public static final ModArmorMaterials.CustomArmorMaterial LAPIS_MATERIAL =
            ModArmorMaterials.register(
                    "lapis_armor_material",
                    Map.of(
                            ArmorType.HELMET, 3,
                            ArmorType.CHESTPLATE, 8,
                            ArmorType.LEGGINGS, 6,
                            ArmorType.BOOTS, 3
                    ),
                    15,                     // enchantability
                    500,                    // durability
                    2.0f,                   // toughness
                    0.1f,                   // knockback resistance
                    SoundEvents.ARMOR_EQUIP_NETHERITE, // equip sound
                    Items.DIAMOND           // repair item
            );

    public static final RegistryObject<Item> LAPIS_HELMET = ITEMS.register("lapis_helmet",
            () -> new CustomArmorItem(
                    LAPIS_MATERIAL,   // use your custom material
                    ArmorType.HELMET,
                    new Item.Properties()
                            .setId(ITEMS.key("lapis_helmet"))
                            .durability(LAPIS_MATERIAL.durability)
                            .enchantable(LAPIS_MATERIAL.enchantability)
            ));

    public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate",
            () -> new CustomArmorItem(
                    LAPIS_MATERIAL,
                    ArmorType.CHESTPLATE,
                    new Item.Properties()
                            .setId(ITEMS.key("lapis_chestplate"))
                            .durability(LAPIS_MATERIAL.durability)
                            .enchantable(LAPIS_MATERIAL.enchantability)
            ));

    public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",
            () -> new CustomArmorItem(
                    LAPIS_MATERIAL,
                    ArmorType.LEGGINGS,
                    new Item.Properties()
                            .setId(ITEMS.key("lapis_leggings"))
                            .durability(LAPIS_MATERIAL.durability)
                            .enchantable(LAPIS_MATERIAL.enchantability)
            ));

    public static final RegistryObject<Item> LAPIS_BOOTS = ITEMS.register("lapis_boots",
            () -> new CustomArmorItem(
                    LAPIS_MATERIAL,
                    ArmorType.BOOTS,
                    new Item.Properties()
                            .setId(ITEMS.key("lapis_boots"))
                            .durability(LAPIS_MATERIAL.durability)
                            .enchantable(LAPIS_MATERIAL.enchantability)
            ));

    public static final RegistryObject<Item> LAPIS_HORSE_ARMOR =
            ITEMS.register("lapis_horse_armor", () ->
                    new Item(
                            new Item.Properties()
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.ITEM,
                                                    Identifier.fromNamespaceAndPath(
                                                            CustomItemsMod.MODID,
                                                            "lapis_horse_armor"
                                                    )
                                            )
                                    )
                                    .stacksTo(1) // Horse armor only stacks to 1
                                    // 1. Ties into the "Armor" and "Enchantable" tag filters
                                    .enchantable(15) // Uses standard Diamond/Iron armor enchantability value
                                    // 2. Tells the game how/where it can be worn and rendered
                                    .component(
                                            DataComponents.EQUIPPABLE,
                                            Equippable.builder(EquipmentSlot.BODY)
                                                    .setAsset(
                                                            ResourceKey.create(
                                                                    EquipmentAssets.ROOT_ID,
                                                                    Identifier.fromNamespaceAndPath(
                                                                            CustomItemsMod.MODID,
                                                                            "lapis_horse_armor"
                                                                    )
                                                            )
                                                    )
                                                    .setEquipSound(SoundEvents.HORSE_ARMOR) // Sound on equip
                                                    .setAllowedEntities(EntityType.HORSE) // Restricts it exclusively to horses
                                                    .build()
                                    )
                                    // 3. Grants the actual protection points (Armor attributes)
                                    .attributes(
                                            ItemAttributeModifiers.builder()
                                                    .add(
                                                            Attributes.ARMOR,
                                                            new AttributeModifier(
                                                                    Identifier.fromNamespaceAndPath(CustomItemsMod.MODID, "armor_points"),
                                                                    7.0, // 7.0 is equivalent to Iron Horse Armor (Diamond is 11.0)
                                                                    AttributeModifier.Operation.ADD_VALUE
                                                            ),
                                                            EquipmentSlotGroup.BODY
                                                    )
                                                    .build()
                                    )
                    ));
}
