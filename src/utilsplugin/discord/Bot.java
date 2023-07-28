package utilsplugin.discord;

import discord4j.common.util.*;
import discord4j.core.*;
import discord4j.rest.util.*;
import discord4j.core.spec.*;
import discord4j.core.object.entity.channel.*;

public class Bot {
  public static void connect() {
    DiscordClient client = DiscordClient.create(TOKEN);
    GatewayDiscordClient gateway = client.login().block();
  }
  public static void sendchat(String message) {
    MessageChannel channel = gateway.getChannelById(Snowflake.of(1131854700669575198L)).ofType(TextChannel.class).block();
    EmbedCreateSpec chatembed = EmbedCreateSpec.builder()
      .color(Color.DARK_GRAY)
      .title(message)
      .build();
    channel.createMessage(chatembed).block();
  }
}
