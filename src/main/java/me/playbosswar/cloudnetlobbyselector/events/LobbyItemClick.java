package me.playbosswar.cloudnetlobbyselector.events;

import me.playbosswar.cloudnetlobbyselector.gui.LobbySelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LobbyItemClick implements Listener {
    @EventHandler
    public void onToolbarClickEven(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        if(item == null || item.getType().equals(Material.AIR) || item.getItemMeta() == null) {
            return;
        }

        if(item.getItemMeta().getCustomModelData() == 56789876) {
            p.openInventory(LobbySelectorMenu.getLobbySelectorMenu(p));
        }
    }
}
