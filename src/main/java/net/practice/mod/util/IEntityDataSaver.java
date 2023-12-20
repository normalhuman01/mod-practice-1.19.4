package net.practice.mod.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();

    NbtCompound setPersistentData(String key, int[] data);
    NbtCompound setPersistentData(String key, int value);
}
