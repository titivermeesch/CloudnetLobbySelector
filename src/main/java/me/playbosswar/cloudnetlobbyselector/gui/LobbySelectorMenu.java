package me.playbosswar.cloudnetlobbyselector.gui;

import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import me.playbosswar.cloudnetlobbyselector.Main;
import me.playbosswar.cloudnetlobbyselector.utils.CloudnetHelpers;
import me.playbosswar.cloudnetlobbyselector.utils.ConfigTranslators;
import me.playbosswar.cloudnetlobbyselector.utils.Menus;
import me.playbosswar.cloudnetlobbyselector.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;

public class LobbySelectorMenu {
    public static Inventory getLobbySelectorMenu(Player p) {
        FileConfiguration c = Main.getInstance().getConfig();

        Collection<ServiceInfoSnapshot> servers = CloudnetHelpers.getServers(c.getString("cloudnetLobbyTaskName"));
        int serversAmount = servers.size();
        int inventorySize = (serversAmount + 8) / 9 * 9;
        if(inventorySize == 0) {
            inventorySize = 9;
        }

        Inventory inv = Bukkit.createInventory(p, inventorySize, Messages.color(c.getString("inventoryName")));

        ArrayList<ItemStack> lobbyItems = new ArrayList<>();

        for(ServiceInfoSnapshot server : servers) {
            ItemStack lobbyItem = ConfigTranslators.getItemFromConfig("inventoryItem");
            ItemMeta meta = lobbyItem.getItemMeta();
            meta.setDisplayName("§6§l" + server.getName());
            lobbyItem.setItemMeta(meta);
            lobbyItems.add(lobbyItem);
        }

        ArrayList<ItemStack> sorted = Menus.sortItemStacks(lobbyItems);

        int i = 0;
        for(ItemStack item : sorted) {
            inv.setItem(i, item);
            i++;
        }

        ItemStack closeItem = ConfigTranslators.getItemFromConfig("inventoryCloseItem");
        ItemMeta closeMeta = closeItem.getItemMeta();
        closeMeta.setDisplayName(Messages.color(c.getString("inventoryCloseText")));
        closeItem.setItemMeta(closeMeta);

        inv.setItem(inventorySize - 1, closeItem);
        return inv;
    }
}
