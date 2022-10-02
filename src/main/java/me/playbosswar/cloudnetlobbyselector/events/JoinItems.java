package me.playbosswar.cloudnetlobbyselector.events;

import me.playbosswar.cloudnetlobbyselector.Main;
import me.playbosswar.cloudnetlobbyselector.utils.ConfigTranslators;
import me.playbosswar.cloudnetlobbyselector.utils.Messages;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        FileConfiguration c = Main.getInstance().getConfig();

        Player joinedPlayer = e.getPlayer();
        int slot = c.getInt("joinItemSlot");

        Material type = Material.valueOf(c.getString("joinItem"));
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Messages.color(c.getString("joinItemName")));
        meta.setLore(ConfigTranslators.getLoreFromConfig("joinItemLore"));
        item.setItemMeta(meta);

        joinedPlayer.getInventory().setItem(slot, new ItemStack(item));
    }
}
