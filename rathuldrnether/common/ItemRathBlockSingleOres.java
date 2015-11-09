package rathuldrnether.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemRathBlockSingleOres extends ItemBlock
{
	private static String[] subNames = {
		"abysscrystal", "magmacrystal", "hazydiamond"
	};
	
	//public ItemRathBlockOres(int par1, Block block) 
	public ItemRathBlockSingleOres(int par1) 
	{
		super(par1);
		setHasSubtypes(true);
		setItemName("rathSingleOres");
	}
	
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	public int getMetadata (int damageValue) {
		return damageValue;
	}
}
