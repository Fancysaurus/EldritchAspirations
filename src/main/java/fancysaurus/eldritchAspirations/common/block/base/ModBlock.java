package fancysaurus.eldritchAspirations.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;

/**
 * Created by fancysaurus on 5/8/17.
 */
public class ModBlock extends Block implements IModBlock
{
    private final String[] variants;
    private final String bareName;

    public ModBlock(String name, Material materialIn, String... variants)
    {
        super(materialIn);

        if(variants.length == 0)
            variants = new String[]{ name };

        bareName = name;
        this.variants = variants;
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public IProperty getVarientProperty() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public String[] getVarients() {
        return new String[0];
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }
}
