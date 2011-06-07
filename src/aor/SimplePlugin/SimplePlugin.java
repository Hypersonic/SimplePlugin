package aor.SimplePlugin;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import aor.SimplePlugin.SpellBook;



public class SimplePlugin extends JavaPlugin {


	static HashMap<String, SpellBook> playerBooks = new HashMap<String, SpellBook>();



	//ClassListeners
	private final SPPlayerListener playerListener = new SPPlayerListener(this);
	private final SPBlockListener blockListener = new SPBlockListener(this);
	//	private final SPPlayerListener entityListener = new SPPlayerListener(this);
	//ClassListeners

	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("SimplePlugin disabled");
	}

	public void onEnable() {
		log.info("SimplePlugin enabling...");
		PluginManager pm = this.getServer().getPluginManager();



		//Custom recipe
		ItemStack hoe = new ItemStack(Material.GOLD_HOE,1);
		ShapedRecipe sceptre = new ShapedRecipe(hoe);
		sceptre.shape("123","456","789");
		// Set the ingredients for the custom crafting recipe
		sceptre.setIngredient('1', Material.STICK);
		sceptre.setIngredient('2', Material.GOLD_BLOCK);
		sceptre.setIngredient('3', Material.STICK);
		sceptre.setIngredient('5', Material.STICK);
		sceptre.setIngredient('8', Material.STICK);

		//Give it to the server. YEAAAH!
		this.getServer().addRecipe(sceptre);
		//Custom recipe


		// Register the listeners.

		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);

		// Register players, if any.
		Player[] onlinePlayers = this.getServer().getOnlinePlayers();
		for (int i = 0; i < onlinePlayers.length; i++) // For every online players...
		{
			SimplePlugin.playerBooks.put(onlinePlayers[i].getName(), new SpellBook(onlinePlayers[i], this)); // Add a new spellbook for the player to the hashmap.
		}

		log.info("SimplePlugin enabled!");

	}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

		if(cmd.getName().equalsIgnoreCase("spellinfo")) // If the command was /spellinfo
		{
			if (sender instanceof Player) // If they're a player.
			{
				Player player = (Player)sender;
				if (args.length == 0) // They didn't give an arg.
				{
					if (SimplePlugin.playerBooks.get(player.getName()).getCurrentSpell().checkInventoryRequirements(player.getInventory())) // If they have the materials.
					{
						sender.sendMessage("Current spell " + ChatColor.DARK_GREEN + "(" + SimplePlugin.playerBooks.get(player.getName()).getCurrentSpell().getName() + ")" + ChatColor.WHITE + ": " + SimplePlugin.playerBooks.get(player.getName()).getCurrentSpell().getDescription()); // Give them the current spell description in green.
					}
					else // If they don't...
					{
						sender.sendMessage("Current spell " + ChatColor.DARK_RED + "(" + SimplePlugin.playerBooks.get(player.getName()).getCurrentSpell().getName() + ")" + ChatColor.WHITE + ": " + SimplePlugin.playerBooks.get(player.getName()).getCurrentSpell().getDescription()); // Give them the current spell description in red.
					}
				}
				else if (this.playerBooks.get(player.getName()).getSpell(args[0]) != null) // They gave an arg that matches a spel.
				{
					if (this.playerBooks.get(player.getName()).getSpell(args[0]).checkInventoryRequirements(player.getInventory())) // If they have the materials...
					{
					sender.sendMessage(ChatColor.DARK_GREEN + this.playerBooks.get(player.getName()).getSpell(args[0]).getName() + ChatColor.WHITE + ": " + this.playerBooks.get(player.getName()).getSpell(args[0]).getDescription()); // Give them the spell description in green.
					}
					else // If they don't ...
					{
						sender.sendMessage(ChatColor.DARK_RED + this.playerBooks.get(player.getName()).getSpell(args[0]).getName() + ChatColor.WHITE + ": " + this.playerBooks.get(player.getName()).getSpell(args[0]).getDescription()); // Give them the spell description in red.
					}
				}
				else
				{
					sender.sendMessage("Invalid input!");
					return false;
				}
			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
			return true;
		} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.


		else if (cmd.getName().equalsIgnoreCase("listspells")) // If the command was /listspells
		{
			if (sender instanceof Player) // If they're a player.
			{
				Player player = (Player)sender; // The player.
				SpellBook playerBook = SimplePlugin.playerBooks.get(player.getName());
				ArrayList<Spell> spellRegistry = playerBook.spellRegistry; // The player's spell registry.

				sender.sendMessage("Currently available spells (arrow denotes selection):"); // Begin the list.

				for (int i = 0; i < spellRegistry.size(); i++) // Go through the spell registry...
				{
					if (spellRegistry.get(i) == playerBook.getCurrentSpell()) // If it's the current spell...
					{
						sender.sendMessage(playerBook.spellFormat(spellRegistry.get(i), player) + "   - " + spellRegistry.get(i).getName() + " <--"); // Put the arrow.
						
					}
					else // If it's not the current spell.
					{
						sender.sendMessage(playerBook.spellFormat(spellRegistry.get(i), player) + "   - " + spellRegistry.get(i).getName()); // Print with no arrow.
						
					}
				}

				sender.sendMessage("Key: " + ChatColor.DARK_GREEN + "(proper resources)" + ChatColor.DARK_RED + " (needs materials)");

			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("setspell")) // If the command was /setspell
		{
			if (sender instanceof Player) // If they're a player
			{
				Player player = (Player)sender; // The player.
				
				if (this.playerBooks.get(player.getName()).getSpell(args[0]) != null) // If the argument was a spell...
				{
					this.playerBooks.get(player.getName()).setSpell(this.playerBooks.get(player.getName()).getSpellIndex(args[0]));
					sender.sendMessage("Set current spell to: " + this.playerBooks.get(player.getName()).spellFormat(this.playerBooks.get(player.getName()).getSpell(args[0]), player) + this.playerBooks.get(player.getName()).getSpell(args[0]).getName());
					return true;
				}
				else // The argument wasn't a spell.
				{
					sender.sendMessage("Invalid input!");
					return false;
				}
				

				
			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
		}
		
		

		return false; }



}