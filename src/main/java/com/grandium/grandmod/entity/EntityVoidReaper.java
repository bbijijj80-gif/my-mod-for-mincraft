package com.grandium.grandmod.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityVoidReaper extends EntityMob
{
    public EntityVoidReaper(World world)
    {
        super(world);
        this.setSize(1.2F, 3.5F);
        this.experienceValue = 100;
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.9D);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_WITHER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return SoundEvents.ENTITY_WITHER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_DEATH;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        // Уменьшаем урон от всех источников на 50% для сложности
        if (!source.isCreativePlayer())
        {
            amount *= 0.5F;
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void onDeath(DamageSource source)
    {
        super.onDeath(source);
        if (!this.world.isRemote)
        {
            // Эффект смерти - можно добавить спавн частиц или дроп
            this.world.setEntityState(this, (byte) 60);
        }
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        IEntityLivingData data = super.onInitialSpawn(difficulty, livingdata);
        
        // Даем боссу броню и оружие
        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(net.minecraft.init.Items.DIAMOND_HELMET));
        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(net.minecraft.init.Items.DIAMOND_CHESTPLATE));
        this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(net.minecraft.init.Items.DIAMOND_LEGGINGS));
        this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(net.minecraft.init.Items.DIAMOND_BOOTS));
        
        return data;
    }

    @Override
    public boolean canDespawn()
    {
        return false;
    }

    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
        return false;
    }
}
