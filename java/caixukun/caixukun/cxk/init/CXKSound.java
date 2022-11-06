package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class CXKSound {
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Caixukun.ModID);
        public static final RegistryObject<SoundEvent> shibushiyoubin = SOUNDS.register("shibushiyoubin", () -> new SoundEvent(new ResourceLocation(Caixukun.ModID, "youbin")));
        public static final RegistryObject<SoundEvent> lizi =SOUNDS.register("lizi",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"lizi")));
        public static final RegistryObject<SoundEvent> shibushiren =SOUNDS.register("shibushiren",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"sbsr")));
        public static final RegistryObject<SoundEvent> kunkunji_daming1 =SOUNDS.register("jijiao1",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"daming1")));
        public static final RegistryObject<SoundEvent> kunkunji_shoushang1 =SOUNDS.register("shoushang1",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"shoushang1")));
        public static final RegistryObject<SoundEvent> liziji_shoushang1 =SOUNDS.register("lizijishoushang1",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"lizientitysay")));
        public static final RegistryObject<SoundEvent> liziji_dead =SOUNDS.register("lizijidead",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"lizientitydead")));
        public static final RegistryObject<SoundEvent> niganma =SOUNDS.register("ngm",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"ngm")));
        //public static final RegistryObject<SoundEvent> kaituan =SOUNDS.register("kt",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"kt")));
        public static final RegistryObject<SoundEvent> xhz =SOUNDS.register("xhz",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"xhz")));
        public static final RegistryObject<SoundEvent> jntm =SOUNDS.register("jntm",()->new SoundEvent(new ResourceLocation(Caixukun.ModID,"jinitaimei")));


}
