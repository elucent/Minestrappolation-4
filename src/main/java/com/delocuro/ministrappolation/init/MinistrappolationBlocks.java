package com.delocuro.ministrappolation.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.delocuro.ministrappolation.Ministrappolation;
import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.blocks.BlockDefault;
import com.delocuro.ministrappolation.blocks.BlockMinistrappOre;
import com.delocuro.ministrappolation.blocks.BlockMinistrappolationContainer;
import com.delocuro.ministrappolation.blocks.BlockSunstoneBlock;
import com.delocuro.ministrappolation.blocks.BlockTransparent;
//import com.delocuro.ministrappolation.blocks.MinistrappolationContainer;

public class MinistrappolationBlocks {
	
	public static Block copper_ore;
	public static Block copper_block;
	public static Block tin_ore;
	public static Block tin_block;
	public static Block sunstone_ore;
	public static Block sunstone_block;
	public static Block glass_bricks;
	public static Block glass_refined;
	public static Block glass_tiles;
	public static Block glass_window;
	//public static Block crate;
	
	public static void init()
	{
		copper_ore = new BlockDefault(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_block = new BlockDefault(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_ore = new BlockDefault(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_block = new BlockDefault(Material.iron, MapColor.ironColor).setHardness(5.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Ministrappolation.tabMinistrappolation);
		sunstone_ore = new BlockMinistrappOre(Material.rock, MapColor.stoneColor).setHardness(2.8F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Ministrappolation.tabMinistrappolation);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Ministrappolation.tabMinistrappolation);
		glass_bricks = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_bricks").setCreativeTab(Ministrappolation.tabMinistrappolation);
		glass_refined = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_refined").setCreativeTab(Ministrappolation.tabMinistrappolation);
		glass_tiles = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_tiles").setCreativeTab(Ministrappolation.tabMinistrappolation);
		glass_window = new BlockTransparent(Material.iron, MapColor.airColor, false).setHardness(0.8F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setLightOpacity(2).setUnlocalizedName("glass_window").setCreativeTab(Ministrappolation.tabMinistrappolation);
		//crate = new BlockMinistrappolationContainer(0).setUnlocalizedName("crate").setCreativeTab(Ministrappolation.tabMinistrappolation);
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(copper_ore, copper_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(copper_block, copper_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tin_ore, tin_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tin_block, tin_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(sunstone_ore, sunstone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(sunstone_block, sunstone_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_bricks, glass_bricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_refined, glass_refined.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_tiles, glass_tiles.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_window, glass_window.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(copper_ore);
		registerRender(copper_block);
		registerRender(tin_ore);
		registerRender(tin_block);
		registerRender(sunstone_ore);
		registerRender(sunstone_block);
		registerRender(glass_bricks);
		registerRender(glass_refined);
		registerRender(glass_tiles);
		registerRender(glass_window);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerHarvestLevels()
	{
		copper_ore.setHarvestLevel("pickaxe", 0);
		copper_block.setHarvestLevel("pickaxe", 0);
		tin_ore.setHarvestLevel("pickaxe", 0);
		tin_block.setHarvestLevel("pickaxe", 0);
		sunstone_ore.setHarvestLevel("pickaxe", 2);
		glass_window.setHarvestLevel("pickaxe", 0);
	}
}
