package me.playbosswar.cloudnetlobbyselector.utils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Menus {
    public static ArrayList<ItemStack> sortItemStacks (ArrayList<ItemStack> itemlist) {
        ArrayList<ItemStack> sortedItemlist = itemlist;
        for (int i = 0; i < sortedItemlist.size() - 1; i++) {
            for (int j = 1; j < sortedItemlist.size() - i; j++) {
                if (compare(sortedItemlist.get(j-1), sortedItemlist.get(j)) > 0) {
                    ItemStack temp = itemlist.get(j-1);
                    sortedItemlist.set(j-1, sortedItemlist.get(j));
                    sortedItemlist.set(j, temp);
                }
            }
        }
        return sortedItemlist;
    }

    private static int compare(ItemStack o1, ItemStack o2) {
        return (ChatColor.stripColor(o1.getItemMeta().getDisplayName())).compareTo(ChatColor.stripColor(o2.getItemMeta().getDisplayName()));
    }
}
