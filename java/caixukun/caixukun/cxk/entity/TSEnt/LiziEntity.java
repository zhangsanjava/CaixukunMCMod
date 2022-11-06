package caixukun.caixukun.cxk.entity.TSEnt;

import caixukun.caixukun.cxk.entity.IKunEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class LiziEntity extends YoubinEntity {
    float dam;
    public LiziEntity(World worldIn, LivingEntity throwerIn,float dam) {
        super(worldIn, throwerIn,dam);
        this.dam =dam;
    }
    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        Entity entity = result.getEntity();
        if (entity instanceof IKunEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam+5);
        }else {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam+5);
        }
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, 400, 1));
        }

    }
}
