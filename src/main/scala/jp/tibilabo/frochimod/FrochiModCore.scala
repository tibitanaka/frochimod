package jp.tibilabo.frochimod

import net.minecraft.block.Block
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import jp.tibilabo.frochimod.block.TosshanBlock
import net.minecraft.block.material.Material
import net.minecraft.entity.passive.EntityWolf
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.{Item, ItemStack}

/**
 * Modコア
 * Created by tibitanaka on 2016/05/29.
 */
@Mod(modid="frochimod", name="FrochiMod", version="0.1.0")
class FrochiModCore {
  @EventHandler
  def preInit(event: FMLPreInitializationEvent) = {
    FrochiMod.tosshan_block = new TosshanBlock("tosshan_block")
    GameRegistry.registerBlock(FrochiMod.tosshan_block, "tosshan_block")
  }
  @EventHandler
  def init(event: FMLInitializationEvent) = {
    GameRegistry.addRecipe(new ItemStack(FrochiMod.tosshan_block.asInstanceOf[Block])
      ,"CCC"
      ,"BBB"
      ,"CCC"
      ,'C':Character, new ItemStack(Items.dye, 1, 3)
      ,'B':Character, Items.bone
    )
  }
}
