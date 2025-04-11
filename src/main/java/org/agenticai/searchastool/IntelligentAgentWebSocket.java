package org.agenticai.searchastool;


import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/ask")
public class IntelligentAgentWebSocket {

    private final IntelligentAgent intelligentAgent;

    public IntelligentAgentWebSocket(IntelligentAgent intelligentAgent) {
        this.intelligentAgent = intelligentAgent;
    }

    @OnTextMessage
    String onMessage(String message) {
        return intelligentAgent.chat(message);
    }

}
