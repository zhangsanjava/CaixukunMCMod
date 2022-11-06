package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.init.CXKEffectReg;
import caixukun.caixukun.cxk.init.CXKItemReg;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class jntmDiscItem extends MusicDiscItem {
    int ticks =0;
    public jntmDiscItem() {
        super(15, CXKSound.jntm, new Properties().group(CXKItemGroup.CXK_ITEM_GROUP).maxDamage(10));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack =playerIn.getHeldItem(handIn);
        /*
        ItemStack stack1 =new ItemStack(CXKItemReg.kun.get());
        playerIn.inventory.func_234564_a_(stack2 -> stack1.getItem()==stack2.getItem(),3,playerIn.container.func_234641_j_());
         */


        //playerIn.getCooldownTracker().setCooldown(this, 20000);
        if(this.ticks==0){
            worldIn.playSound(playerIn,playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ(),CXKSound.jntm.get(), SoundCategory.AMBIENT,1,1);
            playerIn.addPotionEffect(new EffectInstance(CXKEffectReg.cxk.get(),4380,0));
            this.ticks = 8760;
            playerIn.getCooldownTracker().setCooldown(CXKItemReg.kaituandic.get(), 4380);
            stack.damageItem(1,playerIn,(l)->stack.shrink(1));
        }else {
            ServerLifecycleHooks.getCurrentServer().getPlayerList().func_232641_a_(new StringTextComponent("冷却中"), ChatType.SYSTEM, Util.DUMMY_UUID);
        }
        return ActionResult.resultConsume(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(ticks !=0){
            System.out.println("1145145"+ticks);
            this.ticks =ticks -1;
            System.out.println("sb250"+ticks);
        }
    }
}
