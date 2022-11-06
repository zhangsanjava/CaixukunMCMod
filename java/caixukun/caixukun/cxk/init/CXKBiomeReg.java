package caixukun.caixukun.cxk.init;

import caixukun.caixukun.Caixukun;
import caixukun.caixukun.cxk.biome.KunBiomeMaker;
import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.List;
import java.util.Locale;
import java.util.function.Function;


public class CXKBiomeReg {
    public static final DeferredRegister<Biome> BIOME = DeferredRegister.create(ForgeRegistries.BIOMES,Caixukun.ModID);
    public static final RegistryObject<Biome> KUNB =BIOME.register("kun", KunBiomeMaker::makeKunBiome);
    /*
    private static final Int2ObjectMap<RegistryKey<Biome>> idToKeyMap = new Int2ObjectArrayMap<>();
    public static final Biome PLAINS = register(114, Biomes.PLAINS, KunBiomeMaker.makeKunBiome());
    private static Biome register(int id, RegistryKey<Biome> key, Biome biome) {
        idToKeyMap.put(id, key);
        return WorldGenRegistries.register(WorldGenRegistries.BIOME, id, key, biome);
    }
    public static Biome getModBiomes()
    {
        return PLAINS;
    }









    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Caixukun.ModID);

    public static final RegistryKey<Biome> KUN = makeKey("kun");
    public static RegistryKey<Biome> makeKey(String name) {
        BIOMES.register(name, () -> new Biome.Builder()
                .precipitation(Biome.RainType.NONE)
                .category(Biome.Category.NONE)
                .depth(0)
                .downfall(0)
                .scale(0)
                .temperature(0)
                .setEffects(new BiomeAmbience.Builder().setFogColor(0).setWaterColor(0).setWaterFogColor(0).withSkyColor(0).build())
                .withGenerationSettings(new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.GRASS).build())
                .withMobSpawnSettings(new MobSpawnInfo.Builder().build())
                .withTemperatureModifier(Biome.TemperatureModifier.NONE)
                .build());
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, CXKBiomeReg.prefix(name));
    }
    private static ResourceLocation prefix(String name){
        return new ResourceLocation(Caixukun.ModID, name.toLowerCase(Locale.ROOT));
    }
    public static void addBiomeTypes(){
        BiomeDictionary.addTypes(KUN, BiomeDictionary.Type.PLAINS);
    }

     */
}
