package me.playbosswar.cloudnetlobbyselector.utils;

import me.playbosswar.cloudnetlobbyselector.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ConfigTranslators {
    public static List<String> getLoreFromConfig(String parentItem) {
        List<String> lore = new ArrayList<>();

        for(String s : Main.getInstance().getConfig().getStringList(parentItem)) {
            lore.add(Messages.color(s));
        }
        return lore;
    }

    public static ItemStack getItemFromConfig(String itemInConfig) {
        FileConfiguration c = Main.getInstance().getConfig();
        String[] configItem = c.getString(itemInConfig).split(":");

        Material type = Material.valueOf(configItem[0]);
        short colorCode = 0;

        if(configItem.length > 1) {
            colorCode = Short.parseShort(configItem[1]);
        }

        return new ItemStack(type, 1, colorCode);
    }
}
