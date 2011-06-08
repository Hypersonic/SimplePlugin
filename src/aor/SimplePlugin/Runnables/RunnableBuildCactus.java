package aor.SimplePlugin.Runnables;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class RunnableBuildCactus implements Runnable {

	public Block targetBlock;

	public RunnableBuildCactus (Block i_targetBlock)
	{
		targetBlock = i_targetBlock;
	}

	public void run()
	{
		targetBlock.setType(Material.CACTUS);
	}
}
