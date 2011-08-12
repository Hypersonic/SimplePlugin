package aor.SimplePlugin;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import java.lang.String;

public class SpellBook {

	public static SimplePlugin plugin;

	public SpellBook(Player player, SimplePlugin instance) // We take player for possible permissions/op spell disable/enable.
	{
		plugin = instance;
		for(int i=0; i<plugin.spellList.size();i++){
			registerSpell(i);
		}
	}

	ArrayList<Integer> spellRegistry = new ArrayList<Integer>();

	public int index = 0;

	public Integer getSpell(String searchingShortName)
	{
		for (int i = 0; i < spellRegistry.size(); i++)
		{
			if (plugin.spellList.get(spellRegistry.get(i)).getShortName().equalsIgnoreCase(searchingShortName))
			{
				return spellRegistry.get(i);
			}
			else { }
		}
		return null;
	}
	public int getSpellIndex(String searchingShortName)
	{
		for (int i = 0; i < spellRegistry.size(); i++)
		{
			if (plugin.spellList.get(spellRegistry.get(i)).getShortName().equalsIgnoreCase(searchingShortName))
			{
				return i;
			}
			else { }
		}
		return spellRegistry.size() + 1;
	}
	public void registerSpells(ArrayList<Integer> spells){
		for(int i=0;i<spells.size();i++){
			registerSpell(spells.get(i));
		}
	}
	public void registerSpell(int sp){
		spellRegistry.add(sp);
	}

	public Integer returnFirstEntry()
	{
		return spellRegistry.get(0);
	}

	public Integer getCurrentSpell()
	{
		return spellRegistry.get(index);
	}
	
	public void setSpell(int setIndex)
	{
		index = setIndex;
	}
	
	public ChatColor spellFormat(int spell, Player player)
	{
		if (plugin.spellList.get(spell).checkInventoryRequirements(player.getInventory()))
		{
			return ChatColor.DARK_GREEN;
		}
		else
		{
			return ChatColor.DARK_RED;
		}
	}


	public int nextSpell(Player player)
	{
		if (index != spellRegistry.size() - 1) { index++; } // Remember indexes start at 0.
		else { index = 0; }
		
		if (plugin.spellList.get(getCurrentSpell()).checkInventoryRequirements(player.getInventory())) // If they have the right items...
		{
			player.sendMessage("Selected spell: " + ChatColor.DARK_GREEN + plugin.spellList.get(getCurrentSpell()).getName()); // Print spell with green.
		}
		else // If they don't.
		{
			player.sendMessage("Selected spell: " + ChatColor.DARK_RED + plugin.spellList.get(getCurrentSpell()).getName()); // Print spell with red.
		}
		
		
		return getCurrentSpell();
	}

}
