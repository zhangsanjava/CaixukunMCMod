package caixukun.caixukun.cxk.effect;

import caixukun.caixukun.cxk.entity.IKunEntity;
import caixukun.caixukun.cxk.entity.KunChickenEntity;
import caixukun.caixukun.cxk.entity.TSEnt.LiziEntity;
import caixukun.caixukun.cxk.init.CXKEffectReg;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
@Mod.EventBusSubscriber
public class CXKEffect extends Effect {
    public CXKEffect() {
        super(EffectType.BENEFICIAL, 0);
    }

    @SubscribeEvent
    public static void onPlayerCriticalHit(CriticalHitEvent event) {
        Entity entity = event.getTarget();
        PlayerEntity player = event.getPlayer();
        if(!(entity instanceof IKunEntity)){
            float dengji = 0;
            Collection<EffectInstance> effects = ((LivingEntity) player).getActivePotionEffects();
            for(EffectInstance ef:effects){
                if(ef.getPotion()== CXKEffectReg.cxk.get()){
                    dengji=ef.getAmplifier()+1;
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player), (float) (15 * dengji));
                    break;
                }
            }
        }
    }
}
