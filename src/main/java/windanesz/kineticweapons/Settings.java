package windanesz.kineticweapons;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = KineticWeapons.MODID, name = "KineticWeapons") // No fancy configs here so we can use the annotation, hurrah!
public class Settings {

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = KineticWeapons.MODID)
	private static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(KineticWeapons.MODID)) {
				ConfigManager.sync(KineticWeapons.MODID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.Name("Settings")
	@Config.LangKey("settings.kineticweapons:settings")
	public static GeneralSettings settings = new GeneralSettings();

	public static class GeneralSettings {

		@Config.Name("Long Torpedo Acceleration Rate")
		@Config.Comment("Controls the speed acceleration of the Long Torpedo.")
		public float long_torpedo_acceleration_rate = 0.002f;

		@Config.Name("Long Torpedo Max Speed")
		@Config.Comment("Controls the maximum speed of the Long Torpedo.")
		public float long_torpedo_max_speed = 0.8f;

		@Config.Name("Long Torpedo Explosion Strength")
		@Config.Comment("Controls the explosion strength of the Long Torpedo. Keep in mind that setting this to a very large value can cause lag.")
		public float long_torpedo_explosion_strength = 2f;

		@Config.Name("Long Torpedo ItemMax Stack Size")
		@Config.Comment("Controls the explosion strength of the Long Torpedo. Keep in mind that setting this to a very large value can cause lag.")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 64)
		public int long_torpedo_max_stack_size= 1;

		@Config.Name("Long Torpedo Dispense Behaviour")
		@Config.Comment("If true, Long Torpedoes can be fired from vanilla dispensers.")
		@Config.RequiresMcRestart
		public boolean long_torpedo_dispense_behaviour = true;

		@Config.Name("Long Torpedo Stats Tooltip")
		@Config.Comment("If true, the Long Torpedo item displays the its explosion strength value in the item tooltip.")
		@Config.RequiresMcRestart
		public boolean long_torpedo_item_stat_tooltip = true;
	}
}
