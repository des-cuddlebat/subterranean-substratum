package net.cuddlebat.terrasubst.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.EntityDamageSource;

public class MagicMeleeDamageSource extends EntityDamageSource
{
	
	public MagicMeleeDamageSource(Entity source)
	{
		super("magic", source);
		this.setBypassesArmor();
		this.setUsesMagic();
	}
}
