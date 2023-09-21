package example;

import arc.Events;
import example.Discord.DiscordBot;
import example.Discord.DiscordConfig;
import mindustry.game.EventType.PlayEvent;
import mindustry.mod.Plugin;

/**
 * ExamplePlugin
 */
public class ExamplePlugin extends Plugin {
  @Override
  public void init() {
    DiscordConfig.load();
    Events.on(PlayEvent.class, e -> {
      DiscordBot.connect();
      DiscordBot.sendMessage("`Server Has Online!`");
    });
  }

}
