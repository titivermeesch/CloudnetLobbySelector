package me.playbosswar.cloudnetlobbyselector.events;

import de.dytanic.cloudnet.common.registry.IServicesRegistry;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.BridgePlayerManager;
import de.dytanic.cloudnet.ext.bridge.node.CloudNetBridgeModule;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import me.playbosswar.cloudnetlobbyselector.Main;
import me.playbosswar.cloudnetlobbyselector.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LobbySelectorClicks implements Listener {
    @EventHandler
    public void onLobbySelectorClick(InventoryClickEvent e) {
        Player p = (Player) e.getView().getPlayer();
        String inventoryName = ChatColor.stripColor(e.getView().getTitle());
        String configInventoryName = ChatColor.stripColor(Messages.color(Main.getInstance().getConfig().getString("inventoryName")));
        int inventorySize = e.getInventory().getSize();

        if(!inventoryName.equals(configInventoryName)) {
            return;
        }

        e.setCancelled(true);

        if(e.getSlot() == inventorySize - 1) {
            p.closeInventory();
            return;
        }

        String itemName = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
        CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class).getPlayerExecutor(p.getUniqueId()).connect(itemName);
        p.closeInventory();
    }
}
