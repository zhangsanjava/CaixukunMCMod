package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class CXKEntityReg {
    public static final DeferredRegister<EntityType<?>> ENTITY =DeferredRegister.create(ForgeRegistries.ENTITIES, Caixukun.ModID);
    public static final RegistryObject<EntityType<KunChickenEntity>> KUNJI = ENTITY.register("kunchicken", ()->EntityType.Builder.create(KunChickenEntity::new, EntityClassification.MONSTER).size(0.4F,0.7F).build("kunchicken"));
    public static final RegistryObject<EntityType<KunChicken2levelEntity>> kunji2 =ENTITY.register("kunchickenlv2",()->EntityType.Builder.create(KunChicken2levelEntity::new,EntityClassification.MONSTER).size(0.4F,0.7F).build("kunchickenlv2"));
    public static final RegistryObject<EntityType<LiziKunChickenEntity>> lizikunji =ENTITY.register("lizikunchicken",()->EntityType.Builder.create(LiziKunChickenEntity::new,EntityClassification.MONSTER).size(0.4F,0.7F).build("lizikunchicken"));
    public static final RegistryObject<EntityType<ChickenRenEntity>> lkunrne =ENTITY.register("lizikunjiren",()->EntityType.Builder.create(ChickenRenEntity::new,EntityClassification.MONSTER).size(0.6F,1.95F).build("lizikunren"));
    public static final RegistryObject<EntityType<NCChickenRenEntity>> nkunren =ENTITY.register("nckunjiren",()->EntityType.Builder.create(NCChickenRenEntity::new,EntityClassification.MONSTER).size(0.6F,1.95F).build("nckunren"));
    //public static final RegistryObject<EntityType<CxkEntity.CustomEntity>> test =ENTITY.register("test",()->EntityType.Builder.create(CxkEntity.CustomEntity::new))
    //public static final RegistryObject<EntityType<FlyingSwordEntity>> flyingSwordEntity = ENTITY.register("flying_sword", () -> EntityType.Builder.create(FlyingSwordEntity::new, EntityClassification.MISC).size(3, 0.5F).build("flying_sword"));

}
