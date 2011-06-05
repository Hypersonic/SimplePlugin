// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.entity.Player;

public class Spell {
	
	public Spell() {} // Empty constructor.
	
	public String spellName;
	public String getName() { return spellName; }
	
	public String spellDescription;
	public String getDescription() { return spellDescription; }
	
	
	public String returnHello()
	{
		return "The spell is working!";
	}
	
	public boolean checkRequirements(Player player) { return true; } // Checks if player has the proper requirements for the spell.
	

	public void castSpell(Player player)
	{
		player.sendMessage("You're trying to cast a spell that's not set!");
	}
}
