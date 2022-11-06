package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.entity.TSEnt.ShibushirenEntity;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;



public class shibushiren extends SnowballItem {
    boolean fumo;
    public shibushiren(boolean fumo) {
        super(new Properties().group(CXKItemGroup.CXK_ITEM_GROUP));
        this.fumo =fumo;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), CXKSound.shibushiren.get(), SoundCategory.PLAYERS, 0.5F, 1F);
        if (!worldIn.isRemote) {
            ShibushirenEntity snowballentity = new ShibushirenEntity(worldIn, playerIn,0);
            snowballentity.setItem(itemstack);
            snowballentity.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(snowballentity);
            if(!fumo) {
                itemstack.shrink(1);
            }
    }
        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getEntityWorld().playSound((PlayerEntity) attacker,attacker.getPosX(),attacker.getPosY(),attacker.getPosZ(),CXKSound.shibushiren.get(),SoundCategory.PLAYERS,1F,1F);
        //world.playSound((PlayerEntity) attacker,attacker.getPosX(),attacker.getPosY(),attacker.getPosZ(),CXKSound.shibushiren.get(),SoundCategory.PLAYERS,1F,1F);
        float dam =target.getMaxHealth();
        target.attackEntityFrom(DamageSource.MAGIC, (float) (dam*2.5));

        /*
        attacker.getEntityWorld().playSound((PlayerEntity) attacker, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), CXKSound.shibushiren.get(), SoundCategory.PLAYERS, 0.5F, 1F);
        attacker.playSound(CXKSound.shibushiren.get(),0.5F,1);

         */
        if(!fumo) {
            stack.shrink(1);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
