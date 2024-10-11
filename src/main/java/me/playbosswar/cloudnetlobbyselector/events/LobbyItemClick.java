package me.playbosswar.cloudnetlobbyselector.events;

import me.playbosswar.cloudnetlobbyselector.Main;
import me.playbosswar.cloudnetlobbyselector.gui.LobbySelectorMenu;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
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

        if (item == null || item.getType().equals(Material.AIR) || item.getItemMeta() == null) {
            return;
        }

        FileConfiguration c = Main.getInstance().getConfig();
        int slot = c.getInt("joinItemSlot");

        if (e.getPlayer().getInventory().getHeldItemSlot() != slot) {
            return;
        }

        p.openInventory(LobbySelectorMenu.getLobbySelectorMenu(p));
    }
}
