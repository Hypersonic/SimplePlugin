package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;


public class FlameArrowSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public FlameArrowSpell() // Constructor.
	{
		spellName = "Flame Arrow";
//		spellDescription = "Shoots an arrow that sets stuff ON FIRE!";
	}
	
	
	public void castSpell(Player player)
	{
		player.sendMessage("This would send a flame arrow, but Herbie didn't code it.");
		
	}
	
	
}
