package caixukun.caixukun.cxk.entity;

import caixukun.caixukun.Caixukun;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;

public class ChickenRenEntity extends KunChickenEntity implements IKunEntity, IAngerable {
    public ChickenRenEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false,this::func_233680_b_));
        this.goalSelector.addGoal(3, new SwimGoal(this));




        //this.goalSelector.addGoal(1, new MeleeAttackGoal(this,0.6F,false));

        this.goalSelector.addGoal(2,new WaterAvoidingRandomWalkingGoal(this,0.4));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        //this.targetSelector.addGoal(2,new HurtByTargetGoal(this).setCallsForHelp());
    }
    public static AttributeModifierMap.MutableAttribute bakeAttributes() {
        return MobEntity.func_233666_p_()
                //HEALTH
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                //SPEED
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                //ATTACK
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D)
                //FOLLOW RANGE
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 128.0D)
                //ARMOR
                .createMutableAttribute(Attributes.ARMOR, 4.0D);
    }

    @Override
    public int getAngerTime() {
        return 114514;
    }

    @Override
    public void setAngerTime(int time) {

    }

    @Nullable
    @Override
    public UUID getAngerTarget() {
        return null;
    }

    @Override
    public void setAngerTarget(@Nullable UUID target) {

    }

    @Override
    public void func_230258_H__() {

    }

    @OnlyIn(Dist.CLIENT)
    public static class KunChickenR extends MobRenderer<ChickenRenEntity, PlayerModel<ChickenRenEntity>> {
        ResourceLocation resourceLocation =new ResourceLocation(Caixukun.ModID,"textures/entity/lizijiren.png");
        public KunChickenR(EntityRendererManager renderManager) {
            super(renderManager,new PlayerModel<>(1,true),0.3F);
        }
        public KunChickenR(EntityRendererManager renderManagerIn, PlayerModel entityModelIn, float shadowSizeIn) {
            super(renderManagerIn, entityModelIn, shadowSizeIn);
        }
        @Override
        public ResourceLocation getEntityTexture(ChickenRenEntity entity) {
            return resourceLocation;
        }

    }
}
