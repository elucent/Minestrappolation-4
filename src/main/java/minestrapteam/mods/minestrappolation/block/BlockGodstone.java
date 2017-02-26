package minestrapteam.mods.minestrappolation.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGodstone extends MBlock
{
	public BlockGodstone(Material material, MapColor mapColor)
	{
		super(material, mapColor);
		this.setLightLevel(1F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		world.scheduleUpdate(pos, this, 5);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			world.scheduleUpdate(pos, this, 5);
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(state, world, pos).expand(6, 6, 6);
			List<EntityMob> list = world.getEntitiesWithinAABB(EntityMob.class, axisalignedbb);
			for (EntityMob mob : list)
			{
				if (mob.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
				{
					mob.setFire(20);
				}
			}
		}
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return true;
	}
	
	@Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
        if (entity instanceof net.minecraft.entity.boss.EntityWither)
        {
            return false;
        }
        else if (entity instanceof net.minecraft.entity.boss.EntityDragon)
        {
            return false;
        }

        return true;
    }
}
