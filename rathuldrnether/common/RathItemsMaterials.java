package rathuldrnether.common;


import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class RathItemsMaterials extends Item
{
	public RathItemsMaterials(int i)
	{
		super(i);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
}
