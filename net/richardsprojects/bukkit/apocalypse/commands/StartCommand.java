package net.richardsprojects.bukkit.apocalypse.commands;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;
import net.richardsprojects.bukkit.apocalypse.ApocalypsePlayer;
import net.richardsprojects.bukkit.apocalypse.ThirstController;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;


public class StartCommand implements CommandExecutor{
	
	private Apocalypse plugin;
	
	protected ThirstController thirst;
	protected Apocalypse Apoc;
	
	
	
	public StartCommand(Apocalypse plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) {
			sender.sendMessage("This command can not be used from the console.");
			return true;
		}
		Apoc = new Apocalypse();
		thirst = new ThirstController();
		
	    PlayerInventory inventory = ((Player) sender).getPlayer().getInventory();
   
	    ItemStack myItem = new ItemStack(268);  //new item of item code
	    
	    ItemMeta im = myItem.getItemMeta();
	    
	    im.setDisplayName("Club");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add("1 Damage");
	    im.setLore(lore);
	    myItem.setItemMeta(im);
	    
	    int durability = 28;	    
	    myItem.setDurability((short)durability);
	    
	    ItemStack myItem2 = new ItemStack(344);
	    ItemMeta im2 = myItem2.getItemMeta();
	    

	    
	    
	    
	    im2.setDisplayName("Grenade");
	    ArrayList<String> lore2 = new ArrayList<String>();
	    lore2.add("DR: 4");
	    im2.setLore(lore2);
	    
	    myItem2.setItemMeta(im2);

	    inventory.clear();
	    inventory.addItem(myItem);
	    inventory.addItem(myItem2);
		
	    Player player = (Player) sender;
	    ApocalypsePlayer apocPlayer = new ApocalypsePlayer(player);
	    
	    apocPlayer.setPlaying(1);
	    
	    player.getPlayer().setLevel(0);
	    player.getPlayer().setExp(1);
	    
	    thirst.Save(player.getName(), 20);
	    
	    //Set the current the thirst level of the player
	    File PlayerThirst = new File("PlayerData" + File.separator + player.getPlayer().getName() + "-Thirst.txt");
	    
	    if (PlayerThirst.exists() == false) {
	    	try {
				PlayerThirst.createNewFile();
				try {
					PrintWriter writer = new PrintWriter(PlayerThirst);				
					writer.print(20);
					writer.close();			
				} catch (IOException e) {
					sender.sendMessage("DEBUG: File print failed.");
				}
			} catch (IOException e) {
                sender.sendMessage("DEBUG: File Creation failed.");
			}
	    }else{
	    	try {
				PrintWriter writer = new PrintWriter(PlayerThirst);				
				writer.print(20);
				writer.close();			
			} catch (IOException e) {
				sender.sendMessage("DEBUG: File print failed.");
			}				
		}
	    	
	    
	    /* Old System for keeping track of time alive - new one will be implemented soon
	    plugin.PlayerStartMilliseconds.put(player.getName(), System.currentTimeMillis());
	    plugin.PlayerSeconds.put(player.getName(), (long) 0);
	    plugin.PlayerMinutes.put(player.getName(), (long) 0);
	    plugin.PlayerHours.put(player.getName(), (long) 0);
	    
	    plugin.PlayerThirst.put(player.getName(), (long) 20);
	    */
   
	    World world = ((Player) sender).getServer().getWorld("world");
	    Location location = new Location(world, -72.27133342697881, 64.62, 184.36104621401566);
	    ((Player) sender).getPlayer().teleport(location);
	    
		return true;
	}

}

