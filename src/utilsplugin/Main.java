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
    JDA bot = JDABuilder.createDefault(TOKEN)
      .setActivity(Activity.playing("vndustry.ddns.net")
      .build();
    Events.on(PlayerChatEvent.class, event -> {
      Player player = event.player;
      String playerchat = event.message;
      
      TextChannel channel = bot.getTextChannelById("1131854700669575198");
      channel.sendMessage("[" + player + "] > " + playerchat).queue();
    });
  }
}
