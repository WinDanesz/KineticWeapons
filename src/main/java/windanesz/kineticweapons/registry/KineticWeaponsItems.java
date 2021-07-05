package windanesz.kineticweapons.registry;

import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import windanesz.kineticweapons.KineticWeapons;
import windanesz.kineticweapons.Settings;
import windanesz.kineticweapons.entity.EntityLongTorpedo;

import javax.annotation.Nonnull;

@ObjectHolder(KineticWeapons.MODID)
@Mod.EventBusSubscriber
public class KineticWeaponsItems {

	private KineticWeaponsItems() {} // no instances!

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T placeholder() { return null; }

	/**
	 * The item which is used to render the torpedo, not an actual item ingame and should never be used!
	 */
	public static final Item long_torpedo_model = placeholder();

	/**
	 * The torpedo item which can be used by players
	 */
	public static final Item long_torpedo = placeholder();

	public static void registerItem(IForgeRegistry<Item> registry, String name, Item item) {
		registerItem(registry, name, item, false);
	}

	public static void registerItem(IForgeRegistry<Item> registry, String name, Item item, boolean setTabIcon) {
		item.setRegistryName(KineticWeapons.MODID, name);
		item.setTranslationKey(item.getRegistryName().toString());
		registry.register(item);
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();

		/// "RENDER" ITEMS
		registerItem(registry, "long_torpedo_model", new Item());

		/// The actual items
		registerItem(registry, "long_torpedo", new Item().setCreativeTab(CreativeTabs.COMBAT).setMaxStackSize(Settings.settings.long_torpedo_max_stack_size) );
	}

	//////////// Dispenser behaviour handling ////////////

	/**
	 * Called from init(), handles the registering of the mod items for the vanilla dispenser block
	 */
	public static void registerDispenseBehaviours() {

		if (Settings.settings.long_torpedo_dispense_behaviour) {

			BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(KineticWeaponsItems.long_torpedo, new BehaviorProjectileDispense()
			{
				/**
				 * Return the projectile entity spawned by this dispense behavior.
				 */
				protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
				{
					return new EntityLongTorpedo(worldIn, position.getX(), position.getY(), position.getZ());
				}
			});
		}
	}
}
