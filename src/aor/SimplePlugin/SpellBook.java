package aor.SimplePlugin;

import java.util.ArrayList;
import aor.SimplePlugin.Spell;
import org.bukkit.entity.Player;
import aor.SimplePlugin.Spells.*;

public class SpellBook {

	public static SimplePlugin plugin;

	public SpellBook(Player player, SimplePlugin instance) // We take player for possible permissions/op spell disable/enable.
	{
		plugin = instance;
		registerSpell(new BedrockLightningSpell(plugin)); // Register the bedrock spell.
		registerSpell(new RapidfireArrowSpell(plugin)); // Register the rapidfire arrow spell.
		registerSpell(new ExplosionSpell(plugin)); // Register explosion spell.
		registerSpell(new SpikeSpell(plugin));
	}

	ArrayList<Spell> spellRegistry = new ArrayList<Spell>();

	public int index = 0;
	
	public Spell getSpell(String searchingShortName)
	{
		for (int i = 0; i < spellRegistry.size(); i++)
		{
			if (spellRegistry.get(i).getShortName().equalsIgnoreCase(searchingShortName))
			{
				return spellRegistry.get(i);
			}
			else { }
		}
		return null;
	}
	
	public void registerSpell(Spell sp){
		spellRegistry.add(sp);
	}

	public Spell returnFirstEntry()
	{
		return spellRegistry.get(0);
	}

	public Spell getCurrentSpell()
	{
		return spellRegistry.get(index);
	}


	public Spell nextSpell(Player player)
	{
		if (index != spellRegistry.size() - 1) { index++; } // Remember indexes start at 0.
		else { index = 0; }
		player.sendMessage("Selected spell: " + getCurrentSpell().getName()); // Print Selected spell: (spell name)
		return getCurrentSpell();
	}

}
