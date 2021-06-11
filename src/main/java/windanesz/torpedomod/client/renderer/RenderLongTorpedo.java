package windanesz.torpedomod.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import windanesz.torpedomod.entity.EntityLongTorpedo;
import windanesz.torpedomod.registry.TorpedoModItems;

//@SideOnly(Side.CLIENT)
public class RenderLongTorpedo extends Render<EntityLongTorpedo> {

	public RenderLongTorpedo(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityLongTorpedo entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();

		GlStateManager.translate((float) x + 0.5F, (float) y + 0F, (float) z + 0.5F);

		// rendering the OBJ item entity
		renderItem();

		GlStateManager.popMatrix();

	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLongTorpedo entity) { return null; }

	private void renderItem() {

		ItemStack stack = new ItemStack(TorpedoModItems.long_torpedo);
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();

			GlStateManager.rotate(0, 180, 180, 180);
			GlStateManager.scale(0.6f, 0.6f, 0.6f);
			//			GlStateManager.scale(0.85F, 0.85F, 0.85F);

			GlStateManager.color(1, 1, 1, 1);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);
			GlStateManager.popMatrix();
		}
	}
}
