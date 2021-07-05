package windanesz.kineticweapons.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import windanesz.kineticweapons.entity.EntityLongTorpedo;
import windanesz.kineticweapons.registry.KineticWeaponsItems;

//@SideOnly(Side.CLIENT)
public class RenderLongTorpedo extends Render<EntityLongTorpedo> {

	public RenderLongTorpedo(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityLongTorpedo entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();

		GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);

		// rendering the OBJ item entity
		renderItem(entity, entityYaw);

		GlStateManager.popMatrix();

	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLongTorpedo entity) { return null; }

	private void renderItem(EntityLongTorpedo entity, float entityYaw) {

		ItemStack stack = new ItemStack(KineticWeaponsItems.long_torpedo_model);
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();

			// applies the rotation to make the model facing to the correct direction
			GlStateManager.rotate(entityYaw, 0, 1, 0);

			GlStateManager.scale(0.6f, 0.6f, 0.6f);

			GlStateManager.color(1, 1, 1, 1);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);
			GlStateManager.popMatrix();
		}
	}
}
