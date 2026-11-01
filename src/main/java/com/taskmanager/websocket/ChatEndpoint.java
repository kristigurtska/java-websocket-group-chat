
package com.taskmanager.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.PathParam;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(
        value = "/chat/{username}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class
)
public class ChatEndpoint {

    private static Set<ChatEndpoint> endpoints =
            new CopyOnWriteArraySet<>();

    private Session session;
    private String username;

    @OnOpen
    public void onOpen(Session session,
                       @PathParam("username") String username) {

        this.session = session;
        this.username = username;

        endpoints.add(this);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("joined the chat!");

        broadcast(message);
    }

    @OnMessage
    public void onMessage(Message message) {

        message.setFrom(username);

        broadcast(message);
    }

    @OnClose
    public void onClose() {

        endpoints.remove(this);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("left the chat!");

        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public static void broadcast(Message message) {

        for (ChatEndpoint endpoint : endpoints) {
            try {
                endpoint.session.getBasicRemote().sendObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
