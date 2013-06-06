package net.richardsprojects.bukkit.apocalypse.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ApocalypseBlockEventListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onEventPlace(BlockPlaceEvent event) {
		if(event.isCancelled()) return;
		if(event.getPlayer().isOp()) {return;}else{
		
		if(event.getBlock().getType() == Material.TORCH) { 
			return;
			
		}else
		{event.setCancelled(true);
		event.getPlayer().sendMessage(ChatColor.GREEN + "You are only allowed to place torches.");
		}
		
		
	}}

}
