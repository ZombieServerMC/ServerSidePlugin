package net.richardsprojects.bukkit.apocalypse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
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
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Apocalypse extends JavaPlugin {
	
	public Apocalypse apocPlugin;
	
	public Logger logger = Logger.getLogger ("Minecraft");
	
	public Map<String, Long> PlayerStartMilliseconds = new HashMap<String, Long>();
	public Map<String, Long> PlayerLastMilliseconds = new HashMap<String, Long>();
	
	public Map<String, Long> PlayerThirst = new HashMap<String, Long>();
	public Map<String, Long> PlayerSeconds = new HashMap<String, Long>();
	public Map<String, Long> PlayerMinutes = new HashMap<String, Long>();
	public Map<String, Long> PlayerHours = new HashMap<String, Long>();
	protected Apocalypse Apoc;
	protected ThirstController thirst;
	protected ZombieGame game;
	
	public String pluginFolder() {
		return this.getDataFolder().getAbsolutePath();
	}
	
	public void onEnable() {
		(new File(pluginFolder())).mkdirs();
		
		PluginManager manager = this.getServer().getPluginManager();
		apocPlugin = this;
		
		manager.registerEvents(new ApocalypseBlockEventListener(), this);
		manager.registerEvents(new ApocalypsePlayerQuitListener(this), this);
		//manager.registerEvents(new PlayerJoinListener(this), this);
		manager.registerEvents(new ApocalypseEntityDeathListener(this), this);
		manager.registerEvents(new ApocalypsePlayerListener(this), this);
		manager.registerEvents(new ApocalypseEntityRegainHealth(), this);
		manager.registerEvents(new ApocalypseProjectileHit(), this);
		manager.registerEvents(new ApocalypseCreatureSpawnEvent(), this);
		manager.registerEvents(new ApocalypseCombustEvent(), this);
		manager.registerEvents(new ApocalypseOnRespawn(), this);
		manager.registerEvents(new ApocalypseSpoutListener(this), this);
		
		
		this.getCommand("start").setExecutor(new StartCommand(this));
		this.getCommand("timealive").setExecutor(new TimeAliveCommand(this));
		this.getCommand("credits").setExecutor(new CreditsCommand(this));
		this.getCommand("stats").setExecutor(new StatsCommand(this));
		
		thirst = new ThirstController();
		game = new ZombieGame();
		
		
		logger.info("[Apocalypse] Thirst is enabled.");
		Apoc = new Apocalypse();
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Player[] players = getServer().getOnlinePlayers();
				for (Player player : players) {
					if (player.getGameMode() == GameMode.SURVIVAL && game.getPlaying(player.getName()) == true) {
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
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Player[] players = getServer().getOnlinePlayers();
				for (Player player : players) {
					game.updatePlayerUI(apocPlugin, player);
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