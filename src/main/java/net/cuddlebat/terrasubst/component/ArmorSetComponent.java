package net.cuddlebat.terrasubst.component;

import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.entity.LivingEntity;

public interface ArmorSetComponent extends Component
{
	public void onTick(LivingEntity entity);
	
	public void updateSets(LivingEntity entity);
}
