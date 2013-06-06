package net.richardsprojects.bukkit.apocalypse.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;


public class ApocalypseEntityRegainHealth implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
		public void onRegainHealth(EntityRegainHealthEvent event)
		{
			switch (event.getRegainReason()) {
			case SATIATED:
				event.setCancelled(true);
			
			default:

			}
		}
}
