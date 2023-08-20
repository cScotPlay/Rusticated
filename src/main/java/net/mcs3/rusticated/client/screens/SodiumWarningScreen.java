package net.mcs3.rusticated.client.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.WarningScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class SodiumWarningScreen extends WarningScreen {

    private static final MutableComponent TITLE;
    private static final Component CONTENT;
    private static final Component CHECK;
    private static final MutableComponent NARRATION;

    private static final Component CURSEFORGE;
    private static final Component MODRINTH;
    private static final Component PROCEED;

    private MultiLineLabel message = MultiLineLabel.EMPTY;

    public SodiumWarningScreen(){
        super(TITLE, CONTENT, CHECK, NARRATION);
    }

    @Override
    protected void initButtons(int yOffset) {
        this.addRenderableWidget(new Button(this.width / 2 - 155, 100 + yOffset, 150, 20, CURSEFORGE, button -> Util.getPlatform().openUri("https://www.curseforge.com/minecraft/mc-mods/indium")));
        this.addRenderableWidget(new Button(this.width / 2 - 155 + 160, 100 + yOffset, 150, 20, MODRINTH, button -> Util.getPlatform().openUri("https://modrinth.com/mod/indium")));

        this.addRenderableWidget(new Button(this.width / 2 - 155 + 160, 130 + yOffset, 150, 20, Component.literal("Quit"), button -> this.minecraft.stop()));
        this.addRenderableWidget(new Button(this.width / 2 - 155, 130 + yOffset, 150, 20, PROCEED, button -> this.minecraft.setScreen(new TitleScreen())));


//        this.addRenderableWidget(new Button(this.width / 2 - 155, this.height / 6 + 96, 150, 20, Component.translatable("datapackFailure.safeMode"), button -> this.minecraft.setScreen(new ConfirmLinkScreen(bl -> {
//            if (bl) {
//                Util.getPlatform().openUri("https://www.curseforge.com/minecraft/mc-mods/indium");
//            }
//            this.minecraft.setScreen(this);
//        }, "https://www.curseforge.com/minecraft/mc-mods/indium", true))));

    }

    //Util.getPlatform().openUri("https://www.curseforge.com/minecraft/mc-mods/indium")


    @Override
    protected void init() {
        super.init();
        this.message = MultiLineLabel.create(this.font, (FormattedText)this.CONTENT, this.width - 100);
        int i = (this.message.getLineCount() + 1) * this.getLineHeight();
        if (this.CHECK != null) {
            int j = this.font.width(this.CHECK);
            this.stopShowing = new Checkbox(this.width / 2 - j / 2 - 8, 76 + i, j + 24, 20, this.CHECK, false);
            this.addRenderableWidget(this.stopShowing);
        }
        this.initButtons(i);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    static {
        TITLE = Component.translatable("header.rusticated.warning_screen").withStyle(ChatFormatting.RED, ChatFormatting.BOLD, ChatFormatting.UNDERLINE);
        CONTENT = Component.translatable("message.rusticated.warning_screen");
        CHECK = Component.translatable("multiplayerWarning.check");
        NARRATION = TITLE.copy().append("\n").append(CONTENT);

        CURSEFORGE = Component.translatable("curseforge.rusticated.warning_screen");
        MODRINTH = Component.translatable("modrinth.rusticated.warning_screen");
        PROCEED = Component.translatable("proceed.rusticated.warning_screen").withStyle(ChatFormatting.BOLD, ChatFormatting.ITALIC, ChatFormatting.RED);
    }
}
