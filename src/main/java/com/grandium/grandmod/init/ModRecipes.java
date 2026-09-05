package com.grandium.grandmod.init;

import com.grandium.grandmod.GrandiumMod;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addShapedRecipe(
                new ResourceLocation(GrandiumMod.MODID, "primal_dust"),
                new ResourceLocation(GrandiumMod.MODID, "primal_dust"),
                new ItemStack(ModItems.PRIMAL_DUST, 2),
                "DEG",
                "LRR",
                "GQD",
                'D', Items.DIAMOND,
                'E', Items.EMERALD,
                'G', Items.GOLD_INGOT,
                'L', new ItemStack(Items.DYE, 1, 4),
                'R', Items.REDSTONE,
                'Q', Items.QUARTZ
        );

        GameRegistry.addShapedRecipe(
                new ResourceLocation(GrandiumMod.MODID, "void_shard"),
                new ResourceLocation(GrandiumMod.MODID, "void_shard"),
                new ItemStack(ModItems.VOID_SHARD, 1),
                "PBP",
                "ENE",
                "PGP",
                'P', ModItems.PRIMAL_DUST,
                'B', Items.BLAZE_ROD,
                'E', Items.ENDER_PEARL,
                'N', Items.NETHER_STAR,
                'G', Items.GHAST_TEAR
        );

        GameRegistry.addShapedRecipe(
                new ResourceLocation(GrandiumMod.MODID, "grandium_core"),
                new ResourceLocation(GrandiumMod.MODID, "grandium_core"),
                new ItemStack(ModItems.GRANDIUM_CORE, 1),
                "INI",
                "DVS",
                "ITI",
                'I', ModItems.GRANDIUM_INGOT,
                'N', Items.NETHER_STAR,
                'D', Items.DRAGON_BREATH,
                'V', ModItems.VOID_SHARD,
                'S', Items.DRAGON_BREATH,
                'T', Items.TOTEM_OF_UNDYING
        );

        GameRegistry.addShapedRecipe(
                new ResourceLocation(GrandiumMod.MODID, "annihilator_blade"),
                new ResourceLocation(GrandiumMod.MODID, "annihilator_blade"),
                new ItemStack(ModItems.ANNIHILATOR_BLADE, 1),
                " C ",
                "III",
                " S ",
                'C', ModItems.GRANDIUM_CORE,
                'I', ModItems.GRANDIUM_INGOT,
                'S', Items.STICK
        );

        GameRegistry.addSmelting(
                ModItems.VOID_SHARD,
                new ItemStack(ModItems.GRANDIUM_INGOT),
                2.0F
        );
    }
}
