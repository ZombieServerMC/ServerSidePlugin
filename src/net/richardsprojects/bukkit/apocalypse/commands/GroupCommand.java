package net.richardsprojects.bukkit.apocalypse.commands;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GroupCommand implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Apocalypse plugin;
	
	protected Apocalypse Apoc;
	
	public GroupCommand(Apocalypse plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		return true;
	}
	
}