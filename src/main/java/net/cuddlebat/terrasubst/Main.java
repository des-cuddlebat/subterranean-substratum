package net.cuddlebat.terrasubst;

import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import net.cuddlebat.terrasubst.component.ArmorSetComponentImpl;
import net.cuddlebat.terrasubst.component.DamageCooldownComponentImpl;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		

		// Cardinal Components setup
		EntityComponentCallback.event(LivingEntity.class).register((entity, components) -> components
			.put(Id.Component.DAMAGE_COOLDOWN_COMPONENT, new DamageCooldownComponentImpl()));

		EntityComponentCallback.event(LivingEntity.class).register((entity, components) -> components
			.put(Id.Component.ARMOR_SET_COMPONENT, new ArmorSetComponentImpl()));
	}
}
