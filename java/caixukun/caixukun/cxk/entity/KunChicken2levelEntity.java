package caixukun.caixukun.cxk.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class KunChicken2levelEntity extends KunChickenEntity{
    public KunChicken2levelEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute bakeAttributes() {
        return MobEntity.func_233666_p_()
                //HEALTH
                .createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
                //SPEED
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.6D)
                //ATTACK
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D)
                //FOLLOW RANGE
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 128.0D)
                //ARMOR
                .createMutableAttribute(Attributes.ARMOR, 2.0D);
    }

}
