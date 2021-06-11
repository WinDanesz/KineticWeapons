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
	public void doRender(EntityLongTorpedo entity, double par2, double par4, double par6, float par8, float par9) {
		// item renderer goes here !
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLongTorpedo entity) { return null; }


	private void renderItem() {

		ItemStack stack = new ItemStack(TorpedoModItems.long_torpedo);
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();

			GlStateManager.rotate(180, 0, 180, 180);
			//			GlStateManager.scale(0.85F, 0.85F, 0.85F);

			GlStateManager.color(1, 1, 1, 1);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);
			GlStateManager.popMatrix();
		}
	}
}
