package windanesz.torpedomod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class BlankModel extends ModelBase {

	public BlankModel() { }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
	 * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
	 * "far" arms and legs can swing at most.
	 */
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
	}
}