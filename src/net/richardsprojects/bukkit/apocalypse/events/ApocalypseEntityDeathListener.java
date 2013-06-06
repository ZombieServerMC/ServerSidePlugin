package net.richardsprojects.bukkit.apocalypse.events;

import java.util.Random;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.ZombieGame;
import net.richardsprojects.bukkit.apocalypse.gui.Notification;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ApocalypseEntityDeathListener implements Listener{
	
	protected ZombieGame game;
	private Apocalypse plugin;
	
	public ApocalypseEntityDeathListener(Apocalypse plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onDeath(EntityDeathEvent event)
	{
		if ((LivingEntity)event.getEntity().getKiller() != null) {
			Random rangen = new Random();
			int xpCalculator = rangen.nextInt(2);
			int xpValue = 0;
		  
			game = new ZombieGame();

			Player killer = (Player)event.getEntity().getKiller();
			SpoutPlayer splayer = (SpoutPlayer) killer;
		      
			game.addKill(killer.getName());
		     
			event.setDroppedExp(0);
		     
			if(xpCalculator == 1)
			{
				xpValue = 3;
			}else{
				xpValue = 2;
			}
		      
			Notification notification = new Notification(xpValue + " XP!", 245, 184, 0, plugin, splayer);
			notification.display();
			
			
			game.setXP(killer.getName(), game.getXP(killer.getName()) + xpValue);
			game.updatePlayerUI(plugin, killer);
		}
	}
}
