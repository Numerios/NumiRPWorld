package num.numirp.core.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import num.numirp.client.BlockLampRenderer;
import num.numirp.core.handlers.TickHandler;

public class ClientProxy extends CommonProxy {
    public static int blockLampRenderType;
    public static int renderPass;

    @Override
    public void initCapes() {
        TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
    }

    @Override
    public void initRendering() {
        blockLampRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockLampRenderer());
    }
}
