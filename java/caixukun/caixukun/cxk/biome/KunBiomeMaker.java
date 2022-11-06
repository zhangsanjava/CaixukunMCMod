package caixukun.caixukun.cxk.biome;

import caixukun.caixukun.cxk.init.CXKBlockReg;
import caixukun.caixukun.cxk.init.CXKEntityReg;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class KunBiomeMaker {
    public static Biome makeKunBiome(){
        BiomeAmbience BA =
                new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(4159204).setWaterFogColor(329011)
                        .withSkyColor(7972607).withFoliageColor(10387789).withGrassColor(9470285).build();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
                .withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getBlock().getDefaultState(),
                        CXKBlockReg.zhongfenshi.get().getDefaultState(), CXKBlockReg.zhongfenshi.get().getDefaultState())));

        biomeGenerationSettings.withFeature
                (
                        GenerationStage.Decoration.LOCAL_MODIFICATIONS,
                        Feature.TREE.withConfiguration
                                        (
                                                (new BaseTreeFeatureConfig.Builder(
                                                        new SimpleBlockStateProvider(CXKBlockReg.zhongfenmu.get().getDefaultState()),//树干
                                                        new SimpleBlockStateProvider(CXKBlockReg.zhongfenye.get().getDefaultState()),//树叶
                                                        new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                                                        new StraightTrunkPlacer(7, 2, 0), //树的生成
                                                        new TwoLayerFeature(1, 0, 1)))
                                                        .setIgnoreVines().build())
                                .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                                .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1)))
                );//放置树

        biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(
                        (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CXKBlockReg.kuncao.get().getDefaultState()), SimpleBlockPlacer.PLACER))
                                .tries(32).build()).withPlacement(Features.Placements.PATCH_PLACEMENT)
                        .withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 4))));

        biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(
                                (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(CXKBlockReg.kunhua.get().getDefaultState(), 2), SimpleBlockPlacer.PLACER)).tries(64).build()
                        )
                        .withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));


        //DefaultBiomeFeatures.withBadlandsOakTrees(biomeGenerationSettings);
        //biomeGenerationSettings.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(CXKBlockReg.kunhua.get().getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).variableCount(2));
/*
        biomeGenerationSettings.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION,
                Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CXKBlockReg.kunhua.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(10)
        );//生草鸡
        biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CXKBlockReg.kuncao.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).preventProjection().build()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(10)
        );

 */


/*
        biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(
                        (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(CXKBlockReg.kunhua.get().getDefaultState(), 2)
                                , SimpleBlockPlacer.PLACER)).tries(64).build()
                ).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));


 */
        DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
        DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

        //MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();//刷怪
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.KUNJI.get(), 8, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.lkunrne.get(), 4, 2, 3));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.nkunren.get(), 8, 2, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(CXKEntityReg.KUNJI.get(), 8, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(CXKEntityReg.lkunrne.get(), 4, 2, 3));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(CXKEntityReg.nkunren.get(), 8, 2, 4));
/*
        return new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0.1f).scale(0.2f).temperature(0.5f)
                .downfall(0.5f).setEffects(BA).withMobSpawnSettings(mobspawninfo$builder.build())
                .withGenerationSettings(biomeGenerationSettings.build()).build();

 */
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).setEffects(BA).withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomeGenerationSettings.build()).build();
    }
/*
    public static Biome newKunBiome(){
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();//刷怪
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.KUNJI.get(), 8, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.lkunrne.get(), 4, 2, 3));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(CXKEntityReg.nkunren.get(), 8, 2, 4));
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBats(mobspawninfo$builder);
        DefaultBiomeFeatures.withHostileMobs(mobspawninfo$builder, 100, 25, 100);
        //有关刷怪

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(
                new SurfaceBuilderConfig(CXKBlockReg.zhongfenshi.get().getDefaultState(),
                CXKBlockReg.zhongfenshi.get().getDefaultState(), CXKBlockReg.zhongfenshi.get().getDefaultState()))
        );
        //基本

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,Feature.TREE.generate());



        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        //DefaultBiomeFeatures.withSparseBerries(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.TAIGA).depth(depth).scale(scale).temperature(temperature).downfall(0.8F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(temperature)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }

 */


}
