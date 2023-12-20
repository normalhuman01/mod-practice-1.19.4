package net.practice.mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.practice.mod.PracticeMod;
import net.practice.mod.util.IEntityDataSaver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReturnHomeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(CommandManager.literal("home")
                .then(CommandManager.literal("return")
                        .executes((context) -> {
                            return ReturnHomeCommand.run(context);
                        })));
    }

    public static int run(CommandContext<ServerCommandSource> context) {
        try{

            ServerCommandSource commandSource = context.getSource();
            ServerPlayerEntity serverPlayer = commandSource.getPlayer();
            IEntityDataSaver player = (IEntityDataSaver) serverPlayer;

            assert player != null;
            int[] homePos = player.getPersistentData().getIntArray("homepos");

            if(homePos.length == 0){
                commandSource.sendFeedback(Text.literal("No Home Position has been set!"), true);
                PracticeMod.LOGGER.info("No Home Position has been set!");

                return -1;
            }

            serverPlayer.requestTeleport(homePos[0], homePos[1], homePos[2]);

            commandSource.sendFeedback(Text.literal("Player returned Home!"),true);
                PracticeMod.LOGGER.info("Workd!");
            return 1;
        }catch(Error error){
            PracticeMod.LOGGER.info(error.toString());

            return -1;
        }
    }
}
