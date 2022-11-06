package caixukun.caixukun.cxk.entity.TSEnt;

import caixukun.caixukun.cxk.entity.IKunEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class YoubinEntity extends SnowballEntity {
    float dam =0;

    public YoubinEntity(World worldIn, LivingEntity throwerIn,float dam) {
        super(worldIn, throwerIn);
        this.dam =dam;
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        Entity entity = result.getEntity();
        if (entity instanceof IKunEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam+7);
        }else {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam);
        }
    }
}
