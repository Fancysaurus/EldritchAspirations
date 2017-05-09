package fancysaurus.eldritchAspirations.common;

import fancysaurus.eldritchAspirations.common.core.proxy.IProxy;
import fancysaurus.eldritchAspirations.common.lib.LibMisc;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by fancysaurus on 5/5/17.
 */

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME)

public class EldritchAspirations
{
    public static final String COMMON_PROXY = "fancysaurus.eldritchAspirations.common.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "fancysaurus.eldrithcAspirations.client.core.proxy.ClientProxy";

    @Mod.Instance(LibMisc.MOD_ID)
    public static EldritchAspirations instance;

    @SidedProxy(serverSide = COMMON_PROXY,clientSide = CLIENT_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }


}
