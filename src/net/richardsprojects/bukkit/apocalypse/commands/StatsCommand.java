package net.richardsprojects.bukkit.apocalypse.commands;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.ZombieGame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor{

	protected ZombieGame game;
	
	@SuppressWarnings("unused")
	private Apocalypse plugin;
	public StatsCommand(Apocalypse plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) {
			sender.sendMessage("This command can not be used from the console.");
			return true;
		}
		game = new ZombieGame();
		
		int totalKills = game.totalKills(sender.getName());
		int totalDeaths = game.totalDeaths(sender.getName());
		
		sender.sendMessage(sender.getName() + " Stats:");
		sender.sendMessage("Total Kills: " + totalKills);
		sender.sendMessage("Total Deaths: " + totalDeaths);
		
		return true;
	}

}
