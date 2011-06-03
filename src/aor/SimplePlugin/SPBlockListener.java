package aor.SimplePlugin;
import org.bukkit.Block;
import org.bukkit.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * <pluginname> block listener
 * @author <yourname>
 */
public class SPBlockListener extends BlockListener {
    private final SimplePlugin plugin;

    public SPBlockListener(final SimplePlugin plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
