package net.cuddlebat.terrasubst.component;

import java.util.HashSet;
import java.util.Set;

import net.cuddlebat.terrasubst.api.ArmorSetItem;
import net.cuddlebat.terrasubst.api.ArmorSetMaterial;
import net.cuddlebat.terrasubst.api.ArmorSets;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;

public class ArmorSetComponentImpl implements ArmorSetComponent
{
	private Set<ArmorSetMaterial> sets = new HashSet<>();
	
	@Override
	public void onTick(LivingEntity entity)
	{
		for(ArmorSetMaterial mat : sets)
		{
			mat.onTick(entity);
		}
	}

	@Override
	public void updateSets(LivingEntity entity)
	{
		// remove
		for(ArmorSetMaterial mat : sets)
		{
			if(!mat.doesHaveSet(entity))
			{
				entity.getAttributes().removeAll(mat.getAttributes());
				sets.remove(mat);
			}
		}
		// add
		for(EquipmentSlot slot : EquipmentSlot.values())
		{
			if(entity.getEquippedStack(slot).getItem() instanceof ArmorSetItem)
			{
				ArmorSetItem item = (ArmorSetItem) entity.getEquippedStack(slot).getItem();
				ArmorSetMaterial mat = item.getSetMaterial();
				if(!sets.contains(mat) && mat.doesHaveSet(entity))
				{
					entity.getAttributes().replaceAll(mat.getAttributes());
					sets.add(mat);
				}
			}
		}
	}

	@Override
	public void fromTag(CompoundTag tag)
	{
		CompoundTag sub = tag.getCompound("armorsets");
		int counter = 0;
		while(sub.contains(String.valueOf(counter)))
		{
			sets.add(ArmorSets.fromId(sub.getString(String.valueOf(counter))));
			counter++;
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag tag)
	{
		CompoundTag sub = new CompoundTag();
		int counter = 0;
		for(ArmorSetMaterial set : sets)
		{
			sub.putString(String.valueOf(counter), ArmorSets.idOf(set));
			counter++;
		}
		tag.put("armorsets", sub);
		return tag;
	}
}
