package net.cuddlebat.terrasubst;

import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import net.cuddlebat.terrasubst.component.ArmorSetComponent;
import net.cuddlebat.terrasubst.component.DamageCooldownComponent;
import net.minecraft.util.Identifier;

public final class Id
{
	public static final String MODID = "terrasubst";
	
	public static final class Component
	{
//		public static final ComponentType<IProjectileComponent> PROJECTILE_COMPONENT = 
//	        ComponentRegistry.INSTANCE.registerIfAbsent(
//	        	new Identifier("terrawa:projectilecomponent"), IProjectileComponent.class);
//		
//		public static final ComponentType<ICavernsComponent> CAVERNS_COMPONENT = 
//	        ComponentRegistry.INSTANCE.registerIfAbsent(
//	        	new Identifier("terrawa:cavernscomponent"), ICavernsComponent.class);
		
		public static final ComponentType<DamageCooldownComponent> DAMAGE_COOLDOWN_COMPONENT = 
	        ComponentRegistry.INSTANCE.registerIfAbsent(
	        	new Identifier("terrawa:damagecomponent"), DamageCooldownComponent.class);
		
		public static final ComponentType<ArmorSetComponent> ARMOR_SET_COMPONENT = 
	        ComponentRegistry.INSTANCE.registerIfAbsent(
	        	new Identifier("terrawa:armorsetcomponent"), ArmorSetComponent.class);

//		public static final ComponentType<IFishingComponent> FISHING_COMPONENT = 
//	        ComponentRegistry.INSTANCE.registerIfAbsent(
//	        	new Identifier("terrawa:fishingcomponent"), IFishingComponent.class);
	}
}
