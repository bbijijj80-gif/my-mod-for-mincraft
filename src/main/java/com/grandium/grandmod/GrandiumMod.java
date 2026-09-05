package com.grandium.grandmod;

import com.grandium.grandmod.init.ModItems;
import com.grandium.grandmod.init.ModRecipes;
import com.grandium.grandmod.handler.CombatHandler;
import com.grandium.grandmod.entity.EntityVoidReaper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = GrandiumMod.MODID,
        name = GrandiumMod.NAME,
        version = GrandiumMod.VERSION,
        acceptedMinecraftVersions = "[1.12.2]"
)
public class GrandiumMod
{
    public static final String MODID = "grandium";
    public static final String NAME = "Grandium Legends";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ModItems.init();
        
        // Регистрируем сущность босса
        EntityRegistry.registerModEntity(
                EntityVoidReaper.class,
                "void_reaper",
                "grandium:void_reaper",
                1,
                this,
                80,
                3,
                true,
                0x1a1a2e,
                0x4a0e4e
        );
        
        MinecraftForge.EVENT_BUS.register(new CombatHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();
        logger.info("Grandium Legends loaded — forge the Annihilator Blade!");
    }
}
