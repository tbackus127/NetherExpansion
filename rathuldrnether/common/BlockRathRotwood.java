package rathuldrnether.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockRathRotwood extends Block
{
	public BlockRathRotwood(int i, int j)
	{
		super(i, j, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int getBlockTextureFromSide(int par1)
	{
		return par1 == 0 ? 49 : (par1 == 1 ? 49 : 48);
	}
	
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
}
