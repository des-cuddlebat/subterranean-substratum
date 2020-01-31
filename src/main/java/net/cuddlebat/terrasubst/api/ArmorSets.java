package net.cuddlebat.terrasubst.api;

import java.util.HashMap;
import java.util.Map;

import net.cuddlebat.terrasubst.api.ArmorSetMaterial;

public final class ArmorSets
{
	private static final Map<String, ArmorSetMaterial> TO   = new HashMap<>();
	private static final Map<ArmorSetMaterial, String> FROM = new HashMap<>();
	
	private ArmorSets()
	{
	}
	
	public static void register(String id, ArmorSetMaterial mat)
	{
		TO.put(id, mat);
		FROM.put(mat, id);
	}
	
	public static ArmorSetMaterial fromId(String id)
	{
		return TO.get(id);
	}
	
	public static String idOf(ArmorSetMaterial mat)
	{
		return FROM.get(mat);
	}
}
