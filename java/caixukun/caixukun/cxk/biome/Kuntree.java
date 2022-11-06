package caixukun.caixukun.cxk.biome;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

import java.util.Random;
import java.util.Set;

public class Kuntree extends Feature {
    public Kuntree(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, IFeatureConfig config) {
        return false;
    }
}
