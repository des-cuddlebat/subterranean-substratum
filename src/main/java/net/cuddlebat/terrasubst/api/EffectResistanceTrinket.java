package net.cuddlebat.terrasubst.api;

import dev.emi.trinkets.api.ITrinket;
import net.minecraft.entity.effect.StatusEffect;

/**
 * An interface that extends {@link dev.emi.trinkets.api.ITrinket ITrinket}, 
 * allowing the trinket item that implements this interface to provide its
 * wearer with protection from a status effect 
 */
public interface EffectResistanceTrinket extends ITrinket
{
	public boolean doesPreventEffect(StatusEffect effect);
}
