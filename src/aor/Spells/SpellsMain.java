package aor.Spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;

import aor.Spells.Spells.*;
import aor.Spells.SpellBook;

public class SpellsMain extends JavaPlugin {
	public static final boolean selectPlayersFromADistance = true;
	static HashMap<String, SpellBook> playerBooks = new HashMap<String, SpellBook>();
	//ClassListeners
	private final SPPlayerListener playerListener = new SPPlayerListener(this);
	private final SPBlockListener blockListener = new SPBlockListener(this);
	private final SPVehicleListener vehicleListener = new SPVehicleListener(this);
	private final SPEntityListener entityListener = new SPEntityListener(this);
	private final SPWeatherListener weatherListener = new SPWeatherListener(this);
	public ArrayList<Spell> spellList = new ArrayList<Spell>();
	public ArrayList<Integer> spellOnBlockBreakList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockBurnList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockCanBuildList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockDamageList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockDispenceList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockFromToList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockIgniteList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockPhysicsList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockPlaceList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockRedstoneChangeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnLeavesDecayList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnSignChangeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnBlockFormList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnInventoryOpenList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnItemHeldChangeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerAnimationList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerBedEnterList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerBedLeaveList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerBucketEmptyList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerBucketFillList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerChatList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerDropItemList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerEggThrowList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerInteractList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerInteractEntityList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerJoinList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerKickList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerLoginList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerMoveList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerPickupItemList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerPortalList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerPreLoginList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerQuitList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerRespawnList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerTeleportList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPlayerToggleSneakList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnLightningStrikeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnThunderChangeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnWeatherChangeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleBlockCollisionList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleCreateList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleDamageList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleDestroyList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleEnterList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleEntityCollisionList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleExitList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnVehicleMoveList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnCreatureSpawnList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnCreeperPowerList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityCombustList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityDamageList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityDeathList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityExplodeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityInteractList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityPortalEnterList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityTameList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnEntityTargetList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnExplosionPrimeList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPaintingBreakList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPaintingPlaceList=new ArrayList<Integer>(0);
	public ArrayList<Integer> spellOnPigZapList=new ArrayList<Integer>(0);
	public ArrayList<Integer> playerSelect=new ArrayList<Integer>(0);
	public HashMap<String,String> selectedPlayerNames=new HashMap<String,String>();
	public Runner runner=new Runner(this);
	public boolean isDisabled=false;
	Logger log = Logger.getLogger("Minecraft");//Define your logger
	public HashMap<String,Animals> lastAnimal=new HashMap<String,Animals>();
	public HashMap<String,Arrow> lastArrow=new HashMap<String,Arrow>();
	public HashMap<String,Boat> lastBoat=new HashMap<String,Boat>();
	public HashMap<String,Chicken> lastChicken=new HashMap<String,Chicken>();
	public HashMap<String,Cow> lastCow=new HashMap<String,Cow>();
	public HashMap<String,Creature> lastCreature=new HashMap<String,Creature>();
	public HashMap<String,Creeper> lastCreeper=new HashMap<String,Creeper>();
	public HashMap<String,Egg> lastEgg=new HashMap<String,Egg>();
	public HashMap<String,Explosive> lastExplosive=new HashMap<String,Explosive>();
	public HashMap<String,FallingSand> lastFallingSand=new HashMap<String,FallingSand>();
	public HashMap<String,Fireball> lastFireball=new HashMap<String,Fireball>();
	public HashMap<String,Fish> lastFish=new HashMap<String,Fish>();
	public HashMap<String,Flying> lastFlying=new HashMap<String,Flying>();
	public HashMap<String,Ghast> lastGhast=new HashMap<String,Ghast>();
	public HashMap<String,Giant> lastGiant=new HashMap<String,Giant>();
	public HashMap<String,HumanEntity> lastHumanEntity=new HashMap<String,HumanEntity>();
	public HashMap<String,Item> lastItem=new HashMap<String,Item>();
	public HashMap<String,LivingEntity> lastLivingEntity=new HashMap<String,LivingEntity>();
	public HashMap<String,Entity> lastNotLivingEntity=new HashMap<String,Entity>();
	public HashMap<String,Minecart> lastMinecart=new HashMap<String,Minecart>();
	public HashMap<String,Monster> lastMonster=new HashMap<String,Monster>();
	public HashMap<String,Painting> lastPainting=new HashMap<String,Painting>();
	public HashMap<String,Pig> lastPig=new HashMap<String,Pig>();
	public HashMap<String,PigZombie> lastPigZombie=new HashMap<String,PigZombie>();
	public HashMap<String,Player> lastPlayer=new HashMap<String,Player>();
	public HashMap<String,PoweredMinecart> lastPoweredMinecart=new HashMap<String,PoweredMinecart>();
	public HashMap<String,Projectile> lastProjectile=new HashMap<String,Projectile>();
	public HashMap<String,Sheep> lastSheep=new HashMap<String,Sheep>();
	public HashMap<String,Skeleton> lastSkeleton=new HashMap<String,Skeleton>();
	public HashMap<String,Slime> lastSlime=new HashMap<String,Slime>();
	public HashMap<String,Snowball> lastSnowball=new HashMap<String,Snowball>();
	public HashMap<String,Spider> lastSpider=new HashMap<String,Spider>();
	public HashMap<String,Squid> lastSquid=new HashMap<String,Squid>();
	public HashMap<String,StorageMinecart> lastStorageMinecart=new HashMap<String,StorageMinecart>();
	public HashMap<String,TNTPrimed> lastTNTPrimed=new HashMap<String,TNTPrimed>();
	public HashMap<String,Vehicle> lastVehicle=new HashMap<String,Vehicle>();
	public HashMap<String,WaterMob> lastWaterMob=new HashMap<String,WaterMob>();
	public HashMap<String,Wolf> lastWolf=new HashMap<String,Wolf>();
	public HashMap<String,Zombie> lastZombie=new HashMap<String,Zombie>();
	public HashMap<String,ArrayList<Integer>> cooldowns=new HashMap<String,ArrayList<Integer>>();
	public void onDisable() {
		isDisabled=true;
		for(int i=0;i<spellList.size();i++){
			spellList.get(i).onDisable();
		}
		log.info("SimplePlugin disabled");
	}
	public void onEnable() {
		isDisabled=false;
		this.getServer().getScheduler().scheduleSyncDelayedTask(this,runner,0L);
		log.info("SimplePlugin enabling...");
		spellList.add(new RapidfireSpell(this)); // Register the rapidfire spell.
		spellList.add(new ExplosionSpell(this)); // Register explosion spell.
		spellList.add(new SpikeSpell(this));     //   .
		spellList.add(new SpikeWallSpell(this)); //   .
		spellList.add(new SpikeFortSpell(this)); //   .
		spellList.add(new Tornado(this));        //  etc.
		spellList.add(new NetSpell(this));
		spellList.add(new ExampleSpell(this));
		spellList.add(new ExampleSpell2(this));
		spellList.add(new MidasTouch(this));
		spellList.add(new DecoySpell(this));
		for(int i=0;i<spellList.size();i++)
		{
			final Spell spell = spellList.get(i);
			if(spell.onBlockBreak) spellOnBlockBreakList.add(i);
			if(spell.onBlockBurn) spellOnBlockBurnList.add(i);
			if(spell.onBlockCanBuild) spellOnBlockCanBuildList.add(i);		
			if(spell.onBlockDamage) spellOnBlockDamageList.add(i);
			if(spell.onBlockDispence) spellOnBlockDispenceList.add(i);
			if(spell.onBlockFromTo) spellOnBlockFromToList.add(i);
			if(spell.onBlockIgnite) spellOnBlockIgniteList.add(i);
			if(spell.onBlockPhysics) spellOnBlockPhysicsList.add(i);
			if(spell.onBlockPlace) spellOnBlockPlaceList.add(i);
			if(spell.onBlockRedstoneChange) spellOnBlockRedstoneChangeList.add(i);
			
			if(spell.onLeavesDecay) spellOnLeavesDecayList.add(i);
			if(spell.onSignChange) spellOnSignChangeList.add(i);
			if(spell.onBlockForm) spellOnBlockFormList.add(i);
			if(spell.onInventoryOpen) spellOnInventoryOpenList.add(i);
			if(spell.onItemHeldChange) spellOnItemHeldChangeList.add(i);
			
			if(spell.onPlayerAnimation) spellOnPlayerAnimationList.add(i);
			if(spell.onPlayerBedEnter) spellOnPlayerBedEnterList.add(i);
			if(spell.onPlayerBedLeave) spellOnPlayerBedLeaveList.add(i);
			if(spell.onPlayerBucketEmpty) spellOnPlayerBucketEmptyList.add(i);
			if(spell.onPlayerBucketFill) spellOnPlayerBucketFillList.add(i);
			if(spell.onPlayerChat) spellOnPlayerChatList.add(i);
			if(spell.onPlayerDropItem) spellOnPlayerDropItemList.add(i);
			if(spell.onPlayerEggThrow) spellOnPlayerEggThrowList.add(i);
			if(spell.onPlayerInteract) spellOnPlayerInteractList.add(i);
			if(spell.onPlayerInteractEntity) spellOnPlayerInteractEntityList.add(i);
			if(spell.onPlayerJoin) spellOnPlayerJoinList.add(i);
			if(spell.onPlayerKick) spellOnPlayerKickList.add(i);
			if(spell.onPlayerLogin) spellOnPlayerLoginList.add(i);
			if(spell.onPlayerMove) spellOnPlayerMoveList.add(i);
			if(spell.onPlayerPickupItem) spellOnPlayerPickupItemList.add(i);
			if(spell.onPlayerPortal) spellOnPlayerPortalList.add(i);
			if(spell.onPlayerPreLogin) spellOnPlayerPreLoginList.add(i);
			if(spell.onPlayerQuit) spellOnPlayerQuitList.add(i);
			if(spell.onPlayerRespawn) spellOnPlayerRespawnList.add(i);
			if(spell.onPlayerTeleport) spellOnPlayerTeleportList.add(i);
			if(spell.onPlayerToggleSneak) spellOnPlayerToggleSneakList.add(i);
			
			if(spell.onLightningStrike) spellOnLightningStrikeList.add(i);
			if(spell.onThunderChange) spellOnThunderChangeList.add(i);
			if(spell.onWeatherChange) spellOnWeatherChangeList.add(i);
			
			if(spell.onVehicleBlockCollision) spellOnVehicleBlockCollisionList.add(i);
			if(spell.onVehicleCreate) spellOnVehicleCreateList.add(i);
			if(spell.onVehicleDamage) spellOnVehicleDamageList.add(i);
			if(spell.onVehicleDestroy) spellOnVehicleDestroyList.add(i);
			if(spell.onVehicleEnter) spellOnVehicleEnterList.add(i);
			if(spell.onVehicleEntityCollision) spellOnVehicleEntityCollisionList.add(i);
			if(spell.onVehicleExit) spellOnVehicleExitList.add(i);
			if(spell.onVehicleMove) spellOnVehicleMoveList.add(i);
			
			if(spell.onCreatureSpawn) spellOnCreatureSpawnList.add(i);
			if(spell.onCreeperPower) spellOnCreeperPowerList.add(i);
			
			if(spell.onEntityCombust) spellOnEntityCombustList.add(i);
			if(spell.onEntityDamage) spellOnEntityDamageList.add(i);
			if(spell.onEntityDeath) spellOnEntityDeathList.add(i);
			if(spell.onEntityExplode) spellOnEntityExplodeList.add(i);
			if(spell.onEntityInteract) spellOnEntityInteractList.add(i);
			if(spell.onEntityPortalEnter) spellOnEntityPortalEnterList.add(i);
			if(spell.onEntityTame) spellOnEntityTameList.add(i);
			if(spell.onEntityTarget) spellOnEntityTargetList.add(i);
			
			if(spell.onExplosionPrime) spellOnExplosionPrimeList.add(i);
			if(spell.onPigZap) spellOnPigZapList.add(i);
			if(spell.playerSelect) playerSelect.add(i);
			
			if(spell.onPaintingBreak) spellOnPaintingBreakList.add(i);
			if(spell.onPaintingPlace) spellOnPaintingPlaceList.add(i);
		}
		final PluginManager pm = this.getServer().getPluginManager();
		//Custom recipe
		final ItemStack hoe = new ItemStack(Material.GOLD_HOE,1);
		final ShapedRecipe sceptre = new ShapedRecipe(hoe);
		sceptre.shape("123","456","789");
		// Set the ingredients for the custom crafting recipe
		sceptre.setIngredient('1', Material.STICK);
		sceptre.setIngredient('2', Material.GOLD_BLOCK);
		sceptre.setIngredient('3', Material.STICK);
		sceptre.setIngredient('5', Material.STICK);
		sceptre.setIngredient('8', Material.STICK);
		//Give it to the server. YEAAAH!
		this.getServer().addRecipe(sceptre);
		//Custom recipe
		// Register the listeners.
		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.INVENTORY_OPEN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_ITEM_HELD, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_ANIMATION, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_BED_ENTER, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_BED_LEAVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_BUCKET_EMPTY, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_BUCKET_FILL, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_CHAT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_DROP_ITEM, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_EGG_THROW, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_KICK, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_LOGIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_PICKUP_ITEM, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_PORTAL, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_PRELOGIN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_RESPAWN, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_TELEPORT, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_TOGGLE_SNEAK, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BURN, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_CANBUILD, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DISPENSE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_FROMTO, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.REDSTONE_CHANGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.LEAVES_DECAY, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.SIGN_CHANGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_FORM, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.LIGHTNING_STRIKE, weatherListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.THUNDER_CHANGE, weatherListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.WEATHER_CHANGE, weatherListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_COLLISION_BLOCK, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_CREATE, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_DAMAGE, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_DESTROY, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_ENTER, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_COLLISION_ENTITY, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_EXIT, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.VEHICLE_MOVE, vehicleListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CREATURE_SPAWN, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CREEPER_POWER, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_COMBUST, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DEATH, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_EXPLODE, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_INTERACT, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_PORTAL_ENTER, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_TAME, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_TARGET, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.EXPLOSION_PRIME, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PAINTING_BREAK, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PAINTING_PLACE, entityListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PIG_ZAP, entityListener, Event.Priority.Normal, this);
		// Register players, if any.
		final Player[] onlinePlayers = this.getServer().getOnlinePlayers();
		for (int i = 0; i < onlinePlayers.length; i++) // For every online players...
		{
			SpellsMain.playerBooks.put(onlinePlayers[i].getName(), new SpellBook(onlinePlayers[i], this)); // Add a new spellbook for the player to the hashmap.
		}
		log.info("Spells Alpha-0.01 enabled!");
		log.info("Please note that this is a development build of Spells, and, while mostly stable, is still in ALPHA. Please report all bugs at http://dev.bukkit.org/server-mods/spells/");
	}
	public HashMap<String, SpellBook> getPlayerBooks()
	{
		return SpellsMain.playerBooks;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("spellinfo")) // If the command was /spellinfo
		{
			if (sender instanceof Player) // If they're a player.
			{
				Player player = (Player)sender;
				if (args.length == 0) // They didn't give an arg.
				{
					if ((spellList.get(SpellsMain.playerBooks.get(player.getName()).getCurrentSpell())).checkInventoryRequirements(player.getInventory())) // If they have the materials.
					{
						sender.sendMessage("Current spell " + ChatColor.DARK_GREEN + "(" + spellList.get(SpellsMain.playerBooks.get(player.getName()).getCurrentSpell()).getName() + ")" + ChatColor.WHITE + ": " + spellList.get(SpellsMain.playerBooks.get(player.getName()).getCurrentSpell()).getDescription()); // Give them the current spell description in green.
					}
					else // If they don't...
					{
						sender.sendMessage("Current spell " + ChatColor.DARK_RED + "(" + spellList.get(SpellsMain.playerBooks.get(player.getName()).getCurrentSpell()).getName() + ")" + ChatColor.WHITE + ": " + spellList.get(SpellsMain.playerBooks.get(player.getName()).getCurrentSpell()).getDescription()); // Give them the current spell description in red.
					}
				}
				else if (SpellsMain.playerBooks.get(player.getName()).getSpell(args[0]) != null) // They gave an arg that matches a spel.
				{
					if (spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).checkInventoryRequirements(player.getInventory())) // If they have the materials...
					{
					sender.sendMessage(ChatColor.DARK_GREEN + spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).getName() + ChatColor.WHITE + ": " + spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).getDescription()); // Give them the spell description in green.
					}
					else // If they don't ...
					{
						sender.sendMessage(ChatColor.DARK_RED + spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).getName() + ChatColor.WHITE + ": " + spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).getDescription()); // Give them the spell description in red.
					}
				}
				else
				{
					sender.sendMessage("Invalid input!");
					return false;
				}
			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
			return true;
		} //If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
		else if (cmd.getName().equalsIgnoreCase("listspells")) // If the command was /listspells
		{
			if (sender instanceof Player) // If they're a player.
			{
				Player player = (Player)sender; // The player.
				SpellBook playerBook = SpellsMain.playerBooks.get(player.getName());
				ArrayList<Integer> spellRegistry = playerBook.spellRegistry; // The player's spell registry.
				sender.sendMessage("Currently available spells (arrow denotes selection):"); // Begin the list.
				for (int i = 0; i < spellRegistry.size(); i++) // Go through the spell registry...
				{
					if (spellRegistry.get(i) == playerBook.getCurrentSpell()) // If it's the current spell...
					{
						sender.sendMessage(playerBook.spellFormat(spellRegistry.get(i), player) + "   - " + spellList.get(spellRegistry.get(i)).getName() + " <--"); // Put the arrow.
						
					}
					else // If it's not the current spell.
					{
						sender.sendMessage(playerBook.spellFormat(spellRegistry.get(i), player) + "   - " + spellList.get(spellRegistry.get(i)).getName()); // Print with no arrow.
					}
				}
				sender.sendMessage("Key: " + ChatColor.DARK_GREEN + "(proper resources)" + ChatColor.DARK_RED + " (needs materials)");
			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("setspell")) // If the command was /setspell
		{
			if (sender instanceof Player) // If they're a player
			{
				Player player = (Player)sender; // The player.
				
				if (SpellsMain.playerBooks.get(player.getName()).getSpell(args[0]) != null) // If the argument was a spell...
				{
					SpellsMain.playerBooks.get(player.getName()).setSpell(SpellsMain.playerBooks.get(player.getName()).getSpellIndex(args[0]));
					sender.sendMessage("Set current spell to: " + SpellsMain.playerBooks.get(player.getName()).spellFormat(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0]), player) + spellList.get(SpellsMain.playerBooks.get(player.getName()).getSpell(args[0])).getName());
					return true;
				}
				else // The argument wasn't a spell.
				{
					sender.sendMessage("Invalid input!");
					return false;
				}
			}
			else { sender.sendMessage("This command can only be used in-game."); return false; } // They're not a player.
		}
		return false;
	}
	public static double distance(Location pos1,Location pos2){
		return Math.hypot(pos1.getY()-pos2.getY(), Math.hypot(pos1.getX()-pos2.getX(),pos1.getZ()-pos1.getZ()));
	}
}