package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockHangingMoss extends Block {

	public static final PropertyBool BOTTOM = PropertyBool.create("bottom");
	private int	flammability;
	
	public BlockHangingMoss(int flame, SoundType sound)
	{
		super(Material.VINE);
		setDefaultState(blockState.getBaseState().withProperty(BOTTOM, Boolean.valueOf(false)));
		this.setTickRandomly(true);
		this.flammability = flame;
		this.blockSoundType=sound;
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        return state.withProperty(BOTTOM, Boolean.valueOf(block != this));
    }
	
	public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BOTTOM});
    }
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState blockstate)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		if(this == MBlocks.hanging_moss)
		{
			if(worldIn.getBlockState(pos.up()).getBlock() == Blocks.STONE || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.biome_stones || worldIn.getBlockState(pos.up()).getBlock() == Blocks.DIRT || worldIn.getBlockState(pos.up()).getBlock() == Blocks.MYCELIUM || worldIn.getBlockState(pos.up()).getBlock() == Blocks.GRASS_PATH || worldIn.getBlockState(pos.up()).getBlock() == Blocks.LEAVES || worldIn.getBlockState(pos.up()).getBlock() == Blocks.LEAVES2 || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.ministrapp_leaves || worldIn.getBlockState(pos.up()).getBlock() == this)
			{
				int yCheck = pos.getY() - 1;
				BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
				boolean outcome = false;
				for(boolean isChecking = true ; isChecking == true ;)
				{
					if(worldIn.getBlockState(pos1).getBlock() == this)
					{
						yCheck --;
						pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
						isChecking = true;
					}
					else if(worldIn.getBlockState(pos1).getBlock() == Blocks.AIR)
					{
						outcome = true;
						isChecking = false;
					}
					else
					{
						outcome = false;
						isChecking = false;
					}
				}
				return outcome;
			}
			else
			{
				return false;
			}
		}
		else if(this == MBlocks.hanging_glow_moss)
		{
			if(worldIn.getBlockState(pos.up()).getBlock() == Blocks.NETHERRACK || worldIn.getBlockState(pos.up()).getBlock() == Blocks.SOUL_SAND || worldIn.getBlockState(pos.up()).getBlock() == Blocks.GLOWSTONE || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.glow_mossy_netherrack || worldIn.getBlockState(pos.up()).getBlock() == Blocks.END_STONE || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.glow_mossy_end_stone || worldIn.getBlockState(pos.up()).getBlock() == this)
			{
				int yCheck = pos.getY() - 1;
				BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
				boolean outcome = false;
				for(boolean isChecking = true ; isChecking == true ;)
				{
					if(worldIn.getBlockState(pos1).getBlock() == this)
					{
						yCheck --;
						pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
						isChecking = true;
					}
					else if(worldIn.getBlockState(pos1).getBlock() == Blocks.AIR)
					{
						outcome = true;
						isChecking = false;
					}
					else
					{
						outcome = false;
						isChecking = false;
					}
				}
				return outcome;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
    }
	
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)    
    {
		this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canBlockStay(worldIn, pos))
        {
            return true;
        }
        else
        {
        	worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        	this.dropBlockAsItem(worldIn, pos, state, 0);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	
        if (this.checkForDrop(worldIn, pos, state))
        {
            if (this.canBlockStay(worldIn, pos.down()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.up(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 15)
                {
                    if (rand.nextInt(Config.seaweedGrowChance) == 0)
                    {
                        worldIn.setBlockState(pos.down(), this.getDefaultState());
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
    
    @Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
    
    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
        if (entity instanceof net.minecraft.entity.boss.EntityDragon && this == MBlocks.hanging_glow_moss)
        {
            return false;
        }

        return true;
    }
}