package caixukun.caixukun.cxk.entity.TSEnt;

import caixukun.caixukun.cxk.entity.IKunEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class Renshengongji extends YoubinEntity{
    public Renshengongji(World worldIn, LivingEntity throwerIn, float dam) {
        super(worldIn, throwerIn, dam);
    }

    @Override
    public void onEntityHit(EntityRayTraceResult result) {
        Entity entity = result.getEntity();
        if (entity instanceof IKunEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam+20);
        }else {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), dam+5);
        }
    }

}
