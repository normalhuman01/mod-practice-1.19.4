package net.practice.mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.practice.mod.util.IEntityDataSaver;

public class SetHomeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(CommandManager.literal("home")
                .then(CommandManager.literal("set")
                        .executes(SetHomeCommand::run)));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource commandSource = context.getSource();
        ServerPlayerEntity serverPlayer = commandSource.getPlayer();
        IEntityDataSaver player = (IEntityDataSaver) serverPlayer;

        BlockPos playerPos = serverPlayer.getBlockPos();
        assert player != null;
        int[] newHomePos = {playerPos.getX(), playerPos.getY(), playerPos.getZ()};

        player.setPersistentData("homepos", newHomePos);
        commandSource.sendFeedback(Text.literal("Home set at !" + newHomePos.toString()), true);

        return 1;
    }
}
