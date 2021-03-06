package net.scapeemulator.game.msg.decoder.item;

import java.io.IOException;

import net.scapeemulator.game.msg.MessageDecoder;
import net.scapeemulator.game.msg.impl.RemoveItemMessage;
import net.scapeemulator.game.net.game.DataOrder;
import net.scapeemulator.game.net.game.DataTransformation;
import net.scapeemulator.game.net.game.DataType;
import net.scapeemulator.game.net.game.GameFrame;
import net.scapeemulator.game.net.game.GameFrameReader;

public final class RemoveItemMessageDecoder extends MessageDecoder<RemoveItemMessage> {

	public RemoveItemMessageDecoder() {
		super(81);
	}

	@Override
	public RemoveItemMessage decode(GameFrame frame) throws IOException {
		GameFrameReader reader = new GameFrameReader(frame);
		int itemSlot = (int) reader.getUnsigned(DataType.SHORT, DataTransformation.ADD);
		int itemId = (int) reader.getUnsigned(DataType.SHORT);
		int inter = (int) reader.getSigned(DataType.INT, DataOrder.MIDDLE);
		int id = (inter >> 16) & 0xFFFF;
		int slot = inter & 0xFFFF;
		return new RemoveItemMessage(id, slot, itemSlot, itemId);
	}

}
