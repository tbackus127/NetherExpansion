package rathuldrnether.common;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDamageSourceIndirect;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "RathuldrNether", name = "RathuldrNether", version = "rev001")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class RathuldrNether 
{
	@Instance("RathuldrNether")
	public static RathuldrNether instance;
	
	@SidedProxy(clientSide = "rathuldrnether.client.ClientProxyRathuldrNether", serverSide = "rathuldrnether.common.CommonProxyRathuldrNether")
	public static CommonProxyRathuldrNether proxy;
	
	public RathuldrNether()
	{
		
	}
	
	// Block IDs
	private static final int rathDustCacheID = 750;
	private static final int rathWoodBlockID = 751;
	private static final int rathLeafBlockID = 752;
	private static final int rathSingleOreBlockID = 753;
	
	// Item IDs
	private static final int rathMysticDustID = 6500;
	private static final int rathEtherealDustID = 6501;
	private static final int rathVesperCrystalID = 6502;
	private static final int rathHazyDiamondID = 6503;
	private static final int rathShimmerwoodLogID = 6504;
	private static final int rathMagmaCrystalID = 6505;
	private static final int rathPhaseShardID = 6506;
	private static final int rathCloudyLensID = 6507;
	private static final int rathCrystalLensID = 6508;
	private static final int rathGazerTentacleID = 6509;
	private static final int rathGhastPearlID = 6510;
	private static final int rathFlickeringCordID = 6511;
	private static final int rathAbyssCrystalID = 6512;
	
	// Tool IDs
	private static final int rathVesperPickaxeID = 6550;
	private static final int rathVesperSwordID = 6551;
	private static final int rathParticleBowID = 6552;
	private static final int rathMysticShotID = 6553;
	private static final int rathBlazingShotID = 6554;
	private static final int rathCryoShotID = 6555;
	
	// Ore block / names
	
	public static final Block blockRathSingleOres = new BlockRathSingleOres(rathSingleOreBlockID, 17);
	private static final String[] rathSingleOreNames = { 
		"Abyss Crystal", "Magma Crystal", "Hazy Diamond"
	};
	
	
	public static Block blockRotwoodLog;
	public static Block blockRotwoodLeaves;
	public static Block blockDustCache;
	
	public static Item itemMysticDust;
	public static Item itemEtherealDust;
	public static Item itemVesperCrystal;
	public static Item itemHazyDiamond;
	public static Item itemShimmerwoodLog;
	public static Item itemMagmaCrystal;
	public static Item itemPhaseShard;
	public static Item itemCloudyLens;
	public static Item itemCrystalLens;
	public static Item itemGazerTentacle;
	public static Item itemGhastPearl;
	public static Item itemFlickeringCord;
	public static Item itemAbyssCrystal;
	
	public static Item itemVesperPickaxe;
	public static Item itemVesperSword;
	public static Item itemParticleBow;
	public static Item itemMysticShot;
	public static Item itemBlazingShot;
	public static Item itemCryoShot;
	
	// Harvest level, durability, speed, damage, enchantability
	static EnumToolMaterial rathMaterialPick = EnumHelper.addToolMaterial("materialRathPick", 4, 200, 60F, 4, 14);
	static EnumToolMaterial rathMaterialSword = EnumHelper.addToolMaterial("materialRathSword", 1, 200, 12F, 12, 14);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		
	}
	
	public static DamageSource causeMysticShotDamage(EntityRathMysticShot par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("mysticShot", par0EntityArrow, par1Entity)).setProjectile();
    }
	
	public static DamageSource causeBlazingShotDamage(EntityRathBlazingShot par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("blazingShot", par0EntityArrow, par1Entity)).setProjectile();
    }
	
	public static DamageSource causeCryoShotDamage(EntityRathCryoShot par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("cryoShot", par0EntityArrow, par1Entity)).setProjectile();
    }
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRathMysticShot.class, new RathRenderMysticShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityRathBlazingShot.class, new RathRenderBlazingShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityRathCryoShot.class, new RathRenderCryoShot());
		
		
		GameRegistry.registerBlock(blockRathSingleOres, ItemRathBlockSingleOres.class);
		for (int ix = 0; ix < 3; ix++) {
			ItemStack ISRathSingleOres = new ItemStack(blockRathSingleOres, 1, ix);
			LanguageRegistry.addName(ISRathSingleOres, rathSingleOreNames[ISRathSingleOres.getItemDamage()]);
		}
		
		blockDustCache = new BlockDustCache(rathDustCacheID, 16).setStepSound(Block.soundStoneFootstep).setHardness(2.0F).setResistance(1.0F).setBlockName("nameDustCache");
		GameRegistry.registerBlock(blockDustCache);
		LanguageRegistry.addName(blockDustCache, "Dust Cache");
		
		blockRotwoodLog = new BlockRathRotwood(rathWoodBlockID, 48).setStepSound(Block.soundWoodFootstep).setHardness(2.0F).setResistance(1.0F).setBlockName("nameRotwood");
		GameRegistry.registerBlock(blockRotwoodLog);
		LanguageRegistry.addName(blockRotwoodLog, "Rotwood Log");
		
		blockRotwoodLeaves = new BlockRathRotwoodL(rathLeafBlockID, 51).setStepSound(Block.soundGrassFootstep).setHardness(0.8F).setResistance(0.2F).setBlockName("nameRotwoodL");
		GameRegistry.registerBlock(blockRotwoodLeaves);
		LanguageRegistry.addName(blockRotwoodLeaves, "Rotwood Leaves");
		
		
		
		
		itemMysticDust = new RathItemsMaterials(rathMysticDustID).setIconIndex(128).setItemName("nameMysticDust");
		LanguageRegistry.addName(itemMysticDust, "Mystic Dust");
		
		itemEtherealDust = new RathItemsMaterials(rathEtherealDustID).setIconIndex(129).setItemName("nameEtherealDust");
		LanguageRegistry.addName(itemEtherealDust, "Ethereal Dust");
		
		itemVesperCrystal = new RathItemsMaterials(rathVesperCrystalID).setIconIndex(130).setItemName("nameVesperCrystal");
		LanguageRegistry.addName(itemVesperCrystal, "Vesper Crystal");
		
		itemHazyDiamond = new RathItemsMaterials(rathHazyDiamondID).setIconIndex(131).setItemName("nameHazyDiamond");
		LanguageRegistry.addName(itemHazyDiamond, "Hazy Diamond");
		
		itemShimmerwoodLog = new RathItemsMaterials(rathShimmerwoodLogID).setIconIndex(80).setItemName("nameShimmerwoodLog");
		LanguageRegistry.addName(itemShimmerwoodLog, "Shimmerwood Log");
		
		itemMagmaCrystal = new RathItemsMaterials(rathMagmaCrystalID).setIconIndex(132).setItemName("nameMagmaCrystal");
		LanguageRegistry.addName(itemMagmaCrystal, "Magma Crystal");
		
		itemPhaseShard = new RathItemsMaterials(rathPhaseShardID).setIconIndex(133).setItemName("namePhaseShard");
		LanguageRegistry.addName(itemPhaseShard, "Phase Shard");
		
		itemCloudyLens = new RathItemsMaterials(rathCloudyLensID).setIconIndex(134).setItemName("nameCloudyLens");
		LanguageRegistry.addName(itemCloudyLens, "Cloudy Lens");
		
		itemCrystalLens = new RathItemsMaterials(rathCrystalLensID).setIconIndex(135).setItemName("nameCrystalLens");
		LanguageRegistry.addName(itemCrystalLens, "Crystal Lens");
		
		itemGazerTentacle = new RathItemsMaterials(rathGazerTentacleID).setIconIndex(136).setItemName("nameGazerTentacle");
		LanguageRegistry.addName(itemGazerTentacle, "Gazer Tentacle");
		
		itemGhastPearl = new RathItemsMaterials(rathGhastPearlID).setIconIndex(137).setItemName("nameGhastPearl");
		LanguageRegistry.addName(itemGhastPearl, "Ghast Pearl");
		
		itemFlickeringCord = new RathItemsMaterials(rathFlickeringCordID).setIconIndex(138).setItemName("nameFlickeringCord");
		LanguageRegistry.addName(itemFlickeringCord, "Flickering Cord");
		
		itemAbyssCrystal = new RathItemsMaterials(rathAbyssCrystalID).setIconIndex(143).setItemName("nameAbyssCrystal");
		LanguageRegistry.addName(itemAbyssCrystal, "Abyss Crystal");
		
		// Tools/Weapons
		itemVesperPickaxe = new ItemRathVesperPick(rathVesperPickaxeID, rathMaterialPick).setIconIndex(160).setItemName("nameVesperPick");
		LanguageRegistry.addName(itemVesperPickaxe, "Vesper Pickaxe");
		
		itemVesperSword = new ItemVesperSword(rathVesperSwordID, rathMaterialSword).setIconIndex(161).setItemName("nameVesperSword");
		LanguageRegistry.addName(itemVesperSword, "Vesper Sword");
		
		itemParticleBow = new ItemParticleBow(rathParticleBowID).setIconIndex(162).setItemName("nameParticleBow");
		LanguageRegistry.addName(itemParticleBow, "Particle Bow");
		
		itemMysticShot = new ItemMysticShot(rathMysticShotID).setIconIndex(163).setItemName("nameMysticShot");
		LanguageRegistry.addName(itemMysticShot, "Mystic Shot");
		
		itemBlazingShot = new ItemBlazingShot(rathBlazingShotID).setIconIndex(164).setItemName("nameBlazingShot");
		LanguageRegistry.addName(itemBlazingShot, "Blazing Shot");
		
		itemCryoShot = new ItemCryoShot(rathCryoShotID).setIconIndex(165).setItemName("nameCryoShot");
		LanguageRegistry.addName(itemCryoShot, "Cryo Shot");
		
		
		// Crafting Item Stacks
		ItemStack ISGold = new ItemStack(Item.ingotGold);
		ItemStack ISRedstone = new ItemStack(Item.redstone);
		ItemStack ISDiamond = new ItemStack(Item.diamond);
		ItemStack ISGlowstone = new ItemStack(Item.lightStoneDust);
		ItemStack ISMysticDust = new ItemStack(itemMysticDust);
		ItemStack ISPhaseShard = new ItemStack(itemPhaseShard);
		ItemStack ISGazerTentacle = new ItemStack(itemGazerTentacle);
		ItemStack ISEtherealDust = new ItemStack(itemEtherealDust);
		ItemStack ISHazyDiamond = new ItemStack(itemHazyDiamond);
		ItemStack ISShimmerwoodLog = new ItemStack(itemShimmerwoodLog);
		ItemStack ISVesperCrystal = new ItemStack(itemVesperCrystal);
		ItemStack ISMagmaCrystal = new ItemStack(itemMagmaCrystal);
		ItemStack ISGhastPearl = new ItemStack(itemGhastPearl);
		ItemStack ISAbyssCrystal = new ItemStack(itemAbyssCrystal);
		ItemStack ISGhastTear = new ItemStack(Item.ghastTear);
		
		// Ethereal Dust Recipe
		GameRegistry.addRecipe(new ItemStack(itemEtherealDust, 2), "mgm", "gmg", "mgm",
		        'm', ISMysticDust, 'g', ISGlowstone);
		
		// Vesper Crystal Recipe
		GameRegistry.addRecipe(new ItemStack(itemVesperCrystal), "mgr", "ede", "rgm",
		        'm', ISMysticDust, 'g', ISMagmaCrystal, 'r', ISRedstone, 'e', ISEtherealDust, 'd', ISHazyDiamond);
		
		// Flickering Cord Recipe
		GameRegistry.addRecipe(new ItemStack(itemFlickeringCord), "gpg", "mtm", "gpg",
		        'g', ISGlowstone, 'p', ISPhaseShard, 'm', ISMysticDust, 't', ISGazerTentacle);
		
		// Vesper Sword Recipe
				GameRegistry.addRecipe(new ItemStack(itemVesperSword), "eve", "mvm", " l ",
				        'e', ISEtherealDust, 'v', ISVesperCrystal, 'm', ISMysticDust, 'l', ISShimmerwoodLog);
				
		// Vesper Pickaxe Recipe
		GameRegistry.addRecipe(new ItemStack(itemVesperPickaxe), "vvv", "glg", " l ",
		        'g', ISGold, 'v', ISVesperCrystal, 'l', ISShimmerwoodLog);
		
		// Ghast Pearl Recipe
		GameRegistry.addRecipe(new ItemStack(itemGhastPearl), "ggg", "gdg", "ggg",
		        'g', ISGhastTear, 'd', ISDiamond);
		
		
		
		GameRegistry.registerWorldGenerator(new RathWorldGenerator());
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
