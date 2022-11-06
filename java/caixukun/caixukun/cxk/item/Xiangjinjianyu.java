package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.entity.TSEnt.XiangjinjianyuEntity;
import caixukun.caixukun.cxk.init.CXKItemReg;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;


public class Xiangjinjianyu extends Item {
    boolean fumo=false;
    public Xiangjinjianyu(boolean fumo) {
        super(new Properties().food(new Food.Builder().hunger(8).saturation(0.9F).build()).group(CXKItemGroup.CXK_ITEM_GROUP));
        this.fumo =fumo;
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(handIn == Hand.MAIN_HAND) {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            //worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("yiliaoxiang:youbin"))), SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            XiangjinjianyuEntity ybe = new XiangjinjianyuEntity(worldIn, playerIn,15);
            ybe.setItem(itemstack);
            ybe.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.5F);
            worldIn.addEntity(ybe);
            playerIn.addStat(Stats.ITEM_USED.get(this));
            if (!fumo) {
                itemstack.shrink(1);
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
        if(fumo){
            entityLiving.onFoodEaten(worldIn,new ItemStack(CXKItemReg.XJJY.get()));
            return stack;
        }else {
            return super.onItemUseFinish(stack, worldIn, entityLiving);
        }
    }
}
