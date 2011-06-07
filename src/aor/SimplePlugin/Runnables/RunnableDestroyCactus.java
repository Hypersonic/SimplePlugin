package aor.SimplePlugin.Runnables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class RunnableDestroyCactus implements Runnable {

	public Block targetBlock;
	public Material originalTargetMaterial;
	boolean sandstoneSupport = false;

	public RunnableDestroyCactus (Block i_targetBlock, Material i_originalTargetMaterial, boolean i_sandstoneSupport)
	{
		targetBlock = i_targetBlock;
		originalTargetMaterial = i_originalTargetMaterial;
		sandstoneSupport = i_sandstoneSupport;
	}

	public void run()
	{
		
		
		for (int i = 3; i >= 1; i--) // For each space above it
		{
			if (targetBlock.getRelative(0, i, 0).getType() == Material.CACTUS) // If they haven't built over it...
			{
				targetBlock.getRelative(0, i, 0).setType(Material.AIR); // Destroy cactus.
				targetBlock.getWorld().dropItemNaturally(targetBlock.getRelative(0, i, 0).getLocation(), new ItemStack(Material.CACTUS, 1));  // Drop a cactus item where it was.
			}
		}
		
		targetBlock.setType(originalTargetMaterial); // Revert the target block as well.
		
		if ((sandstoneSupport) && (targetBlock.getRelative(0, -1, 0).getType() == Material.SANDSTONE))
		{
			targetBlock.getRelative(0, -1, 0).setType(Material.AIR);
		}

	}
}
