package caixukun.caixukun.cxk.entity.event;

import caixukun.caixukun.cxk.entity.ChickenRenEntity;
import caixukun.caixukun.cxk.entity.KunChickenEntity;
import caixukun.caixukun.cxk.entity.LiziKunChickenEntity;
import caixukun.caixukun.cxk.entity.NCChickenRenEntity;
import caixukun.caixukun.cxk.init.CXKEntityReg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            EntityRendererManager erm = mc.getRenderManager();
            erm.register(CXKEntityReg.KUNJI.get(), new KunChickenEntity.KunChickenR(erm));
            erm.register(CXKEntityReg.kunji2.get(), new KunChickenEntity.KunChickenR(erm));
            erm.register(CXKEntityReg.lizikunji.get(),new LiziKunChickenEntity.LiziKunChickenR(erm));
            erm.register(CXKEntityReg.lkunrne.get(),new ChickenRenEntity.KunChickenR(erm));
            erm.register(CXKEntityReg.nkunren.get(),new NCChickenRenEntity.KunChickenR(erm));
        });

    }
}
