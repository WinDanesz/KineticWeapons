package windanesz.kineticweapons.item;

import net.minecraft.item.Item;
import windanesz.kineticweapons.Settings;


// TODO: make use of this
public class ItemLongTorpedo extends Item {

	public ItemLongTorpedo() {
		super();
		setMaxStackSize(Settings.settings.long_torpedo_max_stack_size);
	}


//
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//		if (Settings.settings.long_torpedo_item_stat_tooltip) {
//		}
//
//		tooltip.add(new TextComponentTranslation())
//		super.addInformation(stack, worldIn, tooltip, flagIn);
//	}
}
