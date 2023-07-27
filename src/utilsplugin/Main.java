package utilsplugin;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;

import arc.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.gen.*;
import mindustry.game.EventType.*;

public class Main extends Plugin{
  
  @Override
  public void init(){
    final String TOKEN = "MTEzMzkzOTk0OTAyOTMwNjQ5OA.GcxXBn.bIilpkmiSSfblTS7vYpmq8dj__n3U0H4jwxshA";
    JDABuilder bot = JDABuilder.createDefault(TOKEN).build()
    Events.on(PlayerChatEvent.class, event -> {
      Player player = event.player;
      String message = event.message;
      
      TextChannel channel = bot.getTextChannelById("1131854700669575198");
      channel.sendMesssage("[" + player + "] > " + message).queue();
    });
  }
}
