package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.entity.TSEnt.LshEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class LvshihanItem extends SnowballItem {
    boolean fumo;
    public LvshihanItem(boolean fumo) {
        super(new Properties().group(CXKItemGroup.CXK_ITEM_GROUP));
        this.fumo =fumo;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            LshEntity lsh = new LshEntity(worldIn,playerIn,0);
            lsh.setItem(itemstack);
            lsh.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(lsh);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!fumo) {
            itemstack.shrink(1);
        }

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}
