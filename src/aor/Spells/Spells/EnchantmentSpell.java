package aor.Spells.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Achievement;
import org.bukkit.Material;
import aor.Spells.SpellsMain;
import aor.Spells.Spell;

public class EnchantmentSpell extends Spell {

	public static SpellsMain plugin;
	int MAXDISTANCE = 50;

	public EnchantmentSpell(SpellsMain instance) // Constructor.
	{
		plugin = instance;
		spellName = "Enchantment";
		spellDescription = "Heals the target.";
		shortName = "Enchantment";


		setRequiredItems(new ItemStack(Material.STRING, 10)); // We need 10 string.
	}

	public void castSpell(Player player) {
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory)) {
			removeRequiredItemsFromInventory(inventory); // Remove the items.
			if ( plugin.lastPlayer.get(player.getName()) != null){
				Player target = plugin.lastPlayer.get(player.getName());
				target.setHealth(20);
				target.setPassenger(player);
				target.sendMessage("HEALATUDE!");
				player.sendMessage("HEALATUDE!");
			} else {
				player.sendMessage("Fail!");
			}
		player.setHealth(20);

		} else {
			player.sendMessage("Could not cast! Spell requires 10 string.");
		} // They don't have the proper items.

	}
}
