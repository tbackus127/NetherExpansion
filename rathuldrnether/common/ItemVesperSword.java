package rathuldrnether.common;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;

public class ItemVesperSword extends ItemSword
{
	public ItemVesperSword(int itemID, EnumToolMaterial toolMaterial)
	{
		super(itemID, toolMaterial);
	}
	
	public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
}
