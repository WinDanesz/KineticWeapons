package windanesz.kineticweapons.model;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import windanesz.kineticweapons.registry.KineticWeaponsItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public final class KineticWeaponsModels {
	private KineticWeaponsModels() { // no instances
	}

	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {

		/// Items solely used for OBJ rendering ///
		registerItemModel(KineticWeaponsItems.long_torpedo_model);


		/// Regular Items ///
		registerItemModel(KineticWeaponsItems.long_torpedo);

	}

	private static void registerItemModel(Item item) {
		ModelBakery.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		ModelLoader.setCustomMeshDefinition(item, s -> new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private static void registerItemModel(Item item, int metadata, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), variant));
	}

}

