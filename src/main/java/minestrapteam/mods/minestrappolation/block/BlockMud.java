package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMud extends MBlock
{
	public BlockMud(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.5F;
		return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + f, pos.getZ() + 1);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (entityIn instanceof EntityPig || entityIn instanceof EntityPigZombie)
		{
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2, 1, true, false));
		}
		else
		{
			entityIn.setInWeb();
		}
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 4;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MItems.mud_ball;
	}
}
