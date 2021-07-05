package windanesz.kineticweapons;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import windanesz.kineticweapons.registry.KineticWeaponsItems;

import java.util.Random;

@Mod(modid = KineticWeapons.MODID, name = KineticWeapons.NAME, version = KineticWeapons.VERSION, acceptedMinecraftVersions = KineticWeapons.MC_VERSION)
public class KineticWeapons {

	public static final String MODID = "kineticweapons";
	public static final String NAME = "Kinetic Weapons";
	public static final String VERSION = "1.0.0";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Random rand = new Random();

	/**
	 * Static instance of the {@link Settings} object for TorpedMod.
	 */
	public static Settings settings = new Settings();

	public static Logger logger;

	// The instance of TorpedoMod that Forge uses.
	@Mod.Instance(KineticWeapons.MODID)
	public static KineticWeapons instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "windanesz.kineticweapons.client.ClientProxy", serverSide = "windanesz.kineticweapons.CommonProxy")
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

		KineticWeaponsItems.registerDispenseBehaviours();

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {}

}
