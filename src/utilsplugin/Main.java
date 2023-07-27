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
    final String TOKEN = "";
    JDABuilder bot = JDABuilder.createDefault(TOKEN)
      .setActivity(Activity.playing("vndustry.ddnd.net"))
      .build();
    Events.on(PlayerChatEvent.class, event -> {
      Player player = event.player;
      String message = event.message;
      
      TextChannel channel = bot.getTextChannelById("");
      channel.sendMesssage("[" + player + "] > " + message).queue();
    });
  }
}
