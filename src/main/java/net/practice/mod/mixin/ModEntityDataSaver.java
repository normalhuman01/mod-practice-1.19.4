package net.practice.mod.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.practice.mod.util.IEntityDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ModEntityDataSaver implements IEntityDataSaver {
    private NbtCompound persistentData;
    private String persistentKey = "practice-mod.mod_data";
    @Inject(at = @At("HEAD"), method = "writeNbt")
    private void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info){
        if(persistentData == null) return;
        nbt.put(persistentKey, persistentData);
    }

    @Inject(method = "readNbt", at= @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info){
        if(!nbt.contains(persistentKey, 10))return;
        persistentData = nbt.getCompound(persistentKey);
    }

    @Override
    public NbtCompound getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Override
    public NbtCompound setPersistentData(String key, int[] data) {
        this.persistentData.putIntArray(key,data);
        return null;
    }

    @Override
    public NbtCompound setPersistentData(String key, int value) {
        this.persistentData.putInt(key,value);
        return null;
    }
}
