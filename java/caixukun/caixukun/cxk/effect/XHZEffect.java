package caixukun.caixukun.cxk.effect;

import caixukun.caixukun.cxk.entity.IKunEntity;
import caixukun.caixukun.cxk.entity.KunChickenEntity;
import caixukun.caixukun.cxk.entity.LiziKunChickenEntity;
import caixukun.caixukun.cxk.init.CXKEffectReg;
import caixukun.caixukun.cxk.init.CXKItemReg;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
@Mod.EventBusSubscriber
public class XHZEffect extends Effect {
    public XHZEffect() {
        super(EffectType.BENEFICIAL, 0);
    }

        @SubscribeEvent
        public static void onPlayerCriticalHit(CriticalHitEvent event) {
            Entity entity = event.getTarget();
            PlayerEntity player = event.getPlayer();
            if(entity instanceof IKunEntity){
                float dengji = 0;
                boolean efff =false;
                Collection<EffectInstance> effects = ((LivingEntity) player).getActivePotionEffects();
                for(EffectInstance ef:effects){
                    if(ef.getPotion()== CXKEffectReg.xhz.get()){
                        efff =true;
                        dengji=ef.getAmplifier()+1;
                        break;
                    }
                }
                if(efff) {
                    entity.attackEntityFrom(DamageSource.causeMobDamage(player), (float) (20 *dengji));
                }
            }
        }
    }

