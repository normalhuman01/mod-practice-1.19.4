package net.practice.mod.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ExplosionEnchant extends Enchantment {
    protected String translationKey = "citrine_enchant";

    protected ExplosionEnchant(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

}
