package net.mcs3.rusticated.network.syncher;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.mcs3.rusticated.world.level.block.entity.LiquidBarrelBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;

public class LiquidBarrelSyncS2CPacketAdv {
    public static void receive(Minecraft client, ClientPacketListener menu,
                               FriendlyByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.level.getBlockEntity(position) instanceof LiquidBarrelBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);
        }
    }
}
