package net.mcs3.elixiremporium.mixin;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ElixirEmporiumMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		ElixirEmporium.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
