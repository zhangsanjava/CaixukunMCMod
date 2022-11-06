package caixukun.caixukun.cxk.entity;

import caixukun.caixukun.Caixukun;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NCChickenRenEntity extends KunChickenEntity implements IKunEntity{
    public NCChickenRenEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
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
    @OnlyIn(Dist.CLIENT)
    public static class KunChickenR extends MobRenderer<NCChickenRenEntity, PlayerModel<NCChickenRenEntity>> {
        ResourceLocation resourceLocation =new ResourceLocation(Caixukun.ModID,"textures/entity/ncjiren.png");
        public KunChickenR(EntityRendererManager renderManager) {
            super(renderManager,new PlayerModel<>(1,true),0.3F);
        }
        public KunChickenR(EntityRendererManager renderManagerIn, PlayerModel entityModelIn, float shadowSizeIn) {
            super(renderManagerIn, entityModelIn, shadowSizeIn);
        }
        @Override
        public ResourceLocation getEntityTexture(NCChickenRenEntity entity) {
            return resourceLocation;
        }

    }
}
