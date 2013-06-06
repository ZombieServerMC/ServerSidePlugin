package net.richardsprojects.bukkit.apocalypse.gui;

import net.richardsprojects.bukkit.apocalypse.Apocalypse;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.WidgetAnim;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Notification{

	private static SpoutPlayer splayer;
	private static GenericLabel messageLabel;
	private static Apocalypse plugin;
	
	@SuppressWarnings("static-access")
	public Notification(String message, int colorR, int colorG, int colorB, Apocalypse plugin, SpoutPlayer splayer) {
		
		this.splayer = splayer;
		this.plugin = plugin;
		
		//Color for XP: 245.184.0 Label
		this.messageLabel = new GenericLabel();		 
		messageLabel.setText(message);
		messageLabel.setTextColor(new Color(colorR, colorG, colorB, 255));		
		messageLabel.setX(60);
		messageLabel.setY(120);
		
		
		short totalFrames = 40;
		short fpt = 1;
		
		messageLabel.animate(WidgetAnim.POS_Y, 60F, totalFrames, fpt, false, false);

	}
	
	public void display() {
		splayer.getMainScreen().attachWidget(plugin, messageLabel);
		messageLabel.animateStart();	
	}	

}
