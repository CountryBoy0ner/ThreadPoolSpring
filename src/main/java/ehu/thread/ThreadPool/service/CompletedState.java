package ehu.thread.ThreadPool.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompletedState implements ClientState {
    private static final Logger logger = (Logger) LogManager.getLogger(CompletedState.class);
    @Override
    public void handleRequest(ClientRequestHandler handler) {
        logger.info("Запрос клиента #{} уже обработан", handler.getClientId());
    }
}
