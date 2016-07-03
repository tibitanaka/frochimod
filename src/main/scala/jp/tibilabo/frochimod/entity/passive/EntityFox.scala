package jp.tibilabo.frochimod.entity.passive

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.{Block, BlockColored}
import net.minecraft.entity.{Entity, EntityAgeable, EntityLivingBase, SharedMonsterAttributes}
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAIOwnerHurtTarget, EntityAITargetNonTamed, _}
import net.minecraft.entity.monster.{EntityCreeper, EntityGhast}
import net.minecraft.entity.passive._
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityArrow
import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemFood, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.pathfinding.PathEntity
import net.minecraft.util.{DamageSource, MathHelper}
import net.minecraft.world.World

/**
  * Created by tibitanaka on 2016/06/28.
  */
class EntityFox(world:World) extends EntityWolf(world) {
}
