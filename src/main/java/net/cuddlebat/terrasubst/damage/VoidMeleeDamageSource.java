package net.cuddlebat.terrasubst.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.EntityDamageSource;

public class VoidMeleeDamageSource extends EntityDamageSource
{
	
	public VoidMeleeDamageSource(Entity source)
	{
		super("void", source);
		this.setBypassesArmor();
		this.setUnblockable();
	}
}
