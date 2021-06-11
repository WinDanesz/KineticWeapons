package windanesz.torpedomod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = TorpedoMod.MODID, name = TorpedoMod.NAME, version = TorpedoMod.VERSION, acceptedMinecraftVersions = TorpedoMod.MC_VERSION)
public class TorpedoMod {

	public static final String MODID = "torpedomod";
	public static final String NAME = "Torpedo Mod";
	public static final String VERSION = "1.0.0";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Random rand = new Random();

	/**
	 * Static instance of the {@link Settings} object for TorpedMod.
	 */
	public static Settings settings = new Settings();

	public static Logger logger;

	// The instance of TorpedoMod that Forge uses.
	@Mod.Instance(TorpedoMod.MODID)
	public static TorpedoMod instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "windanesz.torpedomod.client.ClientProxy", serverSide = "windanesz.torpedomod.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		settings = new Settings();
		proxy.addOBJLoader();
		proxy.registerRenderers();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(instance); // Since there's already an instance we might as well use it

		//		TorpedoModPacketHandler.initPackets();

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {}

}
