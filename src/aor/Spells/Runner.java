package aor.Spells;

import java.util.ArrayList;
import java.lang.Runnable;

public class Runner implements Runnable{
	public static SpellsMain plugin;
	public ArrayList<ArrayList<Object[]>> main=new ArrayList<ArrayList<Object[]>>(0);
	public ArrayList<ArrayList<Integer>> spellId=new ArrayList<ArrayList<Integer>>(0);
	public Runner(SpellsMain instance){
		plugin=instance;
	}
	public void run(){
		for(int i=0;i<plugin.playersWithCooldowns.size();i++){
			for(int i2=0;i2<plugin.cooldowns.get(plugin.playersWithCooldowns.get(i)).size();i2++){
				if(plugin.cooldowns.get(plugin.playersWithCooldowns.get(i)).get(i2)>0){
					plugin.cooldowns.get(plugin.playersWithCooldowns.get(i)).set(i2,plugin.cooldowns.get(plugin.playersWithCooldowns.get(i)).get(i2)-1);
				}
			}
		}
		if(main.size()==0){
			main.add(new ArrayList<Object[]>(0));
			spellId.add(new ArrayList<Integer>(0));
		}
		for(int i=0;i<main.get(0).size();i++){
			plugin.spellList.get(spellId.get(0).get(i)).run(main.get(0).get(i));
		}
		main.remove(0);
		spellId.remove(0);
		if(plugin.isDisabled){
			while(main.size()>0){
				for(int i=0;i<main.get(0).size();i++){
					plugin.spellList.get(spellId.get(0).get(i)).run(main.get(0).get(i));
				}
				main.remove(0);
			}
		}
		else{
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,this,1L);
		}
	}
}