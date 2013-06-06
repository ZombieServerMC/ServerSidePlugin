package net.richardsprojects.bukkit.apocalypse.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityCombustEvent;


public class ApocalypseCombustEvent implements Listener {
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onCombust (EntityCombustEvent event) {
				event.setCancelled(true);
				return;
			}

		
		}	

