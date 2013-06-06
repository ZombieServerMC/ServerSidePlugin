package net.richardsprojects.bukkit.apocalypse.commands;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreditsCommand implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Apocalypse plugin;
	
	protected Apocalypse Apoc;
	
	public CreditsCommand(Apocalypse plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) {
			sender.sendMessage("This command can not be used from the console.");
			return true;
		}
		
		sender.sendMessage("--------------------------");
		sender.sendMessage("Server Build: 1.0.0a");
		sender.sendMessage("");
		sender.sendMessage("Programming:");
		sender.sendMessage("Glorfindel22");
		sender.sendMessage("");
		sender.sendMessage("Map:");
		sender.sendMessage("Glorfindel22 & SnowBall520");
		sender.sendMessage("Banjo1997 & Coco_Man12");
		sender.sendMessage("--------------------------");
		
	    
	    
		return true;
	}

}

