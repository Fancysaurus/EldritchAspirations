package fancysaurus.eldritchAspirations.common.item.base;

import fancysaurus.eldritchAspirations.common.block.base.IModBlock;
import fancysaurus.eldritchAspirations.common.block.base.ModBlock;
import fancysaurus.eldritchAspirations.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created by fancysaurus on 5/9/17.
 */
public class ItemModBlock extends ItemBlock implements IVarientHolder
{
    private IModBlock modBlock;

    public ItemModBlock(Block block) {
        super(block);
        modBlock = (IModBlock) block;
        ItemMod.variantHolders.add(this);
        if(getVarients().length > 1)
            setHasSubtypes(true);

    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        return (ItemBlock) super.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public String getUnlocalizedName(ItemStack stackIn) {
        int dmg = stackIn.getItemDamage();
        String[] variants = getVarients();

        String name;

        if(dmg >= variants.length)
            name = modBlock.getBareName();
        else
            name = variants[dmg];

        return "tile." + LibMisc.MOD_PREFIX + name;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        String[] variants = getVarients();
        for(int i = 0; i < variants.length; i++)
            if(modBlock.shouldDisplayVariants(i))
                subItems.add(new ItemStack(itemIn, 1, i));
    }

    @Override
    public String[] getVarients()
    {
        return modBlock.getVarients();
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return modBlock.getBlockRarity(stack);
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition()
    {
        return modBlock.getCustomMeshDefinition();
    }



}
