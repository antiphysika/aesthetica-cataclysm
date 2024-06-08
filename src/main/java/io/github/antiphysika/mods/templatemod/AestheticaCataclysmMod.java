/*
 * SPDX-License-Identifier: Apache-2.0
 */

package io.github.antiphysika.mods.aesthetica.cataclysm;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AestheticaCataclysmMod.MOD_ID)
public class AestheticaCataclysmMod
{
  public static final String MOD_ID = "aesthetica_cataclysm";

  public static final String MOD_MAIN_CLASS = "AestheticaCataclysmMod";
  public static final String MOD_CLIENT_CLASS = String.format("%s.%s", MOD_MAIN_CLASS, "ClientModEvents");

  public static final Logger LOGGER = LogUtils.getLogger();

  public AestheticaCataclysmMod ()
  {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    modEventBus.addListener(this::commonSetup);

    MinecraftForge.EVENT_BUS.register(this);
    modEventBus.addListener(this::addCreative);
  }

  private void commonSetup (final FMLCommonSetupEvent event)
  {
    LOGGER.info(String.format("In %s.commonSetup()", MOD_MAIN_CLASS));
  }

  private void addCreative (BuildCreativeModeTabContentsEvent event)
  {
    LOGGER.info(String.format("In %s.addCreative()", MOD_MAIN_CLASS));
  }

  @SubscribeEvent
  public void onServerStarting (ServerStartingEvent event)
  {
    LOGGER.info(String.format("In %s.onServerStarting()", MOD_MAIN_CLASS));
  }

  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents
  {
    @SubscribeEvent
    public static void onClientSetup (FMLClientSetupEvent event)
    {
      LOGGER.info(String.format("In %s.onClientSetup()", MOD_CLIENT_CLASS));
    }
  }
}

/*
 * vim: ts=2 sw=2 et fdm=marker :
 */
