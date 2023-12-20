package net.practice.mod.mixin;

import net.minecraft.server.MinecraftServer;
import net.practice.mod.PracticeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class PracticeModMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		PracticeMod.LOGGER.info("Injected Mixin");
		// This code is injected into the start of MinecraftServer.loadWorld()V
	}
}