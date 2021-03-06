package net.scapeemulator.game.msg;

import java.io.IOException;

import net.scapeemulator.game.net.game.GameFrame;

public abstract class MessageDecoder<T extends Message> {

	protected final int opcode;

	public MessageDecoder(int opcode) {
		this.opcode = opcode;
	}

	public abstract T decode(GameFrame frame) throws IOException;

}
