package fancysaurus.eldritchAspirations.common.block.base;

import fancysaurus.eldritchAspirations.common.item.base.IVarientHolder;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by fancysaurus on 5/8/17.
 */
public interface IModBlock extends IVarientHolder
{
    public String getBareName();

    public IProperty getVarientProperty();

    public IProperty[] getIgnoredProperties();

    public EnumRarity getBlockRarity(ItemStack stackIn);

    public default boolean shouldDisplayVariants(int variants)
    {
        return true;
    }



}
