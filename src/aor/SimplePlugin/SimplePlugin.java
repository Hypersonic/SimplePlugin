package aor.SimplePlugin;


import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;




public class SimplePlugin extends JavaPlugin {


	static HashMap<String, SpellBook> playerBooks = new HashMap<String, SpellBook>();



	//ClassListeners
	private final SPPlayerListener playerListener = new SPPlayerListener(this);
	private final SPBlockListener blockListener = new SPBlockListener(this);
	//	private final SPPlayerListener entityListener = new SPPlayerListener(this);
	//ClassListeners

	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("Disabled message here, shown in console on startup");
	}

	public void onEnable() {

		PluginManager pm = this.getServer().getPluginManager();


		// Register the listeners.

		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);



	}
	
	
/*	 public boolean onCommand(Player sender, Command cmd, String commandLabel, String[] args){
		 
		 if(cmd.getName().equalsIgnoreCase("basic")){ // If the player typed /basic then do the following...
		   sender.sendMessage("Your current spell is: " + sender.getName());
		   return true;
		 } //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
		 return false; }
*/

	
}