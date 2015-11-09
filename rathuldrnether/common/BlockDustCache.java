package rathuldrnether.common;

import java.util.List;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

// Metadata List:
// Metadata: Block Name = Texture Index
// 0: Dust Cache = 16
// 1: Abyss Crystal = 17
// 2: Magma Crystal = 18

public class BlockDustCache extends Block
{
	public BlockDustCache(int par1, int par2)
	{
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
		this.blockHardness = 3.0F;
	}
	
	@Override
	public int getBlockTextureFromSide(int side) {
		return 16;
	}
	
	@Override
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
			double dRand = Math.random();
			
			if(dRand < 0.8)
			{
				return RathuldrNether.itemMysticDust.shiftedIndex;
			}
			else
			{
				return RathuldrNether.itemEtherealDust.shiftedIndex;
			}
    }
	
	public int quantityDropped(Random par1Random)
    {
		return par1Random.nextInt(8) + 2;
    }
	
}
