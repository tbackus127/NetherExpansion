package rathuldrnether.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemBlazingShot extends Item
{
	public ItemBlazingShot(int par1) {
		super(par1);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabCombat);
	}
	
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
}
