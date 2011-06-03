package aor.SimplePlugin;

import org.bukkit.Location;
import org.bukkit.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author <yourname>
 */
public class SPPlayerListener extends PlayerListener {
    private final SimplePlugin plugin;

    public SPPlayerListener(SimplePlugin instance) {
        plugin = instance;
    }

    //Insert Player related code here
}
