package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.block.MStoneType;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IGuiHandler
{
	@Override
	public abstract Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z);
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deepstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:icestone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:glacierrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:red_rock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_redrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:oceanstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:pressurized_oceanstone");
		
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "biome_bricks");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deepstone_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:coldstone_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:icestone_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:glacierrock_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_coldstone_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:red_rock_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_redrock_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:oceanstone_bricks");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pressurized_oceanstone_bricks");
	}
	
	public void init(FMLInitializationEvent event)
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "biome_bricks");
		
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deepstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":coldstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.COLDSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":icestone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.ICESTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":glacierrock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.GLACIERSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_coldstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPCOLDSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":red_rock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.REDROCK.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_redrock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPREDROCK.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":oceanstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.OCEANSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":pressurized_oceanstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.POCEANSTONE.getMetadata(), itemModelResourceLocation);
		
		//Bricks
		ModelResourceLocation itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":deepstone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.DEEPSTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":coldstone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.COLDSTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":icestone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.ICESTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":glacierrock_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.GLACIERSTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_coldstone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.DEEPCOLDSTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":red_rock_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.REDROCK.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_redrock_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.DEEPREDROCK.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":oceanstone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.OCEANSTONE.getMetadata(), itemModelBrickResourceLocation);
		
		itemModelBrickResourceLocation = new ModelResourceLocation(MReference.MODID + ":pressurized_oceanstone_bricks", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBrickVariants, MStoneType.POCEANSTONE.getMetadata(), itemModelBrickResourceLocation);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	public boolean isClient()
	{
		return false;
	}
	
	public void openGUI(Object gui)
	{
		
	}
	
	public void registerRenders()
	{
		
	}
}
