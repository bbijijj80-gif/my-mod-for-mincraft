package com.grandium.grandmod;

import com.grandium.grandmod.init.ModItems;
import com.grandium.grandmod.init.ModRecipes;
import com.grandium.grandmod.handler.CombatHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
        MinecraftForge.EVENT_BUS.register(new CombatHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();
        logger.info("Grandium Legends loaded — forge the Annihilator Blade!");
    }
}
