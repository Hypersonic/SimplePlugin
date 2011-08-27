package aor.Spells;

import java.util.ArrayList;
import java.lang.Runnable;

public class Runner implements Runnable{
	public static SimplePlugin plugin;
	public ArrayList<ArrayList<Object[]>> main=new ArrayList<ArrayList<Object[]>>(0);
	public ArrayList<ArrayList<Integer>> spellId=new ArrayList<ArrayList<Integer>>(0);
	public Runner(SimplePlugin instance){
		plugin=instance;
	}
	public void run(){
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