package caixukun.caixukun.cxk.entity.TSEnt;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;


public class ShibushirenEntity extends YoubinEntity {
    public ShibushirenEntity(World worldIn, LivingEntity throwerIn,float dam) {
        super(worldIn, throwerIn,dam);
    }
    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        Entity entity = result.getEntity();
        if(entity instanceof LivingEntity){
            float dam =((LivingEntity) entity).getMaxHealth();
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam*2);
        }

    }

}
