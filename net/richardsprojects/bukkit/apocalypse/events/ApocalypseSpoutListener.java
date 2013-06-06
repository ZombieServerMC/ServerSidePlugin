package net.richardsprojects.bukkit.apocalypse.events;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.ZombieGame;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spout.Spout;
import org.getspout.spout.listeners.SpoutPlayerListener;
import org.getspout.spoutapi.event.spout.ServerTickEvent;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ApocalypseSpoutListener implements Listener{

	private Apocalypse plugin;
	protected ZombieGame game;
	
	
    public ApocalypseSpoutListener(Apocalypse plugin) {
        this.plugin = plugin; 
    }
    
    @EventHandler
	public void onSpoutTickEvent(ServerTickEvent event){
    	Player[] players = plugin.getServer().getOnlinePlayers();
		for (Player player : players) {
				//game.updatePlayerUI(plugin, player);
		}
    }
}    