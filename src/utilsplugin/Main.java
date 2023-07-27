package utilsplugin;

import net.dv8tion.jda.api.*;
import mindustry.gen.*;
import mindustry.game.EventType.*;

public class Main extends Plugin{
  @Override
  public void init(){
    Events.on(PlayerChatEvent.class, event -> {
      Player player = event.player;
      String message = event.message;
    });
  }
}
