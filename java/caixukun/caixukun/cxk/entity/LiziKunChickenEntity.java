package caixukun.caixukun.cxk.entity;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.client.gui.fonts.TexturedGlyph;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class LiziKunChickenEntity extends KunChickenEntity implements IKunEntity{
    public LiziKunChickenEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }
    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return CXKSound.lizi.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return CXKSound.liziji_dead.get();
    }
    public static AttributeModifierMap.MutableAttribute bakeAttributes() {
        return MobEntity.func_233666_p_()
                //HEALTH
                .createMutableAttribute(Attributes.MAX_HEALTH, 35.0D)
                //SPEED
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                //ATTACK
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
                //FOLLOW RANGE
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 128.0D)
                //ARMOR
                .createMutableAttribute(Attributes.ARMOR, 2.0D);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return CXKSound.liziji_shoushang1.get();
    }
    @OnlyIn(Dist.CLIENT)
    public static class LiziKunChickenR extends MobRenderer<KunChickenEntity, ChickenModel<KunChickenEntity>> {
        ResourceLocation resourceLocation =new ResourceLocation(Caixukun.ModID,"textures/entity/lizichicken.png");
        public LiziKunChickenR(EntityRendererManager renderManager) {
            super(renderManager,new ChickenModel<>(),0.3F);
        }
        public LiziKunChickenR(EntityRendererManager renderManagerIn, ChickenModel entityModelIn, float shadowSizeIn) {
            super(renderManagerIn, entityModelIn, shadowSizeIn);
        }
        @Override
        public ResourceLocation getEntityTexture(KunChickenEntity entity) {
            return resourceLocation;
        }

    }


    @Mod.EventBusSubscriber
    public static class GlobalTrigger {
        @SubscribeEvent
        public static void onPlayerCriticalHit(CriticalHitEvent event) {
            Entity entity = event.getTarget();
            PlayerEntity player = event.getPlayer();
            double x = player.getPosX();
            double y = player.getPosY();
            double z = player.getPosZ();
            World world = player.world;
            if(entity instanceof LiziKunChickenEntity){
                ((LivingEntity) player).addPotionEffect(new EffectInstance(Effects.WEAKNESS,200,1));
                world.playSound(player,x,y,z, CXKSound.lizi.get(), SoundCategory.PLAYERS,1F,1F);
            }

        }

    }
}
