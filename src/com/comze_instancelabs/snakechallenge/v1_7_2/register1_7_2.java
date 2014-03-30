package com.comze_instancelabs.snakechallenge.v1_7_2;

import java.lang.reflect.Field;
import java.util.HashMap;

import net.minecraft.server.v1_7_R1.EntityTypes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R1.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.comze_instancelabs.snakechallenge.Main;

public class register1_7_2 {
	public static boolean registerEntities(){
		
		try {
			Class entityTypeClass = EntityTypes.class;

			Field c = entityTypeClass.getDeclaredField("c");
			c.setAccessible(true);
			HashMap c_map = (HashMap) c.get(null);
			c_map.put("MESheep", MESheep1_7_2.class);

			Field d = entityTypeClass.getDeclaredField("d");
			d.setAccessible(true);
			HashMap d_map = (HashMap) d.get(null);
			d_map.put(MESheep1_7_2.class, "MESheep");

			Field e = entityTypeClass.getDeclaredField("e");
			e.setAccessible(true);
			HashMap e_map = (HashMap) e.get(null);
			e_map.put(Integer.valueOf(91), MESheep1_7_2.class);

			Field f = entityTypeClass.getDeclaredField("f");
			f.setAccessible(true);
			HashMap f_map = (HashMap) f.get(null);
			f_map.put(MESheep1_7_2.class, Integer.valueOf(91));

			Field g = entityTypeClass.getDeclaredField("g");
			g.setAccessible(true);
			HashMap g_map = (HashMap) g.get(null);
			g_map.put("MESheep", Integer.valueOf(91));

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static MESheep1_7_2 spawnSheep(Main m, String arena, Location t, final int color) {
		final Object w = ((CraftWorld) t.getWorld()).getHandle();
		final MESheep1_7_2 t_ = new MESheep1_7_2(m, arena, t, (net.minecraft.server.v1_7_R1.World) ((CraftWorld) t.getWorld()).getHandle());

		Bukkit.getScheduler().runTask(m, new Runnable(){
			public void run(){
				((net.minecraft.server.v1_7_R1.World) w).addEntity(t_, CreatureSpawnEvent.SpawnReason.CUSTOM);
				t_.setColor(color);
			}
		});
		
		return t_;
	}
}
