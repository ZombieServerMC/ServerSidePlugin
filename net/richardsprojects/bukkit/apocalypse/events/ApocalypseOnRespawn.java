package net.richardsprojects.bukkit.apocalypse.events;


import net.richardsprojects.bukkit.apocalypse.ThirstController;
import net.richardsprojects.bukkit.apocalypse.ZombieGame;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class ApocalypseOnRespawn implements Listener{
	
	protected ThirstController thirst;
	protected ZombieGame game;
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onDeath (PlayerDeathEvent event) {
		game = new ZombieGame();
		thirst = new ThirstController();
		String playerName = event.getEntity().getName();
		event.setDroppedExp(0);
		event.getEntity().getLocation().getWorld().spawnEntity(event.getEntity().getLocation(),EntityType.ZOMBIE);
		game.addDeath(playerName);
	}
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onRespawn(final PlayerRespawnEvent event) {
		game = new ZombieGame();
		thirst = new ThirstController();
		String playerName = event.getPlayer().getName();
		game.setPlaying(playerName, 0);
		thirst.Save(playerName, 20);					
	}
}



