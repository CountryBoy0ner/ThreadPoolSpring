package ehu.thread.ThreadPool.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;

public class ProcessingState implements ClientState {
     private static final Logger logger = (Logger) LogManager.getLogger(ProcessingState.class);

    @Override
    public void handleRequest(ClientRequestHandler handler) {
        logger.info("Обработка запроса клиента #{}", handler.getClientId());
        try {
            TimeUnit.SECONDS.sleep(2); // Имитация обработки запроса
            handler.setState(new CompletedState());
        } catch (InterruptedException e) {
            logger.error("Ошибка обработки запроса клиента #{}", handler.getClientId(), e);
        }
    }
}