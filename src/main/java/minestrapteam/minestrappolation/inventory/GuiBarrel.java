package minestrapteam.minestrappolation.inventory;


import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiBarrel extends GuiContainer
{
	
 	private static final ResourceLocation texture = new ResourceLocation(MReference.MODID, "textures/gui/barrel.png");
	private TileEntityBarrel		barrel;
	
	public GuiBarrel(EntityPlayer player, TileEntityBarrel barrel)
	{
		super(new ContainerBarrel(player, barrel));
		this.barrel = barrel;
		this.ySize = 186;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Barrel"), 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 92, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
		// Bind the image texture of our custom container
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		// Draw the image
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}