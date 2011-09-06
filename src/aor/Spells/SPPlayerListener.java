package aor.Spells;

import java.util.ArrayList;


import org.bukkit.entity.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import aor.Spells.SpellBook;

public class SPPlayerListener extends PlayerListener {
	public static SpellsMain plugin;

	public SPPlayerListener(SpellsMain instance) {
		plugin = instance;
	}

	public void onInventoryOpen(PlayerInventoryEvent event){
		for(int i=0;i<plugin.spellOnInventoryOpenList.size();i++){
			plugin.spellList.get(plugin.spellOnInventoryOpenList.get(i)).onInventoryOpen(event);
		}
	}
	public void onItemHeldChange(PlayerItemHeldEvent event){
		if (event.getPlayer().getInventory().getItem(event.getNewSlot()).getType() == Material.GOLD_HOE){
			if (plugin.spellList.get(SpellsMain.playerBooks.get(event.getPlayer().getDisplayName()).getCurrentSpell()).checkInventoryRequirements(event.getPlayer().getInventory())) // If they have the right items...
			{
				event.getPlayer().sendMessage("Selected spell: " + ChatColor.DARK_GREEN + plugin.spellList.get(SpellsMain.playerBooks.get(event.getPlayer().getDisplayName()).getCurrentSpell()).getName()); // Print spell with green.
			}
			else // If they don't.
			{
				event.getPlayer().sendMessage("Selected spell: " + ChatColor.DARK_RED + plugin.spellList.get(SpellsMain.playerBooks.get(event.getPlayer().getDisplayName()).getCurrentSpell()).getName()); // Print spell with red.
			}
		}
		for(int i=0;i<plugin.spellOnItemHeldChangeList.size();i++){
			plugin.spellList.get(plugin.spellOnItemHeldChangeList.get(i)).onItemHeldChange(event);
		}
	}
	public void onPlayerAnimation(PlayerAnimationEvent event){
		for(int i=0;i<plugin.spellOnPlayerAnimationList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerAnimationList.get(i)).onPlayerAnimation(event);
		}
	}
	public void onPlayerBedEnter(PlayerBedEnterEvent event){
		for(int i=0;i<plugin.spellOnPlayerBedEnterList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerBedEnterList.get(i)).onPlayerBedEnter(event);
		}
	}
	public void onPlayerBedLeave(PlayerBedLeaveEvent event){
		for(int i=0;i<plugin.spellOnPlayerBedLeaveList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerBedLeaveList.get(i)).onPlayerBedLeave(event);
		}
	}
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event){
		for(int i=0;i<plugin.spellOnPlayerBucketEmptyList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerBucketEmptyList.get(i)).onPlayerBucketEmpty(event);
		}
	}
	public void onPlayerBucketFill(PlayerBucketFillEvent event){
		for(int i=0;i<plugin.spellOnPlayerBucketFillList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerBucketFillList.get(i)).onPlayerBucketFill(event);
		}
	}
	public void onPlayerChat(PlayerChatEvent event){
		for(int i=0;i<plugin.spellOnPlayerChatList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerChatList.get(i)).onPlayerChat(event);
		}
	}
	public void onPlayerDropItem(PlayerDropItemEvent event){
		for(int i=0;i<plugin.spellOnPlayerDropItemList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerDropItemList.get(i)).onPlayerDropItem(event);
		}
	}
	public void onPlayerEggThrow(PlayerEggThrowEvent event){
		for(int i=0;i<plugin.spellOnPlayerEggThrowList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerEggThrowList.get(i)).onPlayerEggThrow(event);
		}
	}
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		if(event.getPlayer().getItemInHand().getType()==Material.GOLD_HOE){
			event.setCancelled(true);
			Entity entity=event.getRightClicked();
			if(entity instanceof LivingEntity){
				if(entity instanceof HumanEntity){
					plugin.lastHumanEntity.put(event.getPlayer().getDisplayName(),(HumanEntity)entity);
					if(entity instanceof Player){
						plugin.lastPlayer.put(event.getPlayer().getDisplayName(),(Player)entity);
					}
				}
				else if(entity instanceof Creature){
					plugin.lastCreature.put(event.getPlayer().getDisplayName(), (Creature)entity);
					if(entity instanceof WaterMob){
						plugin.lastWaterMob.put(event.getPlayer().getDisplayName(), (WaterMob)entity);
						if(entity instanceof Squid){
							plugin.lastSquid.put(event.getPlayer().getDisplayName(),(Squid)entity);
						}
					}
					else if(entity instanceof Animals){
						plugin.lastAnimal.put(event.getPlayer().getDisplayName(),(Animals)entity);
						if(entity instanceof Chicken){
							plugin.lastChicken.put(event.getPlayer().getDisplayName(),(Chicken)entity);
						}
						else if(entity instanceof Cow){
							plugin.lastCow.put(event.getPlayer().getDisplayName(),(Cow)entity);
						}
						else if(entity instanceof Pig){
							plugin.lastPig.put(event.getPlayer().getDisplayName(),(Pig)entity);
						}
						else if(entity instanceof Sheep){
							plugin.lastSheep.put(event.getPlayer().getDisplayName(),(Sheep)entity);
						}
						else if(entity instanceof Wolf){
							plugin.lastWolf.put(event.getPlayer().getDisplayName(),(Wolf)entity);
						}
					}
					else if(entity instanceof Monster){
						plugin.lastMonster.put(event.getPlayer().getDisplayName(), (Monster)entity);
						if(entity instanceof Zombie){
							plugin.lastZombie.put(event.getPlayer().getDisplayName(), (Zombie)entity);
							if(entity instanceof PigZombie){
								plugin.lastPigZombie.put(event.getPlayer().getDisplayName(),(PigZombie)entity);
							}
						}
						else if(entity instanceof Creeper){
							plugin.lastCreeper.put(event.getPlayer().getDisplayName(),(Creeper)entity);
						}
						else if(entity instanceof Giant){
							plugin.lastGiant.put(event.getPlayer().getDisplayName(),(Giant)entity);
						}
						else if(entity instanceof Skeleton){
							plugin.lastSkeleton.put(event.getPlayer().getDisplayName(),(Skeleton)entity);
						}
						else if(entity instanceof Spider){
							plugin.lastSpider.put(event.getPlayer().getDisplayName(),(Spider)entity);
						}
					}
					else if(entity instanceof Flying){
						plugin.lastFlying.put(event.getPlayer().getDisplayName(),(Flying)entity);
						if(entity instanceof Ghast){
							plugin.lastGhast.put(event.getPlayer().getDisplayName(),(Ghast)entity);
						}
					}
					else if(entity instanceof Slime){
						plugin.lastSlime.put(event.getPlayer().getDisplayName(),(Slime)entity);
					}
				}
				else{
					plugin.lastNotLivingEntity.put(event.getPlayer().getDisplayName(), entity);
					if(entity instanceof Projectile && !(entity instanceof Fireball)){
						plugin.lastProjectile.put(event.getPlayer().getDisplayName(),(Projectile)entity);
						if(entity instanceof Arrow){
							plugin.lastArrow.put(event.getPlayer().getDisplayName(),(Arrow)entity);
						}
						else if(entity instanceof Egg){
							plugin.lastEgg.put(event.getPlayer().getDisplayName(),(Egg)entity);
						}
						else if(entity instanceof Snowball){
							plugin.lastSnowball.put(event.getPlayer().getDisplayName(),(Snowball)entity);
						}
					}
					else if(entity instanceof Vehicle && !(entity instanceof Pig)){
						plugin.lastVehicle.put(event.getPlayer().getDisplayName(),(Vehicle)entity);
						if(entity instanceof Boat){
							plugin.lastBoat.put(event.getPlayer().getDisplayName(),(Boat)entity);
						}
						else if(entity instanceof Minecart){
							plugin.lastMinecart.put(event.getPlayer().getDisplayName(),(Minecart)entity);
						}
						else if(entity instanceof PoweredMinecart){
							plugin.lastPoweredMinecart.put(event.getPlayer().getDisplayName(),(PoweredMinecart)entity);
						}
						else if(entity instanceof StorageMinecart){
							plugin.lastStorageMinecart.put(event.getPlayer().getDisplayName(),(StorageMinecart)entity);
						}
					}
					else if(entity instanceof Explosive){
						plugin.lastExplosive.put(event.getPlayer().getDisplayName(),(Explosive)entity);
						if(entity instanceof Fireball){
							plugin.lastFireball.put(event.getPlayer().getDisplayName(),(Fireball)entity);
						}
						else if(entity instanceof TNTPrimed){
							plugin.lastTNTPrimed.put(event.getPlayer().getDisplayName(),(TNTPrimed)entity);
						}
					}
					else if(entity instanceof FallingSand){
						plugin.lastFallingSand.put(event.getPlayer().getDisplayName(),(FallingSand)entity);
					}
					else if(entity instanceof Item){
						plugin.lastItem.put(event.getPlayer().getDisplayName(),(Item)entity);
					}
					else if(entity instanceof Painting){
						plugin.lastPainting.put(event.getPlayer().getDisplayName(),(Painting)entity);
					}
				}
			}
		}
		for(int i=0;i<plugin.spellOnPlayerInteractEntityList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerInteractEntityList.get(i)).onPlayerInteractEntity(event);
		}
	}
	public void onPlayerKick(PlayerKickEvent event){
		for(int i=0;i<plugin.spellOnPlayerKickList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerKickList.get(i)).onPlayerKick(event);
		}
		
	}
	public void onPlayerLogin(PlayerLoginEvent event){
		for(int i=0;i<plugin.spellOnPlayerLoginList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerLoginList.get(i)).onPlayerLogin(event);
		}
	}
	public void onPlayerMove(PlayerMoveEvent event){
		for(int i=0;i<plugin.spellOnPlayerMoveList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerMoveList.get(i)).onPlayerMove(event);
		}
	}
	public void onPlayerPickupItem(PlayerPickupItemEvent event){
		for(int i=0;i<plugin.spellOnPlayerPickupItemList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerPickupItemList.get(i)).onPlayerPickupItem(event);
		}
	}
	public void onPlayerPortal(PlayerPortalEvent event){
		for(int i=0;i<plugin.spellOnPlayerPortalList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerPortalList.get(i)).onPlayerPortal(event);
		}
	}
	public void onPlayerPreLogin(PlayerPreLoginEvent event){
		for(int i=0;i<plugin.spellOnPlayerPreLoginList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerPreLoginList.get(i)).onPlayerPreLogin(event);
		}
	}
	public void onPlayerRespawn(PlayerRespawnEvent event){
		for(int i=0;i<plugin.spellOnPlayerRespawnList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerRespawnList.get(i)).onPlayerRespawn(event);
		}
	}
	public void onPlayerTeleport(PlayerTeleportEvent event){
		for(int i=0;i<plugin.spellOnPlayerTeleportList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerTeleportList.get(i)).onPlayerTeleport(event);
		}
	}
	public void onPlayerToggleSneak(PlayerToggleSneakEvent event){
		for(int i=0;i<plugin.spellOnPlayerToggleSneakList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerToggleSneakList.get(i)).onPlayerToggleSneak(event);
		}
	}
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		SpellsMain.playerBooks.put(player.getDisplayName(), new SpellBook(player, plugin)); // Add a new spellbook for the player to the hashmap.
		for(int i=0;i<plugin.spellOnPlayerJoinList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerJoinList.get(i)).onPlayerJoin(event);
		}
	}
	
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		SpellsMain.playerBooks.remove(player.getDisplayName()); // Remove the player's spellbook from the hashmap.
		for(int i=0;i<plugin.spellOnPlayerQuitList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerQuitList.get(i)).onPlayerQuit(event);
		}
	}
	
	
	public void onPlayerInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer(); // Set the player object.		
		
		if (player.getItemInHand().getType() == Material.GOLD_HOE){
			if(!plugin.cooldowns.containsKey(event.getPlayer().getDisplayName())){
				ArrayList<Integer> cooldowns=new ArrayList<Integer>(0);
				for(int i=0;i<plugin.spellList.size();i++){
					cooldowns.add(0);
				}
				plugin.playersWithCooldowns.add(event.getPlayer().getDisplayName());
			}
			event.setCancelled(true);	//Cancel the event. This only overrides the default gold hoe behavior, not calls to plugins.
		}
		
		// Left clicking air or a block event:
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.GOLD_HOE) // If they right clicked with the gold hoe...
		{

//			if(plugin.spellList.get(SpellsMain.playerBooks.get(player.getDisplayName()).getCurrentSpell()).playerSelect){
				SpellBook spellBook = SpellsMain.playerBooks.get(player.getDisplayName());
				plugin.spellList.get(spellBook.getCurrentSpell()).castSpell(player);
//			}
//			else{
//				SpellBook spellBook = SpellsMain.playerBooks.get(player.getDisplayName());
//				if(plugin.cooldowns.get(event.getPlayer()).get(spellBook.getCurrentSpell())==0){
//					if(plugin.spellList.get(spellBook.getCurrentSpell()).removeRequiredItemsFromInventory(event.getPlayer().getInventory())){
//						plugin.spellList.get(spellBook.getCurrentSpell()).castSpell(player);		//Cast the spell that is selected.
//						ArrayList<Integer> cooldowns = plugin.cooldowns.get(event.getPlayer().getDisplayName());
//						cooldowns.set(cooldowns.get(spellBook.getCurrentSpell()), plugin.spellList.get(spellBook.getCurrentSpell()).cooldown);
//						//TODO: Remove the spell remove item statements from all the spells.
//					}
//					else {
//						event.getPlayer().sendMessage(returnPrettySpellReqs(spellBook.getCurrentSpell()));
//					}
//				}
//				else{
//					if(plugin.spellList.get(spellBook.getCurrentSpell()).checkInventoryRequirements(event.getPlayer().getInventory())){
//						event.getPlayer().sendMessage(returnPrettySpellReqs(spellBook.getCurrentSpell()));
//					}
//					else{
//						event.getPlayer().sendMessage("You can't cast this spell yet, because you used it too recently. You can use it in "+plugin.cooldowns.get(event.getPlayer().getDisplayName()).get(spellBook.getCurrentSpell())/20+"seconds");
//					}
//				}
//			}
		}
		
		// Right clicking air or a block event:
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.GOLD_HOE) // If they left clicked with the gold hoe.
		{
			SpellBook spellBook = SpellsMain.playerBooks.get(player.getDisplayName());
			spellBook.nextSpell(player); // Scroll through spells.
		}
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.GOLD_HOE){
			
		}
		for(int i=0;i<plugin.spellOnPlayerInteractList.size();i++){
			plugin.spellList.get(plugin.spellOnPlayerInteractList.get(i)).onPlayerInteract(event);
		}
	}
	
	
	public String prettifyItemStack(ItemStack stack){
		String prettyfiedStackName = "";

		int size = stack.getAmount();
		boolean multiple = false;
		if (size > 1 && !stack.getType().name().endsWith("S")){			//More than 1 and doesn't end with "S"
			multiple = true;
		}
		String name = stack.getType().name().toLowerCase().replaceAll("_"," ");
		if (multiple == true) name += "s";	//weird with most items. We might need a list of items that aren't plural by default Q.Q
		
		
		prettyfiedStackName += size + " " + name;
		return prettyfiedStackName;
		
		
	}
	
	public String returnPrettySpellReqs(int spell){
		String prettySpellReqs = "You need ";
		
		ArrayList<ItemStack> requirements = plugin.spellList.get(spell).requiredItems;
		
		for (ItemStack itemNeeded:requirements){
			
			prettySpellReqs += prettifyItemStack(itemNeeded) + ", ";
			
		}
		
		prettySpellReqs = prettySpellReqs.trim(); 	//remove the trailing whitespace
		prettySpellReqs += ".";
		prettySpellReqs = prettySpellReqs.replace(",.", ".");
		
		return prettySpellReqs;
	}
	
	
	
}