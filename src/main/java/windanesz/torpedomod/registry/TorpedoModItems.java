package windanesz.torpedomod.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import windanesz.torpedomod.TorpedoMod;

import javax.annotation.Nonnull;

@ObjectHolder(TorpedoMod.MODID)
@Mod.EventBusSubscriber
public class TorpedoModItems {

	private TorpedoModItems() {} // no instances!

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T placeholder() { return null; }

	public static final Item long_torpedo = placeholder();

	// below registry methods are courtesy of EB
	public static void registerItem(IForgeRegistry<Item> registry, String name, Item item) {
		registerItem(registry, name, item, false);
	}

	public static void registerItem(IForgeRegistry<Item> registry, String name, Item item, boolean setTabIcon) {
		item.setRegistryName(TorpedoMod.MODID, name);
		item.setTranslationKey(item.getRegistryName().toString());
		registry.register(item);
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();

				registerItem(registry, "long_torpedo", new Item().setCreativeTab(CreativeTabs.COMBAT));
	}

}
