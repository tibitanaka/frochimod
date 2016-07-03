package jp.tibilabo.frochimod.block

import java.util.Random

import net.minecraft.block.{Block, BlockChest, BlockPistonBase}
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.World
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.{EntityLiving, EntityLivingBase}
import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.{TileEntityChest, TileEntityFurnace}
import net.minecraft.util.{IIcon, MathHelper}

/**
 * とっしゃん印のブロック。暗闇で光る。壊すとスイカになる。
 * Created by tibitanaka on 2016/05/29.
 */
class TosshanBlock(unlocalizedName:String) extends Block(Material.glass) {
  // SideOnlyの表示はクライアントモードのみで有効であることを示す
  var FrontIcon: IIcon = null
  var SideIcon: IIcon = null

  setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
  setBlockName(unlocalizedName);/*システム名の設定*/
  setHardness(1.5F);/*硬さ*/
  setResistance(1.0F);/*爆破耐性*/
  setStepSound(Block.soundTypeGlass);/*ブロックの上を歩いた時の音*/
  setLightLevel(1.0F);/*明るさ 1.0F = 15*/
  setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);/*当たり判定*/

  override def onBlockPlacedBy(world: World, i: Int, j: Int, k: Int, elb: EntityLivingBase, ist: ItemStack) = {
    // ブロック設置時の挙動を指定
    val l: Int = MathHelper.floor_double((elb.rotationYaw * 4.0F / 360.0F).toDouble + 0.5D) & 3
    var b: Int = 0
    l match {
      case 0 => b = 2
      case 1 => b = 5
      case 2 => b = 3
      case 3 => b = 4
    }
    world.setBlockMetadataWithNotify(i, j, k, b, 2)
  }
  @SideOnly(Side.CLIENT)
  override def registerBlockIcons(ir:IIconRegister): Unit = {
    this.FrontIcon = ir.registerIcon("frochimod:tosshan_block")
    this.SideIcon = ir.registerIcon("frochimod:tosshan_block_side")
  }
  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, meta:Int): IIcon = {
    if (meta == 0) if (side == 3) this.FrontIcon else this.SideIcon
    else
      if (side == 0 || side == 1)
        // side 0:bottom, 1:top, 2:north, 3:south, 4:west, 5:east
        this.SideIcon
      else
        // 向いている方向と同じ面のみ、異なるアイコンを表示させる
        if (side == meta) this.FrontIcon else this.SideIcon
  }
  override def getItemDropped(meta:Int, rm:Random, fortune:Int) :Item = {
    rm.nextInt(100) match {
      case 0 => Items.speckled_melon
      case r if 0 < r && r <= 20 => Items.melon
      case _ => null
    }
  }
}
