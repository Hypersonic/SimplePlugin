package aor.SimplePlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.Material;
import aor.SimplePlugin.SpellBook;

public class SPPlayerListener extends PlayerListener {
	public static SimplePlugin plugin;

	public SPPlayerListener(SimplePlugin instance) {
		plugin = instance;
	}


	
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		SimplePlugin.playerBooks.put(player.getName(), new SpellBook(player, plugin)); // Add a new spellbook for the player to the hashmap.		
	}
	
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		SimplePlugin.playerBooks.remove(player.getName()); // Remove the player's spellbook from the hashmap.
	}
	
	
	public void onPlayerInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer(); // Set the player object.
		
		
		if (player.getItemInHand().getType() == Material.GOLD_HOE){
			event.setCancelled(true);	//Cancel the event. This only overrides the default gold hoe behavior, not calls to plugins.
		}
		
		// Left clicking air or a block event:
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.GOLD_HOE) // If they right clicked with the gold hoe...
		{
			SpellBook spellBook = SimplePlugin.playerBooks.get(player.getName());
			spellBook.getCurrentSpell().castSpell(player);
		}
		
		// Right clicking air or a block event:
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.GOLD_HOE) // If they left clicked with the gold hoe.
		{
			SpellBook spellBook = SimplePlugin.playerBooks.get(player.getName());
			spellBook.nextSpell(player); // Scroll through spells.
		}
	}
}