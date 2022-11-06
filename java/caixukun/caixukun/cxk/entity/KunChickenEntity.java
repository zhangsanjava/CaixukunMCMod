package caixukun.caixukun.cxk.entity;


import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.init.CXKItemReg;
import caixukun.caixukun.cxk.init.CXKSound;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.annotation.Nullable;


public class KunChickenEntity extends CreatureEntity implements IKunEntity{
    public KunChickenEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue = 0;
        setNoAI(false);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this,0.6F,false));
        this.goalSelector.addGoal(5, new SwimGoal(this));
        this.goalSelector.addGoal(2,new WaterAvoidingRandomWalkingGoal(this,0.4));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2,new HurtByTargetGoal(this).setCallsForHelp());

    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEFINED;
    }

    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {

        super.dropSpecialItems(source, looting, recentlyHitIn);
        this.entityDropItem(new ItemStack(CXKItemReg.kun.get()));
        this.entityDropItem(new ItemStack(CXKItemReg.LZ.get()),3);

    }





    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return CXKSound.kunkunji_shoushang1.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return CXKSound.kunkunji_shoushang1.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return CXKSound.kunkunji_daming1.get();
    }

    public static AttributeModifierMap.MutableAttribute bakeAttributes() {
        return MobEntity.func_233666_p_()
                //HEALTH
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                //SPEED
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                //ATTACK
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D)
                //FOLLOW RANGE
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 128.0D)
                //ARMOR
                .createMutableAttribute(Attributes.ARMOR, 0.5D);
    }
    @OnlyIn(Dist.CLIENT)
    public static class KunChickenR extends MobRenderer<KunChickenEntity,ChickenModel<KunChickenEntity>> {
        ResourceLocation resourceLocation =new ResourceLocation(Caixukun.ModID,"textures/entity/chicken1.png");
        public KunChickenR(EntityRendererManager renderManager) {
            super(renderManager,new ChickenModel<>(),0.3F);
        }
        public KunChickenR(EntityRendererManager renderManagerIn, ChickenModel entityModelIn, float shadowSizeIn) {
            super(renderManagerIn, entityModelIn, shadowSizeIn);
        }
        @Override
        public ResourceLocation getEntityTexture(KunChickenEntity entity) {
            return resourceLocation;
        }

    }

}



