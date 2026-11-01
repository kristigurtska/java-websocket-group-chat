
package com.taskmanager.websocket;

import com.google.gson.Gson;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

    private static final Gson gson = new Gson();

    @Override
    public Message decode(String text) throws DecodeException {
        return gson.fromJson(text, Message.class);
    }

    @Override
    public boolean willDecode(String text) {
        return text != null && !text.isEmpty();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
}
