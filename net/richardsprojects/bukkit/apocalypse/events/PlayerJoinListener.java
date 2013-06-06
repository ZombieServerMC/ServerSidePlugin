package net.richardsprojects.bukkit.apocalypse.events;


import net.richardsprojects.bukkit.apocalypse.Apocalypse;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoinListener implements Listener{
	
	private Apocalypse plugin;

	public PlayerJoinListener(Apocalypse plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onEventJoin(PlayerJoinEvent event) {
	}
}

