package example.Discord;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.gateway.intent.Intent;
import discord4j.gateway.intent.IntentSet;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.ctype.UnlockableContent;

import static example.Discord.DiscordConfig.*;

import arc.util.Log;

/**
 * DiscordBot
 */
public class DiscordBot {

  public static GatewayDiscordClient gateway;
  public static GuildMessageChannel perlChannel, chatChannel;

  public static void connect() {
    gateway = DiscordClient.create(discordConfig.token)
        .gateway()
        .setEnabledIntents(IntentSet.of(Intent.GUILD_MEMBERS, Intent.GUILD_MESSAGES))
        .login()
        .block();

    perlChannel = gateway.getChannelById(Snowflake.of(discordConfig.perlChannel)).ofType(GuildMessageChannel.class)
        .block();
    chatChannel = gateway.getChannelById(Snowflake.of(discordConfig.chatChannel)).ofType(GuildMessageChannel.class)
        .block();

    gateway.on(MessageCreateEvent.class).subscribe((e) -> {
      var message = e.getMessage();
      if (message.getContent().isEmpty())
        return;
      var member = e.getMember().orElse(null);
      if (member.isBot())
        return;
      if (message.getChannelId().asLong() == discordConfig.chatChannel) {
        var content = message.getContent();
        var user = member.getDisplayName();
        mindustry.gen.Call.sendMessage("[blue][][white] " + user + ": " + content);
        System.out.println(content);
      }
    });

  }

  public static void sendMessage(String content) {
    chatChannel.createMessage(content).subscribe();

  }

}
