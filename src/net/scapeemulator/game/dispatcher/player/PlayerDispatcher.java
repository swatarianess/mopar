package net.scapeemulator.game.dispatcher.player;

import java.util.HashMap;
import java.util.Map;

import net.scapeemulator.game.dispatcher.player.handler.*;
import net.scapeemulator.game.model.ExtendedOption;
import net.scapeemulator.game.model.World;
import net.scapeemulator.game.model.player.Player;

/**
 * @author Hadyn Richard
 */
public final class PlayerDispatcher {

    private Map<String, PlayerHandler> handlers = new HashMap<>();

    public PlayerDispatcher() {
        bind(new FollowHandler());
        bind(new TradeHandler());
    }

    public void bind(PlayerHandler handler) {
        handlers.put(handler.getOption(), handler);
    }

    public void unbindAll() {
        handlers.clear();
    }

    public void handle(Player player, int selectedId, ExtendedOption option) {
        if (player.actionsBlocked()) {
            return;
        }
        Player selectedPlayer = World.getWorld().getPlayers().get(selectedId);

        if (selectedPlayer == null || !player.getPosition().isWithinScene(selectedPlayer.getPosition())) {
            return;
        }

        PlayerHandler handler = handlers.get(player.getOption(option.toInteger()).getText().toLowerCase());

        if (handler != null) {
            handler.handle(player, selectedPlayer);
        }
    }
}