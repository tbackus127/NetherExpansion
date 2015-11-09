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

public class BlockRathSingleOres extends Block
{
	public BlockRathSingleOres(int par1, int par2)
	{
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
		this.blockHardness = 3.0F;
	}
	
	@Override
	public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
		return 17 + metadata;
	}
	
	@Override
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
		switch(par1)
		{
		
		// Abyss Crystal
		case 0:
			return RathuldrNether.itemAbyssCrystal.shiftedIndex;
			
		// Molten Crystal
		case 1:
			return RathuldrNether.itemMagmaCrystal.shiftedIndex;
			
		// Hazy Diamond
		case 2:
			return RathuldrNether.itemHazyDiamond.shiftedIndex;
			
		// The Super Material
		case 3:
			//return RathuldrNether.itemNEEDSNAME.shiftedIndex;
			
		default:
			return RathuldrNether.itemMysticDust.shiftedIndex;
		}
    }
	
	public int quantityDropped(Random par1Random)
    {
		return 1;
    }
	
	// Change the "ix < 2" to how many blocks are in the block.
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 3; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
	
}
