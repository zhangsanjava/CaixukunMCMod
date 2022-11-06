package caixukun.caixukun.cxk;

import caixukun.caixukun.cxk.init.CXKItemReg;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class CXKItemGroup extends ItemGroup {
    public static final CXKItemGroup CXK_ITEM_GROUP =new CXKItemGroup();
    public CXKItemGroup() {
        super("cxk_group");
    }
/*
    @Override
    public ItemStack createIcon() {
        return new ItemStack(CXKRegistries.YB.get());
    }

 */
@Override
public ItemStack createIcon() {
    return new ItemStack(CXKItemReg.YB.get());
}
}
