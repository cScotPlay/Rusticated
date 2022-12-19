package net.mcs3.rusticated.network.syncher;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.mcs3.rusticated.world.level.block.entity.EvaporatingBasinBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

public class EvaporatingSyncS2CPacket {
    public static void receive(Minecraft client, ClientPacketListener menu, FriendlyByteBuf buf, PacketSender responseSender) {

        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();

        int size = buf.readInt();
        NonNullList<ItemStack> list = NonNullList.withSize(size, ItemStack.EMPTY);
        for(int i = 0; i < size; i++) {
            list.set(i, buf.readItem());
        }

        BlockPos position = buf.readBlockPos();

        if(client.level.getBlockEntity(position) instanceof EvaporatingBasinBlockEntity blockEntity) {
            blockEntity.setFluidLevel(variant, fluidLevel);
            blockEntity.setInventory(list);        }
    }
}
