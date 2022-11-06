package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.CXKItemGroup;
import caixukun.caixukun.cxk.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CXKItemReg {
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS, Caixukun.ModID);
    public static final RegistryObject<Item> YB =ITEMS.register("youbing", ()-> new Youbin(false));
    public static final RegistryObject<Item> FMYB =ITEMS.register("fumoyoubing", ()-> new Youbin(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> LZ =ITEMS.register("lizi", ()->new Lizi(false));
    public static final RegistryObject<Item> FMLZ =ITEMS.register("fumolizi", ()->new Lizi(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> XJJY =ITEMS.register("xiangjinjianyu", ()->new Xiangjinjianyu(false));
    public static final RegistryObject<Item> FMXJJY =ITEMS.register("fumoxiangjinjianyu", ()->new Xiangjinjianyu(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> sbsr =ITEMS.register("shibushiren", ()->new shibushiren(false));
    public static final RegistryObject<Item> FMsbsr =ITEMS.register("fumoshibushiren", ()->new shibushiren(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> sjb =ITEMS.register("shenjinbing", ()->new ShenjinbingItem(false));
    public static final RegistryObject<Item> FMsjb =ITEMS.register("fumoshenjinbing", ()->new ShenjinbingItem(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> rsgz =ITEMS.register("renshenggongji",()->new RenshengdongjiItem(false));
    public static final RegistryObject<Item> fmrsgz =ITEMS.register("fumorenshenggongji",()->new RenshengdongjiItem(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> lsh =ITEMS.register("lvshihan",()->new LvshihanItem(false));
    public static final RegistryObject<Item> fmlsh =ITEMS.register("fumolvshihan",()->new LvshihanItem(true){
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
        }
    });
    public static final RegistryObject<Item> kun =ITEMS.register("kunzilinpian", Kun::new);
    public static final RegistryObject<Item> zhongfen =ITEMS.register("kunkundezhongfen", kunkundezhongfen::new);
    public static final RegistryObject<Item> beidai =ITEMS.register("beidaiku", beidai::new);
    public static final RegistryObject<Item> beidaiku =ITEMS.register("kunku", beidaiku::new);
    public static final RegistryObject<Item> kunxie =ITEMS.register("kunxie",Kunxie::new);
    public static final RegistryObject<Item> kaituandic =ITEMS.register("kaituanmusic", KaituanDiscItem::new);
    public static final RegistryObject<Item> jntm =ITEMS.register("jinitaimei", jntmDiscItem::new);

    public static final RegistryObject<Item> b1 =ITEMS.register("zhongfenshi_item", ()->new BlockItem(CXKBlockReg.zhongfenshi.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b2 =ITEMS.register("lizishi_item", ()->new BlockItem(CXKBlockReg.lizifenshi.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b3 =ITEMS.register("beidaini_item", ()->new BlockItem(CXKBlockReg.beidaini.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b4 =ITEMS.register("zhongfenmu_item", ()->new BlockItem(CXKBlockReg.zhongfenmu.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b5 =ITEMS.register("kuncao_item", ()->new BlockItem(CXKBlockReg.kuncao.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b6 =ITEMS.register("kunhua_item", ()->new BlockItem(CXKBlockReg.kunhua.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
    public static final RegistryObject<Item> b7 =ITEMS.register("zhongfenye_item", ()->new BlockItem(CXKBlockReg.zhongfenye.get(),new Item.Properties().group(CXKItemGroup.CXK_ITEM_GROUP)));
}
