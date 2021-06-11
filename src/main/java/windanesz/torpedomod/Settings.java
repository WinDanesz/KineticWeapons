package windanesz.torpedomod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = TorpedoMod.MODID, name = "TorpedoMod") // No fancy configs here so we can use the annotation, hurrah!
public class Settings {

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = TorpedoMod.MODID)
	private static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(TorpedoMod.MODID)) {
				ConfigManager.sync(TorpedoMod.MODID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.Name("Settings")
	@Config.LangKey("settings.torpedomod:settings")
	public static GeneralSettings settings = new GeneralSettings();

	public static class GeneralSettings {
		//
		//		@Config.Name("Scroll Tier Cap of Non-Discipline Elements")
		//		@Config.Comment("Controls how players can use scrolls which are not their discipline. If this is set to 0, players won't be able to use scrolls which doesn't belong to their discipline. Values:"
		//				+ "\n0: None"
		//				+ "\n1: Novice"
		//				+ "\n2: Apprentice"
		//				+ "\n3: Advanced"
		//				+ "\n4: Master")
		//		@Config.SlidingOption
		//		@Config.RangeInt(min = 0, max = 4)
		//		public int scroll_tier_limit = 4;
		//
		//
	}
}