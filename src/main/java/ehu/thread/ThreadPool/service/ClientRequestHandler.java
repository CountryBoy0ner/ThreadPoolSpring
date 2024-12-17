package ehu.thread.ThreadPool.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;


public class ClientRequestHandler implements Callable<Void> {
    private static final Logger logger = LogManager.getLogger(ClientRequestHandler.class);


    private final int clientId;
    private ClientState state;

    public int getClientId() {
        return clientId;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }

    public ClientRequestHandler(int clientId) {
        this.clientId = clientId;
        this.state = new ProcessingState();
    }

    @Override
    public Void call() {
        logger.info("Клиент #{} отправил запрос", clientId);
        state.handleRequest(this);
        return null;
    }
}