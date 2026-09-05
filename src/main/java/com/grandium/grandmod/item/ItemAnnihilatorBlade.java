package com.grandium.grandmod.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemAnnihilatorBlade extends ItemSword
{
    public static final Item.ToolMaterial GRANDIUM = EnumHelper.addToolMaterial(
            "GRANDIUM",
            4,
            5000,
            12.0F,
            8.0F,
            25
    );

    public ItemAnnihilatorBlade()
    {
        super(GRANDIUM);
        setMaxStackSize(1);
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot)
    {
        Multimap<String, AttributeModifier> attributes = super.getItemAttributeModifiers(slot);

        if (slot == EntityEquipmentSlot.MAINHAND)
        {
            attributes.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
            attributes.put(
                    SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(
                            ATTACK_DAMAGE_MODIFIER,
                            "Weapon modifier",
                            12.0D,
                            0
                    )
            );
            attributes.put(
                    SharedMonsterAttributes.ATTACK_SPEED.getName(),
                    new AttributeModifier(
                            ATTACK_SPEED_MODIFIER,
                            "Weapon modifier",
                            -1.8D,
                            0
                    )
            );
        }

        return attributes;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return false;
    }
}
