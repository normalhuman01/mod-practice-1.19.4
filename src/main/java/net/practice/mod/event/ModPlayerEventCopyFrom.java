package net.practice.mod.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.practice.mod.util.IEntityDataSaver;

public class ModPlayerEventCopyFrom implements ServerPlayerEvents.CopyFrom{

    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        IEntityDataSaver original = ((IEntityDataSaver) oldPlayer);
        IEntityDataSaver player = ((IEntityDataSaver) newPlayer);

        int[] oldData = original.getPersistentData().getIntArray("homepos");
        player.getPersistentData().putIntArray("homepos",oldData);
    }
}
