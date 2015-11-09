package rathuldrnether.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class RathWorldGenerator implements IWorldGenerator {

	// Mineral Rarities
	public static int dustCacheRarity = 50;
	public static int magmaCrystalRarity = 20;
	
	// Mineral Vein Sizes
	public static int dustCacheVein = 12;
	public static int magmaCrystalVein = 6;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.worldType)
		{
		case -1: 
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateNether(World world, Random random, int i, int j){
		
		// Generate Dust Cache
		for(int tries = 0; tries < dustCacheRarity; tries++){
			int NXCoord = i + random.nextInt(16);
			int NZCoord = j + random.nextInt(16);
			int NYCoord = random.nextInt(256);
			(new RathGenerateNether(RathuldrNether.blockDustCache.blockID, 0, dustCacheVein)).generate(world, random, NXCoord, NYCoord, NZCoord);
		}
		
		// Generate Molten Crystal
		for(int tries = 0; tries < magmaCrystalRarity; tries++){
			int NXCoord = i + random.nextInt(16);
			int NZCoord = j + random.nextInt(16);
			int NYCoord = random.nextInt(256);
			(new RathGenerateNether(RathuldrNether.blockRathSingleOres.blockID, 1, magmaCrystalVein)).generate(world, random, NXCoord, NYCoord, NZCoord);
		}
	}
}
