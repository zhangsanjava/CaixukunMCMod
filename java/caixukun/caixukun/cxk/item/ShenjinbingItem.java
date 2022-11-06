package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.entity.TSEnt.ShenjinbingEntity;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SnowballItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;


public class ShenjinbingItem extends SnowballItem {
    boolean fumo;
    public ShenjinbingItem(boolean fumo) {
        super(new Properties().group(CXKItemGroup.CXK_ITEM_GROUP).food(new Food.Builder().hunger(9).saturation(0.9F).build()).maxDamage(15));
        this.fumo=fumo;
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(handIn == Hand.MAIN_HAND) {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            //worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), CXKSound.shibushiyoubin.get(), SoundCategory.PLAYERS, 0.5F, 1F);
            ShenjinbingEntity ybe = new ShenjinbingEntity(worldIn, playerIn,15);
            ybe.setItem(itemstack);
            ybe.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.3F);
            worldIn.addEntity(ybe);
            playerIn.addStat(Stats.ITEM_USED.get(this));
            if (!fumo) {
                itemstack.damageItem(1,playerIn,(t)->itemstack.shrink(1));


            }
            return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
        }else {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            if (playerIn.canEat(this.getFood().canEatWhenFull())) {
                playerIn.setActiveHand(handIn);
                return ActionResult.resultConsume(itemstack);
            } else {
                return ActionResult.resultFail(itemstack);
            }
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION,250,1));
        entityLiving.addPotionEffect(new EffectInstance(Effects.RESISTANCE,250,1));
        if(!fumo) {
            stack.damageItem(2, entityLiving, (s) -> stack.shrink(1));
        }
        return stack;
    }

}
