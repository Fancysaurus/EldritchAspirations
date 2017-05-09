package fancysaurus.eldritchAspirations.common.block.base;

import fancysaurus.eldritchAspirations.common.item.base.IVarientHolder;
import net.minecraft.block.properties.IProperty;

/**
 * Created by fancysaurus on 5/8/17.
 */
public interface IModBlock extends IVarientHolder
{
    public String getBareName();

    public IProperty getVarientProperty();

    public IProperty[] getIgnoredProperties();

    public default boolean shouldDisplayVariants()
    {
        return true;
    }

}
