package caixukun.caixukun.cxk.item;

import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.ModArmorMaterial;
import caixukun.caixukun.cxk.init.CXKItemReg;
import caixukun.caixukun.cxk.init.CXKSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class beidai extends ArmorItem {
    public beidai() {
        super(ModArmorMaterial.CXK, EquipmentSlotType.CHEST, new Properties().group(CXKItemGroup.CXK_ITEM_GROUP));
    }
    @Mod.EventBusSubscriber
    public static class GlobalTrigger {

        @SubscribeEvent
        public static void onEntityAttacked(LivingAttackEvent event) {
            Entity entity =event.getEntity();
            World world =entity.getEntityWorld();
            if(entity instanceof LivingEntity) {
                //System.out.println("LivingEntity");
                if (((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CXKItemReg.beidai.get()) {
                    System.out.println("true");
                    world.playSound((PlayerEntity) entity,entity.getPosX(),entity.getPosY(),entity.getPosZ(), CXKSound.niganma.get(), SoundCategory.AMBIENT,1,1);
                    //entity.playSound(CXKSound.niganma.get(),1,1);
                }
            }

        }
    }
}
