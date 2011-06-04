package aor.SimplePlugin;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;

public class TestSpell extends Spell {
	
	public void castSpell(Player player)
	{
		player.sendMessage("This is a test spell! YAAAY!");
	}
	
	
}
