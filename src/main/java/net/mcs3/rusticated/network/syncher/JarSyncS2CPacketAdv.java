package net.mcs3.rusticated.network.syncher;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.mcs3.rusticated.world.level.block.entity.JarBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;

public class JarSyncS2CPacketAdv {
    public static void receive(Minecraft client, ClientPacketListener menu,
                               FriendlyByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.level.getBlockEntity(position) instanceof JarBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);
        }
    }
}
