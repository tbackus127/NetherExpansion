package rathuldrnether.common;

import net.minecraft.client.Minecraft;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemParticleBow extends Item
{
	private int particleBowType = 0;
	
	public ItemParticleBow(int par1) {
		super(par1);
		this.maxStackSize = 1;
        this.setMaxDamage(512);
        this.setTabToDisplayOn(CreativeTabs.tabCombat);
	}
	
	public void changeAmmoType()
	{
		ItemStack ISParticleBow = new ItemStack(RathuldrNether.itemParticleBow);
		if(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().itemID == ISParticleBow.itemID)
		{
			switch (particleBowType)
			{
			case 0:
				particleBowType = 1;
				Minecraft.getMinecraft().thePlayer.addChatMessage("Blazing ammo selected.");
				break;
			case 1:
				particleBowType = 2;
				Minecraft.getMinecraft().thePlayer.addChatMessage("Freezing ammo selected.");
				break;
			case 2:
				particleBowType = 0;
				Minecraft.getMinecraft().thePlayer.addChatMessage("Mystic ammo selected.");
				break;
			default:
				particleBowType = 0;
			}
		}
		else
		{
			System.out.println("Particle Bow is not currently held.");
		}
	}
	
	public int getIconIndex(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(usingItem != null && usingItem.getItem().shiftedIndex == RathuldrNether.itemParticleBow.shiftedIndex)
		{
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if(k >= 18) return 168;
			if(k > 9) return 167;
			if(k > 0) return 166;
		}
		return getIconIndex(stack);
	}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
        
        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        var6 = event.charge;
        
        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        
        
        switch(particleBowType)
        {
        case 0:
        	if (var5 || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemMysticShot.shiftedIndex))
	        {
	            float var7 = (float)var6 / 20.0F;
	            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
	
	            if ((double)var7 < 0.1D)
	            {
	                return;
	            }
	
	            if (var7 > 1.0F)
	            {
	                var7 = 1.0F;
	            }
	
	            EntityRathMysticShot var8 = new EntityRathMysticShot(par2World, par3EntityPlayer, var7 * 2.0F);
	
	            if (var7 == 1.0F)
	            {
	                var8.func_70243_d(true);
	            }
	
	            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	
	            if (var9 > 0)
	            {
	                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
	            }
	
	            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	
	            if (var10 > 0)
	            {
	                var8.setKnockbackStrength(var10);
	            }
	
	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	            {
	                var8.setFire(100);
	            }
	
	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            
	            // Change this for sound effect.
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
	
	            if (var5)
	            {
	                var8.canBePickedUp = 2;
	            }
	            else
	            {
	            	
	            	// Change this to consume the arrow.
	                par3EntityPlayer.inventory.consumeInventoryItem(RathuldrNether.itemMysticShot.shiftedIndex);
	            }
	            par2World.spawnEntityInWorld(var8);
	        }
        break;
        case 1:
	        if (var5 || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemBlazingShot.shiftedIndex))
	        {
	            float var7 = (float)var6 / 20.0F;
	            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
	
	            if ((double)var7 < 0.1D)
	            {
	                return;
	            }
	
	            if (var7 > 1.0F)
	            {
	                var7 = 1.0F;
	            }
	
	            EntityRathBlazingShot var8 = new EntityRathBlazingShot(par2World, par3EntityPlayer, var7 * 2.0F);
	
	            if (var7 == 1.0F)
	            {
	                var8.func_70243_d(true);
	            }
	
	            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	
	            if (var9 > 0)
	            {
	                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
	            }
	
	            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	
	            if (var10 > 0)
	            {
	                var8.setKnockbackStrength(var10);
	            }
	
	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	            {
	                var8.setFire(100);
	            }
	
	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            
	            // Change this for sound effect.
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
	
	            if (var5)
	            {
	                var8.canBePickedUp = 2;
	            }
	            else
	            {
	            	
	            	// Change this to consume the arrow.
	                par3EntityPlayer.inventory.consumeInventoryItem(RathuldrNether.itemBlazingShot.shiftedIndex);
	            }
	            par2World.spawnEntityInWorld(var8);
	        }
	    break;
        case 2:
	        if (var5 || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemCryoShot.shiftedIndex))
	        {
	            float var7 = (float)var6 / 20.0F;
	            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
	
	            if ((double)var7 < 0.1D)
	            {
	                return;
	            }
	
	            if (var7 > 1.0F)
	            {
	                var7 = 1.0F;
	            }
	
	            EntityRathCryoShot var8 = new EntityRathCryoShot(par2World, par3EntityPlayer, var7 * 2.0F);
	
	            if (var7 == 1.0F)
	            {
	                var8.func_70243_d(true);
	            }
	
	            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	
	            if (var9 > 0)
	            {
	                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
	            }
	
	            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	
	            if (var10 > 0)
	            {
	                var8.setKnockbackStrength(var10);
	            }
	
	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	            {
	                var8.setFire(100);
	            }
	
	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            
	            // Change this for sound effect.
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
	
	            if (var5)
	            {
	                var8.canBePickedUp = 2;
	            }
	            else
	            {
	            	
	            	// Change this to consume the arrow.
	                par3EntityPlayer.inventory.consumeInventoryItem(RathuldrNether.itemCryoShot.shiftedIndex);
	            }
	            par2World.spawnEntityInWorld(var8);
	        }
	    break;
	    default:
	    	System.out.println("Particle Bow type is not 0, 1, or 2!");
	    break;
        }
    }
	
	public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        switch(particleBowType)
        {
        case 0:
        	if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemMysticShot.shiftedIndex))
	        {
	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        }
        break;
        case 1:
        	if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemBlazingShot.shiftedIndex))
	        {
	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        }
        break;
        case 2:
        	if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(RathuldrNether.itemCryoShot.shiftedIndex))
	        {
	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        }
        break;
        default:
        	System.out.println("Bow type is out of bounds.");
        }
        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
    
    public String getTextureFile()
	{
		return "/rathuldr/img/RathuldrNetherTextures.png";
	}

}
