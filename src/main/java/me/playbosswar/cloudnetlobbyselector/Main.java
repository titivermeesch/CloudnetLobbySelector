package me.playbosswar.cloudnetlobbyselector;

import me.playbosswar.cloudnetlobbyselector.events.JoinItems;
import me.playbosswar.cloudnetlobbyselector.events.LobbyItemClick;
import me.playbosswar.cloudnetlobbyselector.events.LobbySelectorClicks;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();

       if(getConfig().getBoolean("giveItemOnJoin")) {
           getServer().getPluginManager().registerEvents(new JoinItems(), this);
           getServer().getPluginManager().registerEvents(new LobbyItemClick(), this);
           getServer().getPluginManager().registerEvents(new LobbySelectorClicks(), this);
       }
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Plugin getInstance() { return instance; }
}
