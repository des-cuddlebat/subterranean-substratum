package net.cuddlebat.terrasubst.component;

import java.util.LinkedList;
import java.util.PriorityQueue;

import net.cuddlebat.terrasubst.api.ExtendedDamageSource;
import net.cuddlebat.terrasubst.damage.DamageLogEntry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.nbt.CompoundTag;

public class DamageCooldownComponentImpl implements DamageCooldownComponent
{
	public static final int COOLDOWN_TICKS = 10;
//	private LinkedList<DamageLogEntry> log = new LinkedList<DamageLogEntry>();
	private PriorityQueue<DamageLogEntry> log = new PriorityQueue<DamageLogEntry>();
	private int age;
	
	@Override
	public void logDamage(DamageSource source, float amount)
	{
		if(source.getAttacker() == null) // TODO certain env causes
			return;
		for (DamageLogEntry entry : log)
		{
			if(entry.getAttacker().equals(source.getAttacker().getUuid()) &&
				entry.getType().equals(source.name))
			{
				entry.setAmount(amount);
				return;
			}
		}
		int ticks = 10;
		if (source instanceof ExtendedDamageSource)
			ticks = ((ExtendedDamageSource)source).getCooldownTicks();
		log.add(new DamageLogEntry(amount, source.name, source.getAttacker().getUuid(), age + ticks));
	}

	@Override
	public float getLoggedDamage(DamageSource source, float amount)
	{
		if(source.getAttacker() == null) // TODO certain env causes
			return 0;
		for (DamageLogEntry entry : log)
		{
			if(entry.getAttacker().equals(source.getAttacker().getUuid()) &&
				entry.getType().equals(source.name))
			{
				return entry.getAmount();
			}
		}
		return 0;
	}

	@Override
	public void tick()
	{
		age++;
		while(!log.isEmpty() && log.peek().getTimestamp() < age)
		{
			log.poll();
		}
	}

	@Override
	public void fromTag(CompoundTag tag)
	{
		CompoundTag comp = tag.getCompound("terra_damagelog");
		this.age = comp.getInt("age");
		int count = comp.getInt("entries");
		for(int i = 0; i < count; i++)
		{
			log.add(new DamageLogEntry(
				comp.getFloat("amount_" + i),
				comp.getString("type_" + i),
				comp.contains("uuid_" + i) ? comp.getUuid("uuid_" + i) : null,
				comp.getInt("stamp_" + i)
				));
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag tag)
	{
		CompoundTag comp = new CompoundTag();
		comp.putInt("age", age);
		int i = 0;
		for(DamageLogEntry entry : log)
		{
			comp.putFloat("amount_" + i, entry.getAmount());
			comp.putString("type_" + i, entry.getType());
			if(entry.getAttacker() != null)
				comp.putUuid("uuid_" + i, entry.getAttacker());
			comp.putInt("stamp_" + i, entry.getTimestamp());
			i++;
		}
		comp.putInt("entries", i);
		tag.put("terra_damagelog", comp);
		return tag;
	}
}
