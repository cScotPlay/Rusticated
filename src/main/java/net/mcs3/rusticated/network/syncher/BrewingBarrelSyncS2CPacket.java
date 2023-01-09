package net.mcs3.rusticated.network.syncher;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.world.inventory.BrewingBarrelMenu;
import net.mcs3.rusticated.world.level.block.entity.BrewingBarrelBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;

public class BrewingBarrelSyncS2CPacket {

    public static void receive(Minecraft client, ClientPacketListener menu,
                               FriendlyByteBuf buf, PacketSender responseSender) {
        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();
        int slotPostion = buf.readInt();

        if (client.level.getBlockEntity(position) instanceof BrewingBarrelBlockEntity blockEntity) {
            SingleVariantStorage<FluidVariant> fluidStorage = blockEntity.getFluidStorage(slotPostion);
            blockEntity.setFluidLevel(fluidStorage, variant, fluidLevel);

            if(client.player.containerMenu instanceof BrewingBarrelMenu brewingMenu &&
                    brewingMenu.blockEntity.getBlockPos().equals(position)) {

                blockEntity.setFluidLevel(fluidStorage, variant, fluidLevel);
                if(fluidStorage == blockEntity.inputFluidStorage) {
                    brewingMenu.setInputFluid(new FluidStack(variant, fluidLevel));
                }
                if (fluidStorage == blockEntity.resultFluidStorage) {
                    brewingMenu.setResultFluid(new FluidStack(variant, fluidLevel));
                }
                if (fluidStorage == blockEntity.primerFluidStorage) {
                    brewingMenu.setPrimerFluid(new FluidStack(variant, fluidLevel));
                }
            }
        }
    }
}
