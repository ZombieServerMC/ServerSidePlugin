package net.richardsprojects.bukkit.apocalypse.commands;

import java.util.concurrent.TimeUnit;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeAliveCommand implements CommandExecutor{
	
	private Apocalypse plugin;
	

	
	protected Apocalypse Apoc;

	
	
	public TimeAliveCommand(Apocalypse plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) {
			sender.sendMessage("Sorry this command can not be used from the console.");
			return true;
		}
		
		//Old System for implementing Time Alive - new one will be implemented soon
		//Apoc = new Apocalypse();
		//Player player = (Player) sender;
	    		
	    /*if(plugin.PlayerStartMilliseconds.containsKey(player.getName())){
	    long FirstDate = plugin.PlayerStartMilliseconds.get(player.getName());
		long difference = System.currentTimeMillis() - FirstDate;
		long difference_in_seconds = difference / 1000;
		plugin.PlayerStartMilliseconds.put(player.getName(), System.currentTimeMillis());
		
		long seconds = plugin.PlayerSeconds.get(player.getName());
		seconds = seconds + difference_in_seconds;
		plugin.PlayerSeconds.put(player.getName(), seconds);
		long currentseconds = plugin.PlayerSeconds.get(player.getName());

		
		sender.sendMessage(TimeUnit.SECONDS.toHours(currentseconds) % 24 + " hours " + TimeUnit.SECONDS.toMinutes(currentseconds) % 60 + " minutes " + currentseconds % 60 + " seconds");
			
	
		}else{sender.sendMessage("You have not started playing yet!");}	
		*/
	    

		return true;
	}

}
