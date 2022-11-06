package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.effect.CXKEffect;
import caixukun.caixukun.cxk.effect.XHZEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CXKEffectReg {
    public static final DeferredRegister<Effect> EFFECTS =DeferredRegister.create(ForgeRegistries.POTIONS, Caixukun.ModID);
    public static final RegistryObject<Effect> xhz =EFFECTS.register("xiaoheizi", XHZEffect::new);
    public static final RegistryObject<Effect> cxk =EFFECTS.register("caixukun", CXKEffect::new);
}
