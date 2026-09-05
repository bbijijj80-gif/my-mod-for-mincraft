package com.grandium.grandmod.init;

import com.grandium.grandmod.GrandiumMod;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
    public static void init()
    {
        // Рецепты теперь регистрируются через JSON файлы в assets/grandium/recipes/
        // Это позволяет игре автоматически отображать их в книге рецептов без необходимости получения книги достижений
        
        // Оставляем только плавку, так как она не может быть зарегистрирована через JSON для Forge 1.12.2
        GameRegistry.addSmelting(
                ModItems.VOID_SHARD,
                new ItemStack(ModItems.GRANDIUM_INGOT),
                2.0F
        );
    }
}
