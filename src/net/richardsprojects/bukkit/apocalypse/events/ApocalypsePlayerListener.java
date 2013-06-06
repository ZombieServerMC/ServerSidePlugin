package net.richardsprojects.bukkit.apocalypse.events;


import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.ThirstController;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class ApocalypsePlayerListener implements Listener{
	
@SuppressWarnings("unused")
private Apocalypse plugin;
protected ThirstController thirst;
	
	public ApocalypsePlayerListener(Apocalypse plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler (priority= EventPriority.NORMAL)
	public void onInteract (PlayerInteractEvent event) {
		thirst = new ThirstController();
		Player player = event.getPlayer();
			if ((event.getAction() == Action.RIGHT_CLICK_AIR)||(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if (player.getItemInHand().getType() == Material.POTION) {
					if (player.getItemInHand().getData().getData() == (byte) 0) {
						//if ((plugin.getConfig().getInt("thirst.bottle")+player.getLevel()) > 20) {
							thirst.Save(player.getPlayer().getName(), 20);
							player.setExp(1);
							player.sendMessage(ChatColor.AQUA + "Refreshing!");
						//} else {
							//player.setLevel(player.getLevel()+plugin.getConfig().getInt("thirst.bottle"));
						int itemSlot = player.getInventory().getHeldItemSlot();
						player.getInventory().setItem(itemSlot, new ItemStack(374));
						event.setCancelled(true);
					}
				}
			}
	}
}

