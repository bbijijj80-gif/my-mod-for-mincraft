package com.grandium.grandmod.item;

import com.grandium.grandmod.entity.EntityVoidReaper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemReaperSummoner extends Item
{
    public ItemReaperSummoner()
    {
        this.setMaxStackSize(1);
        this.setMaxDamage(1); // Одноразовый предмет
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote)
        {
            // Призываем босса над игроком
            EntityVoidReaper boss = new EntityVoidReaper(world);
            
            // Позиционируем босса рядом с игроком
            double spawnX = player.posX;
            double spawnY = player.posY + 2.0D;
            double spawnZ = player.posZ;
            
            boss.setLocationAndAngles(spawnX, spawnY, spawnZ, player.rotationYaw, 0.0F);
            
            // Проверяем, что место свободно
            if (!world.collidesWithAnyBlock(boss.getEntityBoundingBox()))
            {
                world.spawnEntity(boss);
                
                // Убираем предмет призыва после использования
                if (!player.capabilities.isCreativeMode)
                {
                    stack.shrink(1);
                }
                
                // Воспроизводим звук призыва (опционально можно добавить кастомный)
                world.playSound(null, spawnX, spawnY, spawnZ, 
                    net.minecraft.init.SoundEvents.ENTITY_WITHER_SPAWN,
                    player.getSoundCategory(), 1.0F, 1.0F);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
