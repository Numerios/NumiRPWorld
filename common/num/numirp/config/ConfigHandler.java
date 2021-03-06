package num.numirp.config;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;
import num.numirp.lib.*;

import java.io.File;
import java.util.logging.Level;

public class ConfigHandler {
    public static Configuration configuration;

    public static void init(File configFile) {
        Configuration conf = new Configuration(configFile);

        @SuppressWarnings("unused")
        String usedVersion;

        try {
            conf.load();
            usedVersion = conf.get("Version info", "VERSION INFO - Please do not change this", Reference.MOD_VERSION)
                    .getString();

            Module.LAMPS = conf.get("General", "LAMP MODULE (adding lamps to the game)", Module.LAMPS_DEFAULT).getBoolean(
                    Module.LAMPS_DEFAULT);
            Module.TOOLS = conf.get("General", "TOOL MODULE (adding gem tools and wool card to the game)", Module.TOOLS_DEFAULT).getBoolean(
                    Module.TOOLS_DEFAULT);
            Module.STORAGE = conf.get("General", "STORAGE MODULE (adding the storage blocks to the game - Copper Storage Block, Silver Storage Block, etc.)",
                    Module.STORAGE_DEFAULT).getBoolean(Module.STORAGE_DEFAULT);
            Module.ORES = conf.get("General", "ORES MODULE (adding ores to the game)", Module.ORES_DEFAULT).getBoolean(
                    Module.ORES_DEFAULT);
            Module.DECOR = conf.get("General", "DECOR MODULE (adding decorative blocks to the game - basalt, marble and their variants)",
                    Module.DECOR_DEFAULT).getBoolean(Module.DECOR_DEFAULT);
            Module.PROCESSED = conf.get("General", "PROCESSED MODULE (adding processed things to the game - all gems, ingots and dusts)", Module.PROCESSED_DEFAULT).getBoolean(
                    Module.PROCESSED_DEFAULT);
            Module.TURTLES = conf.get("General", "TURTLE MODULE (adding gem tools to turtles from computercraft) [dependent on tools - if tools is off, this is too!]",
                    Module.TURTLES_DEFAULT).getBoolean(Module.TURTLES_DEFAULT);

            WorldGen.WORLDGEN_RUBY = conf.get("World Generation", "Ruby Generation", WorldGen.WORLDGEN_RUBY_DEFAULT)
                    .getBoolean(WorldGen.WORLDGEN_RUBY_DEFAULT);
            WorldGen.WORLDGEN_GREENSAPPHIRE = conf.get("World Generation", "Green Sapphire Generation",
                    WorldGen.WORLDGEN_GREENSAPPHIRE_DEFAULT).getBoolean(WorldGen.WORLDGEN_GREENSAPPHIRE_DEFAULT);
            WorldGen.WORLDGEN_SAPPHIRE = conf.get("World Generation", "Sapphire Generation",
                    WorldGen.WORLDGEN_SAPPHIRE_DEFAULT).getBoolean(WorldGen.WORLDGEN_SAPPHIRE_DEFAULT);
            WorldGen.WORLDGEN_TIN = conf.get("World Generation", "Tin Generation", WorldGen.WORLDGEN_TIN_DEFAULT)
                    .getBoolean(WorldGen.WORLDGEN_TIN_DEFAULT);
            WorldGen.WORLDGEN_COPPER = conf.get("World Generation", "Copper Generation",
                    WorldGen.WORLDGEN_COPPER_DEFAULT).getBoolean(WorldGen.WORLDGEN_COPPER_DEFAULT);
            WorldGen.WORLDGEN_SILVER = conf.get("World Generation", "Silver Generation",
                    WorldGen.WORLDGEN_SILVER_DEFAULT).getBoolean(WorldGen.WORLDGEN_SILVER_DEFAULT);
            WorldGen.WORLDGEN_NIKOLITE = conf.get("World Generation", "Nikolite Generation",
                    WorldGen.WORLDGEN_NIKOLITE_DEFAULT).getBoolean(WorldGen.WORLDGEN_NIKOLITE_DEFAULT);
            WorldGen.WORLDGEN_TUNGSTEN = conf.get("World Generation", "Tungsten Generation",
                    WorldGen.WORLDGEN_TUNGSTEN_DEFAULT).getBoolean(WorldGen.WORLDGEN_TUNGSTEN_DEFAULT);
            WorldGen.WORLDGEN_MARBLE = conf.get("World Generation", "Marble Generation",
                    WorldGen.WORLDGEN_MARBLE_DEFAULT).getBoolean(WorldGen.WORLDGEN_MARBLE_DEFAULT);
            WorldGen.WORLDGEN_BASALT = conf.get("World Generation", "Basalt Generation",
                    WorldGen.WORLDGEN_BASALT_DEFAULT).getBoolean(WorldGen.WORLDGEN_BASALT_DEFAULT);

            ItemIDs.PICKAXE_RUBY_ID = conf.getItem("pickaxeRuby", ItemIDs.PICKAXE_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.PICKAXE_RUBY_ID_DEFAULT);
            ItemIDs.PICKAXE_GREEN_SAPPHIRE_ID = conf.getItem("pickaxeGreenSapphire",
                    ItemIDs.PICKAXE_GREEN_SAPPHIRE_ID_DEFAULT).getInt(ItemIDs.PICKAXE_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.PICKAXE_SAPPHIRE_ID = conf.getItem("pickaxeSapphire", ItemIDs.PICKAXE_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.PICKAXE_SAPPHIRE_ID_DEFAULT);

            ItemIDs.SHOVEL_RUBY_ID = conf.getItem("shovelRuby", ItemIDs.SHOVEL_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.SHOVEL_RUBY_ID_DEFAULT);
            ItemIDs.SHOVEL_GREEN_SAPPHIRE_ID = conf.getItem("shovelGreenSapphire",
                    ItemIDs.SHOVEL_GREEN_SAPPHIRE_ID_DEFAULT).getInt(ItemIDs.SHOVEL_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.SHOVEL_SAPPHIRE_ID = conf.getItem("shovelSapphire", ItemIDs.SHOVEL_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.SHOVEL_SAPPHIRE_ID_DEFAULT);

            ItemIDs.AXE_RUBY_ID = conf.getItem("axeRuby", ItemIDs.AXE_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.AXE_RUBY_ID_DEFAULT);
            ItemIDs.AXE_GREEN_SAPPHIRE_ID = conf.getItem("axeGreenSapphire", ItemIDs.AXE_GREEN_SAPPHIRE_ID_DEFAULT)
                    .getInt(ItemIDs.AXE_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.AXE_SAPPHIRE_ID = conf.getItem("axeSapphire", ItemIDs.AXE_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.AXE_SAPPHIRE_ID_DEFAULT);

            ItemIDs.SWORD_RUBY_ID = conf.getItem("swordRuby", ItemIDs.SWORD_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.AXE_RUBY_ID_DEFAULT);
            ItemIDs.SWORD_GREEN_SAPPHIRE_ID = conf.getItem("swordGreenSapphire",
                    ItemIDs.SWORD_GREEN_SAPPHIRE_ID_DEFAULT).getInt(ItemIDs.AXE_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.SWORD_SAPPHIRE_ID = conf.getItem("swordSapphire", ItemIDs.SWORD_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.AXE_SAPPHIRE_ID_DEFAULT);

            ItemIDs.HOE_RUBY_ID = conf.getItem("hoeRuby", ItemIDs.HOE_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.AXE_RUBY_ID_DEFAULT);
            ItemIDs.HOE_GREEN_SAPPHIRE_ID = conf.getItem("hoeGreenSapphire", ItemIDs.HOE_GREEN_SAPPHIRE_ID_DEFAULT)
                    .getInt(ItemIDs.HOE_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.HOE_SAPPHIRE_ID = conf.getItem("hoeSapphire", ItemIDs.HOE_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.AXE_SAPPHIRE_ID_DEFAULT);

            ItemIDs.SICKLE_WOODEN_ID = conf.getItem("sickleWooden", ItemIDs.SICKLE_WOODEN_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_WOODEN_ID_DEFAULT);
            ItemIDs.SICKLE_STONE_ID = conf.getItem("sickleStone", ItemIDs.SICKLE_STONE_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_STONE_ID_DEFAULT);
            ItemIDs.SICKLE_IRON_ID = conf.getItem("sickleIron", ItemIDs.SICKLE_IRON_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_IRON_ID_DEFAULT);
            ItemIDs.SICKLE_GOLDEN_ID = conf.getItem("sickleGolden", ItemIDs.SICKLE_GOLDEN_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_GOLDEN_ID_DEFAULT);
            ItemIDs.SICKLE_DIAMOND_ID = conf.getItem("sickleDiamond", ItemIDs.SICKLE_DIAMOND_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_DIAMOND_ID_DEFAULT);
            ItemIDs.SICKLE_RUBY_ID = conf.getItem("sickleRuby", ItemIDs.SICKLE_RUBY_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_RUBY_ID_DEFAULT);
            ItemIDs.SICKLE_GREEN_SAPPHIRE_ID = conf.getItem("sickleGreenSapphire",
                    ItemIDs.SICKLE_GREEN_SAPPHIRE_ID_DEFAULT).getInt(ItemIDs.SICKLE_GREEN_SAPPHIRE_ID_DEFAULT);
            ItemIDs.SICKLE_SAPPHIRE_ID = conf.getItem("sickleSapphire", ItemIDs.SICKLE_SAPPHIRE_ID_DEFAULT).getInt(
                    ItemIDs.SICKLE_SAPPHIRE_ID_DEFAULT);

            ItemIDs.ATHAME_ID = conf.getItem("athame", ItemIDs.ATHAME_ID_DEFAULT).getInt(ItemIDs.ATHAME_ID_DEFAULT);

            ItemIDs.WOOLCARD_ID = conf.getItem("woolcard", ItemIDs.WOOLCARD_ID_DEFAULT).getInt(
                    ItemIDs.WOOLCARD_ID_DEFAULT);

            ItemIDs.LUMAR_ID = conf.getItem("lumar", ItemIDs.LUMAR_ID_DEFAULT).getInt(ItemIDs.LUMAR_ID_DEFAULT);

            ItemIDs.PROCESSED_ID = conf.getItem("processed", ItemIDs.PROCESSED_ID_DEFAULT).getInt(
                    ItemIDs.PROCESSED_ID_DEFAULT);
            BlockIDs.ORES_ID = conf.getBlock("ores", BlockIDs.ORES_ID_DEFAULT).getInt(BlockIDs.ORES_ID_DEFAULT);
            BlockIDs.STORAGE_ID = conf.getBlock("storage blocks", BlockIDs.STORAGE_ID_DEFAULT).getInt(
                    BlockIDs.STORAGE_ID_DEFAULT);
            BlockIDs.DECOR_ID = conf.getBlock("decorative blocks (marble, basalt, etc.)", BlockIDs.DECOR_ID_DEFAULT)
                    .getInt(BlockIDs.DECOR_ID_DEFAULT);
            BlockIDs.LAMPS_NORMAL_ID = conf.getBlock("lampsNormalOff", BlockIDs.LAMPS_NORMAL_ID_DEFAULT).getInt(
                    BlockIDs.LAMPS_NORMAL_ID_DEFAULT);
            BlockIDs.LAMPS_NORMAL_ACTIVE_ID = conf.getBlock("lampsNormalOn", BlockIDs.LAMPS_NORMAL_ACTIVE_ID_DEFAULT)
                    .getInt(BlockIDs.LAMPS_NORMAL_ACTIVE_ID_DEFAULT);
            BlockIDs.LAMPS_INVERTED_ID = conf.getBlock("lampsInvertedOff", BlockIDs.LAMPS_INVERTED_ID_DEFAULT).getInt(
                    BlockIDs.LAMPS_INVERTED_ID_DEFAULT);
            BlockIDs.LAMPS_INVERTED_ACTIVE_ID = conf.getBlock("lampsInvertedOn",
                    BlockIDs.LAMPS_INVERTED_ACTIVE_ID_DEFAULT).getInt(BlockIDs.LAMPS_INVERTED_ACTIVE_ID_DEFAULT);

            conf.addCustomCategoryComment("Tweaks", "Do not change these unless you know what you're doing!");
            Tweaks.SICKLE_RANGE = conf.get("Tweaks", "Sickle range - 3 by default", Tweaks.SICKLE_RANGE_DEFAULT)
                    .getInt(Tweaks.SICKLE_RANGE_DEFAULT);
            Tweaks.TURTLE_UPGRADE_BASE = conf.get("Tweaks", "Turtle upgrade number (by default 4900)",
                    Tweaks.TURTLE_UPGRADE_BASE_DEFAULT).getInt(Tweaks.TURTLE_UPGRADE_BASE_DEFAULT);

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "Mod called " + Reference.MOD_NAME + " was unable to load its configs!");
        } finally {
            conf.save();
        }

    }
}
