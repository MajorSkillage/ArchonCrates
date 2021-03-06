package com.HamiStudios.ArchonCrates.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.HamiStudios.ArchonCrates.Files.FileHandler;
import com.HamiStudios.ArchonCrates.Util.FileType;

public class ListVKeys {

	public static void run(CommandSender sender) {
		ArrayList<String> keys = new ArrayList<>();
		for(String s : FileHandler.getFile(FileType.VIRTUAL_KEYS).getConfigurationSection("Virtual Keys").getKeys(false)) keys.add(s);
		
		StringBuilder sb = new StringBuilder();
		for(String s : keys) {
			if(s.equalsIgnoreCase(keys.get(keys.size()-1))) {
				sb.append(ChatColor.GRAY + s);
				continue;
			}
			sb.append(ChatColor.GRAY + s + ChatColor.YELLOW + ", ");
		}
		sender.sendMessage("");
		sender.sendMessage(ChatColor.GREEN + "" + ChatColor.UNDERLINE + "ArchonCrates Virtual Keys: ");
		sender.sendMessage("");
		sender.sendMessage(sb.toString());
		sender.sendMessage("");
	}
	
}
