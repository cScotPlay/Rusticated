package net.mcs3.rusticated.mixin;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin {
    @Shadow
    @Final
    @Mutable
    public static Object2FloatMap<ItemLike> COMPOSTABLES;

    @Redirect(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/level/block/ComposterBlock;COMPOSTABLES:Lit/unimi/dsi/fastutil/objects/Object2FloatMap;"))
    private static void ddc$redirectToLoggingMap(Object2FloatMap<ItemLike> value) {
        COMPOSTABLES = value;

    }
}
