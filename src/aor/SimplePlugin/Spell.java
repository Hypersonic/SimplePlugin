// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.entity.Player;

public class Spell {
	
	public Spell() {} // Empty constructor.
	
	public String spellName;
	
	public String getName()
	{
		return spellName;
	}
	
	public String returnHello()
	{
		return "The spell is working!";
	}
	

	public void castSpell(Player player)
	{
		player.sendMessage("You're trying to cast a spell that's not set!");
	}
}
