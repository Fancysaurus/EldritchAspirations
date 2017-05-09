package fancysaurus.eldritchAspirations.common.item.base;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by fancysaurus on 5/8/17.
 */
public interface IVarientHolder
{
    String[] getVarients();

    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition();

    public default String getUniqueModel()
    {
        return null;
    }

    public String getModNamespace();

    public default String getPrefix()
    {
        return getModNamespace() + ":";
    }
}
