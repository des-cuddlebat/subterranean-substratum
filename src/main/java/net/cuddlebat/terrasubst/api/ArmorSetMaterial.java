package net.cuddlebat.terrasubst.api;

import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorMaterial;

public interface ArmorSetMaterial extends ArmorMaterial
{
	public boolean doesHaveSet(LivingEntity entity);
	
	public void onTick(LivingEntity entity);
	
	public Multimap<String, EntityAttributeModifier> getAttributes();
}
