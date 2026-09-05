package com.grandium.grandmod.init;

import com.grandium.grandmod.GrandiumMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTab extends CreativeTabs
{
    public static final ModCreativeTab TAB = new ModCreativeTab();

    private ModCreativeTab()
    {
        super(GrandiumMod.MODID);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.ANNIHILATOR_BLADE);
    }
}
