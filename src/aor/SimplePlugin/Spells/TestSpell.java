package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;

public class TestSpell extends Spell {
	
	public TestSpell() // Constructor.
	{
		spellName = "TestSpell";
	}
	
	
	public void castSpell(Player player)
	{
		player.sendMessage("This is a test spell! YAAAY!");
	}
	
	
}
