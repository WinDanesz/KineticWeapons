package windanesz.kineticweapons.client;

import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import windanesz.kineticweapons.CommonProxy;
import windanesz.kineticweapons.KineticWeapons;
import windanesz.kineticweapons.client.renderer.RenderLongTorpedo;
import windanesz.kineticweapons.entity.EntityLongTorpedo;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	/**
	 * Registers this mod for the Forge obj loader
	 */
	@Override
	public void addOBJLoader() {
		OBJLoader.INSTANCE.addDomain(KineticWeapons.MODID);
	}

	/**
	 * Registers the entity renderers, called during preInit
	 */
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLongTorpedo.class, RenderLongTorpedo::new);

	}
}

