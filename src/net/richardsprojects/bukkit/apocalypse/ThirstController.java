package net.richardsprojects.bukkit.apocalypse;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.bukkit.entity.Player;

public class ThirstController {
	
	public int Load(String playername) {
		
		File PlayerThirst = new File("PlayerData" + File.separator + playername + "-Thirst.txt");
		if (PlayerThirst.exists() == false) {
			return 21;
		}else{
			try {
				Scanner scanner = new Scanner(PlayerThirst);
				
				int result = 0;
				while(scanner.hasNextInt())
				{
					result = scanner.nextInt();
				}
				

				
				return result;
				
			} catch(IOException e)  {
				return 22;
			}
		}		
	}
	
	
	public boolean Save(String playername, int value) {
		
		File PlayerThirst = new File("PlayerData" + File.separator + playername + "-Thirst.txt");
		
			if (PlayerThirst.exists() == false) {
		    	return false;
		    }else{
		    	try {
					PrintWriter writer = new PrintWriter(PlayerThirst);				

					writer.print(value);
					writer.close();
					return true;
				} catch (IOException e) {
                    return false;
				}
		    	
	      }
	}

	public float Modify(String playerName, Player player) {
		
		int playerThirstLevel = Load(playerName);
		player.getPlayer().sendMessage("Thirst Level:" + playerThirstLevel);
			if (playerThirstLevel == 20) {
				Save(playerName, 19);
				return 0.95f;
				
			}
            if (playerThirstLevel == 19) {
				Save(playerName, 18);
				return 0.90f;
			}
            if (playerThirstLevel == 18) {
				Save(playerName, 17);
				return 0.85f;
			}
            if (playerThirstLevel == 17) {
				Save(playerName, 16);
				return 0.80f;
			}
            if (playerThirstLevel == 16) {
				Save(playerName, 15);
				return 0.75f;
			}
            if (playerThirstLevel == 15) {
				Save(playerName, 14);
				return 0.70f;
			}
            if (playerThirstLevel == 14) {
				Save(playerName, 13);
				return 0.65f;
			}
            if (playerThirstLevel == 13) {
				Save(playerName, 12);
				return 0.60f;
			}
            if (playerThirstLevel == 12) {
				Save(playerName, 11);
				return 0.55f;
			}
            if (playerThirstLevel == 11) {
				Save(playerName, 10);
				return 0.50f;
			}
            if (playerThirstLevel == 10) {
				Save(playerName, 9);
				return 0.45f;
			}if (playerThirstLevel == 9) {
				Save(playerName, 8);
				return 0.40f;
			}
            if (playerThirstLevel == 8) {
				Save(playerName, 7);
				return 0.35f;
			}
            if (playerThirstLevel == 7) {
				Save(playerName, 6);
				return 0.30f;
			}
            if (playerThirstLevel == 6) {
				Save(playerName, 5);
				return 0.25f;
			}
            if (playerThirstLevel == 5) {
				Save(playerName, 4);
				return 0.20f;
			}if (playerThirstLevel == 4) {
				Save(playerName, 3);
				return 0.15f;
			}
            if (playerThirstLevel == 3) {
				Save(playerName, 2);
				return 0.10f;
			}
            if (playerThirstLevel == 2) {
				Save(playerName, 1);
				return 0.05f;
			}
            if (playerThirstLevel == 1) {
				Save(playerName, 0);
				return 0.0f;
			}           
            return 0.00f;
            
			/*if (playerThirstLevel == 2) {
				player.sendMessage(ChatColor.YELLOW + "You are dieing of thirst!");
			}
			if (playerThirstLevel == 6) {
				player.sendMessage(ChatColor.YELLOW + "You are getting very thirsty.");
			}
			if (player.getExp() == 11) {
				player.sendMessage(ChatColor.YELLOW + "You are getting slightly thirsty.");
			}*/		
	}


	}


