package net.richardsprojects.bukkit.apocalypse.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;


public class ApocalypseCreatureSpawnEvent implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		LivingEntity entity = event.getEntity();
		
		if(entity.getType().getName() == "Zombie") {
			Random rangen = new Random();

			int r1 = rangen.nextInt(3);
			int r2 = rangen.nextInt(2);
			int r3 = rangen.nextInt(5);
			
			EntityEquipment ee = event.getEntity().getEquipment();
			if (r2 == 0) {
			ee.setHelmet(new ItemStack(Material.SKULL_ITEM, 1));
			}
			if (r3 == 0) {
			ee.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
			}
			if (r1 == 0) {
			ee.setItemInHand(new ItemStack(Material.WOOD_SWORD, 1));
			}
			//event.getEntity().setRemoveWhenFarAway(false);
			if (r2 == 0) {
			((Zombie) event.getEntity()).setVillager(true);
			}
		}else{
			event.setCancelled(true);
		}

		
		}	
}
