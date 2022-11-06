package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.block.CXKBlock;
import caixukun.caixukun.cxk.effect.CXKEffect;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;

public class CXKBlockReg {
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, Caixukun.ModID);
    public static final RegistryObject<Block> zhongfenshi = BLOCKS.register("zhongfenstone",()->new CXKBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> beidaini = BLOCKS.register("beidaini",()->new GrassBlock(AbstractBlock.Properties.create(Material.ORGANIC).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT)){
        @Override
        public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
            return true;
        }
    });
    public static final RegistryObject<Block> lizifenshi = BLOCKS.register("lizistone",()->new CXKBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> zhongfenmu =BLOCKS.register("zhongfenmu",()->new CXKBlock(AbstractBlock.Properties.create(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> zhongfenye =BLOCKS.register("zhongfenye", ()->new Block(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(CXKBlockReg::allowsSpawnOnLeaves).setSuffocates(CXKBlockReg::isntSolid).setBlocksVision(CXKBlockReg::isntSolid)));
    public static final RegistryObject<Block> kuncao = BLOCKS.register("kuncao",()->new TallGrassBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> kunhua =BLOCKS.register("kunhua",()->new TallGrassBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));




    private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> {
            return state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
        }).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE));
    }
    private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(CXKBlockReg::allowsSpawnOnLeaves).setSuffocates(CXKBlockReg::isntSolid).setBlocksVision(CXKBlockReg::isntSolid));
    }
    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }
}
