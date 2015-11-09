package rathuldrnether.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class BlockRathRotwoodL extends Block
{
	public BlockRathRotwoodL(int i, int j)
	{
		super(i, j, Material.leaves);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
}
