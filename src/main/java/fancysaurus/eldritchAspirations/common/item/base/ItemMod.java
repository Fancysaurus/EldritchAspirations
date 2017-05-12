package fancysaurus.eldritchAspirations.common.item.base;

import fancysaurus.eldritchAspirations.common.lib.LibMisc;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancysaurus on 5/9/17.
 */
public class ItemMod extends Item implements IVarientHolder
{
    public static final List<IVarientHolder> variantHolders = new ArrayList();

    private final String bareName;
    private final String[] variants;

    public ItemMod(String name, String... variants)
    {
        setUnlocalizedName(name);
        if(variants.length > 1)
            setHasSubtypes(true);

        if(variants.length  == 0)
            variants = new String[]{name};

        bareName = name;
        this.variants = variants;
        variantHolders.add(this);
    }

    @Override
    public Item setUnlocalizedName(String name)
    {
        super.setUnlocalizedName(name);
        GameRegistry.register(this, new ResourceLocation(LibMisc.MOD_PREFIX+name));
        return this;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int dmg = stack.getItemDamage();
        String[] variants = getVarients();

        String name;
        if(dmg >= variants.length)
            name = bareName;
        else
            name = variants[dmg];

        return "item." + LibMisc.MOD_PREFIX + name;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(int i = 0; i <getVarients().length; i++)
            subItems.add(new ItemStack(itemIn,1,i));
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
