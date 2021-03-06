package num.numirp.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import num.numirp.NumiRP;
import num.numirp.item.ModItems;
import num.numirp.lib.Metadata;
import num.numirp.lib.Reference;
import num.numirp.lib.Strings;

import java.util.List;
import java.util.Random;

public class BlockOres extends Block {

    public BlockOres(int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setCreativeTab(NumiRP.tabNRP);
        setUnlocalizedName("numirp.ore");

        MinecraftForge.setBlockHarvestLevel(this, 0, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(this, 1, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(this, 2, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(this, 3, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(this, 4, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(this, 5, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(this, 6, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(this, 7, "pickaxe", 2);
    }

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
        icons = new Icon[Strings.ORES.length];

        for (int i = 0; i < Strings.ORES.length; i++) {
            icons[i] = ir.registerIcon(Reference.TEXTURE_PATH + "ore" + Strings.ORES[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icons[meta];
    }

    @Override
    public int idDropped(int id, Random rand, int meta) {
        if ((id == Metadata.RUBY) || (id == Metadata.GREENSAPPHIRE) || (id == Metadata.SAPPHIRE)
                || (id == Metadata.NIKOLITE))
            return ModItems.itemProcessed.itemID;
        return this.blockID;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (meta == Metadata.NIKOLITE)
            return 4 + random.nextInt(2) + random.nextInt(fortune + 1); // same as RS
        if ((meta == Metadata.RUBY) || (meta == Metadata.GREENSAPPHIRE) || (meta == Metadata.SAPPHIRE)) {
            return random.nextInt(fortune + 1) + 1;
        }
        return 1;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs creativetab, List list) {
        for (int i = 0; i < Strings.ORES.length; i++) {
            list.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int id, float f, int meta) {
        super.dropBlockAsItemWithChance(world, x, y, z, id, f, meta);

        int xpAmount = 0;
        if ((meta == Metadata.RUBY) || (meta == Metadata.GREENSAPPHIRE) || (meta == Metadata.SAPPHIRE)) {
            xpAmount = MathHelper.getRandomIntegerInRange(world.rand, 2, 4);
        } else if (meta == Metadata.NIKOLITE) {
            xpAmount = MathHelper.getRandomIntegerInRange(world.rand, 1, 2);
        } else if (meta == Metadata.TUNGSTEN) {
            xpAmount = MathHelper.getRandomIntegerInRange(world.rand, 6, 8);
        } else {
            xpAmount = MathHelper.getRandomIntegerInRange(world.rand, 0, 1);
        }
        this.dropXpOnBlockBreak(world, x, y, z, xpAmount);

    }

}
