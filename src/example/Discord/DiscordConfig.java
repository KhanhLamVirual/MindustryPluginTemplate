package example.Discord;

import arc.util.Log;
import useful.ConfigLoader;

import static mindustry.Vars.*;

/**
 * DiscordConfig
 */
public class DiscordConfig {

  public static DiscordConfig discordConfig;

  public static void load() {
    discordConfig = ConfigLoader.load(DiscordConfig.class, "d-config.json");
    Log.info("Loaded Config : (@)", dataDirectory.child("d-config.json").absolutePath());
  }

  public String token = "";

  public long perlChannel = 0L;
  public long chatChannel = 0L;
}
