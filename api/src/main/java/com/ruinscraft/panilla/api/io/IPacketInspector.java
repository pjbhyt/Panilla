package com.ruinscraft.panilla.api.io;

import com.ruinscraft.panilla.api.exception.NbtNotPermittedException;
import com.ruinscraft.panilla.api.exception.OversizedPacketException;
import com.ruinscraft.panilla.api.exception.SignLineLengthTooLongException;

public interface IPacketInspector {

	/* all packets */
	void checkSize(Object _packet) throws OversizedPacketException;
	/* inbound packets		(client->server) */
	void checkPacketPlayInSetCreativeSlot(Object _packet) throws NbtNotPermittedException;
	void checkPacketPlayInUpdateSign(Object _packet) throws SignLineLengthTooLongException;
	/* outbound packets		(server->client) */
	void checkPacketPlayOutSetSlot(Object _packet) throws NbtNotPermittedException;

	default void checkPlayIn(Object _player, Object _packet) 
			throws OversizedPacketException, NbtNotPermittedException, SignLineLengthTooLongException {
		checkSize(_packet);
		checkPacketPlayInSetCreativeSlot(_packet);
		checkPacketPlayInUpdateSign(_packet);
	}
	
	default void checkPlayOut(Object _packet)
			throws OversizedPacketException, NbtNotPermittedException {
		checkSize(_packet);
		checkPacketPlayOutSetSlot(_packet);
	}
	
}
