package fancysaurus.eldritchAspirations.common.item.base;

import fancysaurus.eldritchAspirations.common.block.base.IModBlock;
import fancysaurus.eldritchAspirations.common.block.base.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.item.ItemBlock;

/**
 * Created by fancysaurus on 5/9/17.
 */
public class ItemModBlock extends ItemBlock implements IVarientHolder
{
    private IModBlock modBlock;

    public ItemModBlock(Block block) {
        super(block);
        modBlock = (IModBlock) block;

    }


    @Override
    public String[] getVarients()
    {
        return new String[0];
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition()
    {
        return null;
    }


}
