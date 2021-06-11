package windanesz.torpedomod.registry;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;
import windanesz.torpedomod.TorpedoMod;
import windanesz.torpedomod.entity.EntityLongTorpedo;

@Mod.EventBusSubscriber
public class TorpedoModEntities {

	private TorpedoModEntities() {} // no instances!

	/**
	 * Incrementing index for the mod-specific entity network ID.
	 */
	private static int id = 0;

	/**
	 * Registering entities
	 */
	@SubscribeEvent
	public static void register(RegistryEvent.Register<EntityEntry> event) {

		IForgeRegistry<EntityEntry> registry = event.getRegistry();

		registry.register(createEntry(EntityLongTorpedo.class, "long_torpedo", 64, 1, true).build());
	}

	private static <T extends Entity> EntityEntryBuilder<T> createEntry(Class<T> entityClass, String name, int range, int interval, boolean trackVelocity) {
		return createEntry(entityClass, name).tracker(range, interval, trackVelocity);
	}

	private static <T extends Entity> EntityEntryBuilder<T> createEntry(Class<T> entityClass, String name) {
		ResourceLocation registryName = new ResourceLocation(TorpedoMod.MODID, name);
		return EntityEntryBuilder.<T>create().entity(entityClass).id(registryName, id++).name(registryName.toString());
	}
}
