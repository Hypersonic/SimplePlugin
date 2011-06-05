package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;

public class TestSpell2 extends Spell {
	
	public TestSpell2() // Constructor.
	{
		spellName = "TestSpell2";
	}
	
	public void castSpell(Player player)
	{
		player.sendMessage("Congratz! Test Spell 2!");
	}
	
	
}
