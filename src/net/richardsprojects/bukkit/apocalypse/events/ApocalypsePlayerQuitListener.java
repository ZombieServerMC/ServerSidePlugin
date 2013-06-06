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
	    Player player = (Player) event.getPlayer();
	    if(plugin.PlayerStartMilliseconds.containsKey(player.getName())){
		    long FirstDate = plugin.PlayerStartMilliseconds.get(player.getName());
			long difference = System.currentTimeMillis() - FirstDate;
			long difference_in_seconds = difference / 1000;
			plugin.PlayerStartMilliseconds.put(player.getName(), System.currentTimeMillis());
			
			long seconds = plugin.PlayerSeconds.get(player.getName());
			seconds = seconds + difference_in_seconds;
			plugin.PlayerSeconds.put(player.getName(), seconds);
		    }

		}

	}	

