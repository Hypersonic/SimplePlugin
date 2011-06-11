package aor.SimplePlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Runnable;

public class Runner implements Runnable{
	public static SimplePlugin plugin;
	public ArrayList<ArrayList<int[]>> main=new ArrayList<ArrayList<int[]>>(0);
	public Runner(SimplePlugin instance){
		plugin=instance;
	}
	public void run(){
		if(main.size()>0){
			//main.add(new ArrayList<int[]>(0));
			for(int i=0;i<main.get(0).size();i++){
				plugin.spellList.get(main.get(0).get(i)[0]).run(main.get(0).get(i)[1]);
			}
		}
		main.remove(0);
		if(plugin.isDisabled){
			while(main.size()>0){
				if(main.get(0)!=null){
					for(int i=0;i<main.get(0).size();i++){
						plugin.spellList.get(main.get(0).get(i)[0]).run(main.get(0).get(i)[1]);
					}
				}
				main.remove(0);
			}
		}
		else{
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,this,1L);
		}
	}
}