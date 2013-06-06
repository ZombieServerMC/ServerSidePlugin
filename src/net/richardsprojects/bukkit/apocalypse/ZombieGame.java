package net.richardsprojects.bukkit.apocalypse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import org.bukkit.entity.Player;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.HealthBar;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ZombieGame {
	
	public boolean getPlaying(String playerName) {

		File playerPlaying = new File("PlayerData" + File.separator + playerName + "-Playing.txt");
		if (playerPlaying.exists() == false) {
			return false;
		}else{
			try {
					Scanner scanner = new Scanner(playerPlaying);
				
					int result = 0;
					while(scanner.hasNextInt())
					{
						result = scanner.nextInt();
					}
				
					if(result == 0) {
						return false;
					}else{
						return true;
					}
			} catch(IOException e)  {
				return false;
			}
		
		}

	}
	
	public void setPlaying(String playerName, int value) {
		
		File playerPlaying = new File("PlayerData" + File.separator + playerName + "-Playing.txt");
		
		if (playerPlaying.exists() == false) {
	    	try {
				playerPlaying.createNewFile();
				PrintWriter writer = new PrintWriter(playerPlaying);
				writer.print(value);				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	    	
	    }else{
	    	try {
				PrintWriter writer = new PrintWriter(playerPlaying);				

				writer.print(value);
				
				writer.close();
			} catch (IOException e) {
			}
		
	    }
	}
	
	public void addDeath(String playerName) {
		
		File totalDeaths = new File("PlayerData" + File.separator + playerName + "-TotalDeaths.txt");
		if (totalDeaths.exists() == false) {
	    	try {
				totalDeaths.createNewFile();
				PrintWriter writer = new PrintWriter(totalDeaths);
				writer.print(1);				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	    	
	    }else{
	    	try {
	    		int value = 0;
	    		
				Scanner scanner = new Scanner(totalDeaths);
				while(scanner.hasNextInt())
				{
					value = scanner.nextInt();
				}
	    		
	    		int newvalue = value+1;
				
				PrintWriter writer = new PrintWriter(totalDeaths);				
				writer.print(newvalue);
				writer.close();
			} catch (IOException e) {
			}}
		
	    }
		
		public void addKill(String playerName) {
			
			File totalKills = new File("PlayerData" + File.separator + playerName + "-TotalKills.txt");
			if (totalKills.exists() == false) {
		    	try {
					totalKills.createNewFile();
					PrintWriter writer = new PrintWriter(totalKills);
					writer.print(1);				
					writer.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}	    	
		    }else{
		    	try {
		    		int value = 0;
		    		
					Scanner scanner = new Scanner(totalKills);
					while(scanner.hasNextInt())
					{
						value = scanner.nextInt();
					}
		    		
		    		int newvalue = value+1;
					
					PrintWriter writer = new PrintWriter(totalKills);				
					writer.print(newvalue);
					writer.close();
				} catch (IOException e) {
				}
			
		    }
		
	}
		
		public int totalKills(String playerName) {
			
			File totalKills = new File("PlayerData" + File.separator + playerName + "-TotalKills.txt");
			if (totalKills.exists() == false) {
		    	return 0;				    	
		    }else{
		    	try {
		    		int value = 0;
		    		
					Scanner scanner = new Scanner(totalKills);
					while(scanner.hasNextInt())
					{
						value = scanner.nextInt();
					}
					return value;
				} catch (IOException e) {
					return 0;
				}
			
		    }
		
	}
		
		public int totalDeaths(String playerName) {
			
			File totalDeaths = new File("PlayerData" + File.separator + playerName + "-TotalDeaths.txt");
			if (totalDeaths.exists() == false) {
		    	return 0;				    	
		    }else{
		    	try {
		    		int value = 0;
		    		
					Scanner scanner = new Scanner(totalDeaths);
					while(scanner.hasNextInt())
					{
						value = scanner.nextInt();
					}
					return value;
				} catch (IOException e) {
					return 0;
				}
			
		    }
		
	}
		
	public int getLevel(String playerName) {

		File playerLevel = new File("PlayerData" + File.separator + playerName + "-level.txt");
		if (playerLevel.exists() == false) {
			return 1;
		}else{
			try {
					Scanner scanner = new Scanner(playerLevel);
				
					int result = 0;
					while(scanner.hasNextInt())
					{
						result = scanner.nextInt();
					}
				
					return result;
			} catch(IOException e)  {
				return 1;
			}
		
		}

	}
	
	public void setLevel(String playerName, int value) {
		
		File playerLevel = new File("PlayerData" + File.separator + playerName + "-level.txt");
		
		if (playerLevel.exists() == false) {
	    	try {
				playerLevel.createNewFile();
				PrintWriter writer = new PrintWriter(playerLevel);
				writer.print(value);				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	    	
	    }else{
	    	try {
				PrintWriter writer = new PrintWriter(playerLevel);				

				writer.print(value);
				
				writer.close();
			} catch (IOException e) {
			}
		
	    }
	}
	
	public void setXP(String playerName, int value) {
		
		File playerLevel = new File("PlayerData" + File.separator + playerName + "-XP.txt");
		
		if (playerLevel.exists() == false) {
	    	try {
				playerLevel.createNewFile();
				PrintWriter writer = new PrintWriter(playerLevel);
				writer.print(value);				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	    	
	    }else{
	    	try {
				PrintWriter writer = new PrintWriter(playerLevel);				

				writer.print(value);
				
				writer.close();
			} catch (IOException e) {
			}
		
	    }
	}
	
	public int getXP(String playerName) {

		File playerLevel = new File("PlayerData" + File.separator + playerName + "-XP.txt");
		if (playerLevel.exists() == false) {
			return 0;
		}else{
			try {
					Scanner scanner = new Scanner(playerLevel);
				
					int result = 0;
					while(scanner.hasNextInt())
					{
						result = scanner.nextInt();
					}
				
					return result;
			} catch(IOException e)  {
				return 0;
			}
		
		}

	}
	
	public void updatePlayerUI(Apocalypse plugin, Player player)
	{
		int REQUIRED_XP = getLevel(player.getName()) * 12;
		SpoutPlayer splayer = (SpoutPlayer) player; // Cast it!
		int level = 0;
		int additionalLevels = 0;
		int playerXP = getXP(player.getName());
		
		//if(splayer.isSpoutCraftEnabled())
		//{
			splayer.getMainScreen().removeWidgets(plugin);

			if(playerXP >= REQUIRED_XP)
			{
				additionalLevels = 1;
				setXP(player.getName(), 0);
				playerXP = 0;
			}
			
			
			setLevel(player.getName(), getLevel(player.getName()) + additionalLevels);
			level = getLevel(player.getName());
			
			GenericLabel levelLabel = new GenericLabel();
			
			levelLabel.setText("Level: " + level);
			levelLabel.setX(0);
			levelLabel.setY(0);
			levelLabel.setHeight(1);
			
			GenericLabel xpLabel = new GenericLabel();
			
			xpLabel.setText("XP: " + playerXP + "/" + REQUIRED_XP);
			xpLabel.setX(0);
			xpLabel.setY(30);
			xpLabel.setHeight(1);
			
			GenericLabel hpLabel = new GenericLabel();
			HealthBar hpBar = splayer.getMainScreen().getHealthBar();
			
			
			hpLabel.setText("HP: 25/25");
			hpLabel.setX(hpBar.getX());
			hpLabel.setY(hpBar.getY());
			hpLabel.setHeight(hpBar.getHeight());
			hpBar.setVisible(false);
			
			splayer.getMainScreen().attachWidget(plugin, levelLabel);
			splayer.getMainScreen().attachWidget(plugin, xpLabel);
			splayer.getMainScreen().attachWidget(plugin, hpLabel);
			
		//}
	}
	
}
