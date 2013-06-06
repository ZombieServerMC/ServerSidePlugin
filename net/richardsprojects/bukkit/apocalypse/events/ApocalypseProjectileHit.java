package net.richardsprojects.bukkit.apocalypse.events;




import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ApocalypseProjectileHit implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onProjectileHit(ProjectileHitEvent event) {
		if(event.getEntity() instanceof Egg) {
		org.bukkit.Location l = event.getEntity().getLocation();
		event.getEntity().getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 4f, false, false);
		}
	}

}
