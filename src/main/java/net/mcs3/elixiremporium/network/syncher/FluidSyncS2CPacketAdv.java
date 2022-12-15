package net.mcs3.elixiremporium.network.syncher;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.mcs3.elixiremporium.fluid.FluidStack;
import net.mcs3.elixiremporium.world.inventory.AdvCondenserMenu;
import net.mcs3.elixiremporium.world.level.block.alchemy.AdvCondenserBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;

public class FluidSyncS2CPacketAdv {
    public static void receive(Minecraft client, ClientPacketListener menu,
                               FriendlyByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        if(client.level.getBlockEntity(position) instanceof AdvCondenserBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);

            if(client.player.containerMenu instanceof AdvCondenserMenu condenserMenu &&
                    condenserMenu.blockEntity.getBlockPos().equals(position)) {
                blockEntity.setFluidLevel(variant, fluidLevel);
                condenserMenu.setFluid(new FluidStack(variant, fluidLevel));
            }
        }
    }
}
