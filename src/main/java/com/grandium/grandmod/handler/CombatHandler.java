package com.grandium.grandmod.handler;

import com.grandium.grandmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CombatHandler
{
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onLivingHurt(LivingHurtEvent event)
    {
        DamageSource source = event.getSource();

        if (!(source.getTrueSource() instanceof EntityPlayer))
        {
            return;
        }

        EntityPlayer player = (EntityPlayer) source.getTrueSource();
        ItemStack held = player.getHeldItemMainhand();

        if (held.isEmpty() || held.getItem() != ModItems.ANNIHILATOR_BLADE)
        {
            return;
        }

        if (event.getEntityLiving() instanceof EntityPlayer)
        {
            return;
        }

        float maxHealth = event.getEntityLiving().getMaxHealth();
        float halfHealth = Math.max(maxHealth * 0.5F, 1.0F);
        event.setAmount(halfHealth);
    }
}
