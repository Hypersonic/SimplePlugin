// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Spell {
	
	public Spell() {} // Empty constructor.
	
	public String spellName;
	public String getName() { return spellName; }
	
//	public String spellDescription;
//	public String getDescription() { return spellDescription; }
	
	public void chargePlayer(Player player, int redstone, int ironingot, int goldingot, int coal) { } // TODO
	
	public String returnHello()
	{
		return "The spell is working!";
	}
	

	public void castSpell(Player player)
	{
		player.sendMessage("You're trying to cast a spell that's not set!");
	}
}
