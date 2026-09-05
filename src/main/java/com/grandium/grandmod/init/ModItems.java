package com.grandium.grandmod.init;

import com.grandium.grandmod.GrandiumMod;
import com.grandium.grandmod.item.ItemAnnihilatorBlade;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = GrandiumMod.MODID)
public class ModItems
{
    public static Item PRIMAL_DUST;
    public static Item VOID_SHARD;
    public static Item GRANDIUM_INGOT;
    public static Item GRANDIUM_CORE;
    public static Item ANNIHILATOR_BLADE;

    public static void init()
    {
        PRIMAL_DUST = new Item()
                .setRegistryName("primal_dust")
                .setUnlocalizedName("primal_dust")
                .setCreativeTab(ModCreativeTab.TAB);

        VOID_SHARD = new Item()
                .setRegistryName("void_shard")
                .setUnlocalizedName("void_shard")
                .setCreativeTab(ModCreativeTab.TAB);

        GRANDIUM_INGOT = new Item()
                .setRegistryName("grandium_ingot")
                .setUnlocalizedName("grandium_ingot")
                .setCreativeTab(ModCreativeTab.TAB);

        GRANDIUM_CORE = new Item()
                .setRegistryName("grandium_core")
                .setUnlocalizedName("grandium_core")
                .setCreativeTab(ModCreativeTab.TAB);

        ANNIHILATOR_BLADE = new ItemAnnihilatorBlade()
                .setRegistryName("annihilator_blade")
                .setUnlocalizedName("annihilator_blade")
                .setCreativeTab(ModCreativeTab.TAB);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(PRIMAL_DUST);
        registry.register(VOID_SHARD);
        registry.register(GRANDIUM_INGOT);
        registry.register(GRANDIUM_CORE);
        registry.register(ANNIHILATOR_BLADE);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(RegistryEvent.Register<Item> event)
    {
        registerModel(PRIMAL_DUST);
        registerModel(VOID_SHARD);
        registerModel(GRANDIUM_INGOT);
        registerModel(GRANDIUM_CORE);
        registerModel(ANNIHILATOR_BLADE);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }

    public static ItemStack stack(Item item, int count)
    {
        return new ItemStack(item, count);
    }
}
