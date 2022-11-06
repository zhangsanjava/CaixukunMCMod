package caixukun.caixukun;

import caixukun.caixukun.cxk.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("caixukun")
public class Caixukun {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String ModID ="caixukun";

    public Caixukun() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        CXKItemReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CXKEffectReg.EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CXKSound.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CXKEntityReg.ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        CXKBlockReg.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CXKBiomeReg.BIOME.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("caixukun", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            //mod.beethoven92.betterendforge.common.init.ModBiomes.register();
            //mod.beethoven92.betterendforge.common.init.ModBiomes.getModBiomes().forEach((end_biome) -> event.getRegistry().register(end_biome.getBiome()));
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(CXKBiomeReg.KUNB.get())), 34));
            event.getRegistry().register(CXKBiomeReg.KUNB.get());
        }
        /*
            @Mod.EventBusSubscriber(modid = BetterEnd.MOD_ID, bus = Bus.MOD)
    public static class WorldGenRegistryEvents
    {
    	@SubscribeEvent
    	public static void registerBiomes(RegistryEvent.Register<Biome> event)
    	{
    		ModBiomes.register();
    		ModBiomes.getModBiomes().forEach((end_biome) -> event.getRegistry().register(end_biome.getBiome()));
    	}

        * */
    }
    @SubscribeEvent
    public void init(FMLCommonSetupEvent evt){
        //CXKBiomeReg.addBiomeTypes();

    }
}
