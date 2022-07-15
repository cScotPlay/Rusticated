package net.mcs3.elixiremporium.world.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.client.gui.screens.inventory.BookEditScreen;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.state.BlockState;
import vazkii.patchouli.api.PatchouliAPI;

public class ModBookItem extends Item
{
    public ModBookItem() {
        super(new Item.Properties().stacksTo(1).tab(ElixirEmporium.ITEMGROUPDECO));
        new ResourceLocation(ElixirEmporium.MOD_ID, "catalog");

    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(Blocks.LECTERN)) {
            return LecternBlock.tryPlaceBook(context.getPlayer(), level, blockPos, blockState, context.getItemInHand()) ? InteractionResult.sidedSuccess(level.isClientSide) : InteractionResult.PASS;
        } else {
            return InteractionResult.PASS;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        if (!level.isClientSide && player instanceof ServerPlayer)
        {
            if (FabricLoader.getInstance().isModLoaded("patchouli")){
                PatchouliAPI.get().openBookGUI((ServerPlayer) player, new ResourceLocation(ElixirEmporium.MOD_ID, "emporium_catalog"));
                player.displayClientMessage(new TextComponent("This sort of works"), true);
                return InteractionResultHolder.success(player.getItemInHand(usedHand));
            } else {
                player.displayClientMessage(new TextComponent("Patchouli is not loaded, can't open guide book!"), true);
            }
        }
        return InteractionResultHolder.consume(player.getItemInHand(usedHand));
    }
}
