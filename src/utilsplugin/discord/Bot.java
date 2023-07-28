package utilsplugin.discord;

import discord4j.common.util.*;
import discord4j.core.*;
import discord4j.rest.util.*;
import discord4j.core.spec.*;
import discord4j.core.object.entity.channel.*;

public class Bot {

  private static MessageChannel channel;

  
  public static void connect() {
    DiscordClient client = DiscordClient.create(TOKEN);
    GatewayDiscordClient gateway = client.login().block();
    channel = gateway.getChannelById(Snowflake.of(1131854700669575198L)).ofType(TextChannel.class).block();
    System.out.println("Bot Has Connected");
    
  }
  public static void sendmessage(String message) {
    
    EmbedCreateSpec chatembed = EmbedCreateSpec.builder()
      .color(Color.DARK_GRAY)
      .title(message)
      .build();
    channel.createMessage(chatembed).block();
  }
}
