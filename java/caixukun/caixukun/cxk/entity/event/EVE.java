package caixukun.caixukun.cxk.entity.event;

import caixukun.caixukun.cxk.entity.*;
import caixukun.caixukun.cxk.init.CXKEntityReg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EVE {
    @SubscribeEvent
    public static void setupAttributes(EntityAttributeCreationEvent eace) {
        eace.put(CXKEntityReg.KUNJI.get(), KunChickenEntity.bakeAttributes().create());
        eace.put(CXKEntityReg.kunji2.get(), KunChicken2levelEntity.bakeAttributes().create());
        eace.put(CXKEntityReg.lizikunji.get(), LiziKunChickenEntity.bakeAttributes().create());
        eace.put(CXKEntityReg.lkunrne.get(), ChickenRenEntity.bakeAttributes().create());
        eace.put(CXKEntityReg.nkunren.get(), NCChickenRenEntity.bakeAttributes().create());

    }
}
