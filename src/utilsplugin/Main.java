package utilsplugin;

import utilsplugin.discord.*;

import discord4j.common.util.*;
import discord4j.core.*;
import discord4j.rest.util.*;
import discord4j.core.spec.*;
import discord4j.core.object.entity.channel.*;

import arc.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.gen.*;
import mindustry.game.EventType.*;

public class Main extends Plugin{
  
  @Override
  public void init(){
    final String TOKEN = "MTEzMzkzOTk0OTAyOTMwNjQ5OA.GcxXBn.bIilpkmiSSfblTS7vYpmq8dj__n3U0H4jwxshA";
    Bot.connect(TOKEN)
    Events.on(PlayerChatEvent.class, event -> {
      String player = event.player.name;
      String playerchat = event.message;
      Bot.sendmessage("[" +player+ "]" + ">>" + playerchat);
    });
  }
}
