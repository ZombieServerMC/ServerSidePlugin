package net.richardsprojects.bukkit.apocalypse.events;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ApocalypsePlayerQuitListener implements Listener {
	private Apocalypse plugin;
	
	public ApocalypsePlayerQuitListener(Apocalypse plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH)

	
	public void onEventQuit(PlayerQuitEvent event) {
		
	}

}	

