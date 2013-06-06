package net.richardsprojects.bukkit.apocalypse.events;


import net.richardsprojects.bukkit.apocalypse.ApocalypsePlayer;
import net.richardsprojects.bukkit.apocalypse.ThirstController;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class ApocalypseOnRespawn implements Listener{
	
	protected ThirstController thirst;
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onDeath (PlayerDeathEvent event) {
		ApocalypsePlayer apocPlayer = new ApocalypsePlayer(event.getEntity());
		thirst = new ThirstController();
		String playerName = event.getEntity().getName();
		event.setDroppedExp(0);
		event.getEntity().getLocation().getWorld().spawnEntity(event.getEntity().getLocation(),EntityType.ZOMBIE);
		apocPlayer.addDeath();
	}
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onRespawn(final PlayerRespawnEvent event) {
		ApocalypsePlayer apocPlayer = new ApocalypsePlayer(event.getPlayer());
		thirst = new ThirstController();
		String playerName = event.getPlayer().getName();
		apocPlayer.setPlaying(0);
		thirst.Save(playerName, 20);					
	}
}



