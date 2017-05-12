package fancysaurus.eldritchAspirations.common.block.base;

import fancysaurus.eldritchAspirations.common.item.base.ItemModBlock;
import fancysaurus.eldritchAspirations.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

        if(registerInConstruction())
            setUnlocalizedName(name);
    }

    @Override
    public Block setUnlocalizedName(String name)
    {
        super.setUnlocalizedName(name);
        setRegistryName(LibMisc.MOD_PREFIX + name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemModBlock(this),new ResourceLocation(LibMisc.MOD_PREFIX+name));
        return this;
    }

    public boolean registerInConstruction()
    {
        return true;
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
    public EnumRarity getBlockRarity(ItemStack stackIn)
    {
        return EnumRarity.COMMON;
    }

    @Override
    public String[] getVarients() {
        return variants;
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }
}
