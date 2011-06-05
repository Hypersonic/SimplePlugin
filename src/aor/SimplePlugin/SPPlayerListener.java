package aor.SimplePlugin;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.World;
import aor.SimplePlugin.Spells.*;

public class SPPlayerListener extends PlayerListener {
	public static SimplePlugin plugin;

	public SPPlayerListener(SimplePlugin instance) {
		plugin = instance;
	}

	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		
		SimplePlugin.playerBooks.put(player.getName(), new SpellBook()); // Add a new spellbook for the player to the hashmap.
		
		
		SimplePlugin.playerBooks.get(player.getName()).registerSpell(new TestSpell()); // Register TestSpell.
		SimplePlugin.playerBooks.get(player.getName()).registerSpell(new TestSpell2()); // Register TestSpell2.
		
		
		
	}
	
	
	public void onPlayerInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer(); // Set the player object.
		SpellBook spellBook = SimplePlugin.playerBooks.get(player.getName());

		
		
		// Right clicking air or a block event:
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.GOLD_HOE) // If they right clicked with the gold hoe...
		{
			
			spellBook.getCurrentSpell().castSpell(player);

		}
		
		// Left clicking air or a block event:
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK && player.getItemInHand().getType() == Material.GOLD_HOE) // If they left clicked with the gold hoe.
		{
			
			spellBook.nextSpell(player); // Scroll through spells.
			
		}
	}

}