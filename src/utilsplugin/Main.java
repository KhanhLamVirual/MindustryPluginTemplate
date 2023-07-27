package utilsplugin;

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
    final long ChannelID = 1131854700669575198L;
    DiscordClient client = DiscordClient.create(TOKEN);
    Events.on(PlayerChatEvent.class, event -> {
      String player = event.player.name;
      String playerchat = event.message;
      GatewayDiscordClient gateway = client.login().block();
      MessageChannel channel = gateway.getChannelById(Snowflake.of(1131854700669575198L)).ofType(TextChannel.class).block();
      EmbedCreateSpec chatembed = EmbedCreateSpec.builder()
        .color(Color.DARK_GRAY)
        .description("[" + player + "] >> " + playerchat)
        .build();
      channel.createMessage(chatembed).block();
      gateway.logout().block();
    });
  }
}
