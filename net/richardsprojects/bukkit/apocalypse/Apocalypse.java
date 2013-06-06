package net.richardsprojects.bukkit.apocalypse;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.commands.CreditsCommand;
import net.richardsprojects.bukkit.apocalypse.commands.StartCommand;
import net.richardsprojects.bukkit.apocalypse.commands.StatsCommand;
import net.richardsprojects.bukkit.apocalypse.commands.TimeAliveCommand;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseBlockEventListener;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseCombustEvent;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseCreatureSpawnEvent;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseEntityDeathListener;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseEntityRegainHealth;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseOnRespawn;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypsePlayerListener;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypsePlayerQuitListener;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseProjectileHit;
import net.richardsprojects.bukkit.apocalypse.events.ApocalypseSpoutListener;
import net.richardsprojects.bukkit.apocalypse.events.PlayerJoinListener;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Apocalypse extends JavaPlugin {
	
	public Apocalypse apocPlugin;
	public Logger logger = Logger.getLogger ("Minecraft");
	protected Apocalypse Apoc;
	protected ThirstController thirst;
	
	static //Hashmap to store if UI has already been loaded
	HashMap<String, Boolean> uiActive = new HashMap<String, Boolean>();
		
	public String pluginFolder() {
		return this.getDataFolder().getAbsolutePath();
	}
	
	public void onEnable() {
		(new File(pluginFolder())).mkdirs();
		
		PluginManager manager = this.getServer().getPluginManager();
		apocPlugin = this;
		
		//Register Events
		
		manager.registerEvents(new ApocalypseBlockEventListener(), this);
		manager.registerEvents(new ApocalypsePlayerQuitListener(this), this);
		manager.registerEvents(new PlayerJoinListener(this), this);
		manager.registerEvents(new ApocalypseEntityDeathListener(this), this);
		manager.registerEvents(new ApocalypsePlayerListener(this), this);
		manager.registerEvents(new ApocalypseEntityRegainHealth(), this);
		manager.registerEvents(new ApocalypseProjectileHit(), this);
		manager.registerEvents(new ApocalypseCreatureSpawnEvent(), this);
		manager.registerEvents(new ApocalypseCombustEvent(), this);
		manager.registerEvents(new ApocalypseOnRespawn(), this);
		manager.registerEvents(new ApocalypseSpoutListener(this), this);
		
		//Register Commands
		this.getCommand("start").setExecutor(new StartCommand(this));
		this.getCommand("timealive").setExecutor(new TimeAliveCommand(this));
		this.getCommand("credits").setExecutor(new CreditsCommand(this));
		this.getCommand("stats").setExecutor(new StatsCommand(this));
		
		//Initialize Classes
		thirst = new ThirstController();
	
		
		logger.info("[Apocalypse] Thirst is enabled.");
		
		Apoc = new Apocalypse();
		
		//Schedule task to reduce thirst
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Player[] players = getServer().getOnlinePlayers();
				for (Player player : players) {
					ApocalypsePlayer apocPlayer = new ApocalypsePlayer(player);
					if (player.getGameMode() == GameMode.SURVIVAL && apocPlayer.getPlaying() == true) {
						if (thirst.Load(player.getPlayer().getName()) == 21 || thirst.Load(player.getPlayer().getName()) == 22) {
							player.getPlayer().sendMessage("Error!");							
						}else{
							player.getPlayer().setExp(thirst.Modify(player.getPlayer().getName(), player));
							player.getPlayer().sendMessage("DEBUG: " + player.getExp());
						if (thirst.Load(player.getPlayer().getName()) == 2) {
							player.sendMessage(ChatColor.YELLOW + "You are dieing of thirst!");
						}
						if (thirst.Load(player.getPlayer().getName()) == 6) {
							player.sendMessage(ChatColor.YELLOW + "You are getting very thirsty.");
						}
						if (thirst.Load(player.getPlayer().getName()) == 11) {
							player.sendMessage(ChatColor.YELLOW + "You are getting slightly thirsty.");
						}
						}
						
					}
				}
			}
		}, 900, 900);
		
		//Schedule task to update player UI's when they first login
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				Player[] players = getServer().getOnlinePlayers();				
				for (Player player : players) {
					ApocalypsePlayer apocPlayer = new ApocalypsePlayer(player);
					if(Apocalypse.uiActive.get(player.getName()) != null) {
						
					}else{
						apocPlayer.updatePlayerUI(apocPlugin);
						player.sendMessage("DEBUG");
					}
				}
			}
		}, 1, 1);
		
		//Damage players who have are dehydrated.			
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Player[] players = getServer().getOnlinePlayers();
				for (Player player : players) {
						if (thirst.Load(player.getPlayer().getName()) == 0) {
							player.damage(1);
						}
				}
			}
		}, 40L, 20);

		//Remove any mobs in the world that are not Zombies	
		List<Entity> entities = getServer().getWorld("world").getEntities();
		for (Entity zombie : entities) {
			if (zombie instanceof Zombie) {
			}else{
				zombie.remove();
			}
			}

		return;
	}
	
	public void onDisable() {}
	
	
}