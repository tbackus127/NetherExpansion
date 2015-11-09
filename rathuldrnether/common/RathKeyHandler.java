package rathuldrnether.common;

import java.util.EnumSet;

import net.minecraft.src.Item;
import net.minecraft.src.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class RathKeyHandler extends KeyHandler {

	public static KeyBinding rathChangeBinding = new KeyBinding("Change Ammo Type", Keyboard.KEY_V);
	boolean doubleFlag = false;
	
	public RathKeyHandler() 
	{
        //the first value is an array of KeyBindings, the second is whether or not the call 
        //keyDown should repeat as long as the key is down
        super(new KeyBinding[]{rathChangeBinding}, new boolean[]{false});
	}
	
	@Override
	public String getLabel() {
		return "rathkeybindings";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		if(tickEnd)
		{
			if(FMLClientHandler.instance().getClient().currentScreen == null)
			{
				if(kb.keyCode == rathChangeBinding.keyCode)
				{
					ItemParticleBow particleBow = (ItemParticleBow)RathuldrNether.itemParticleBow;
					particleBow.changeAmmoType();
				}
			}
		}
	}
	
	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
