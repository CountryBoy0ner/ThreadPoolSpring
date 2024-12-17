package ehu.thread.ThreadPool.controller;


import ehu.thread.ThreadPool.service.ClientRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

@RestController
@RequestMapping("/api")
public class ClientRequestController {

//    private final ExecutorService threadPool;
//
//    @Autowired
//    public ClientRequestController(@Value("${thread.pool.size}") int threadPoolSize) {
//        this.threadPool = Executors.newFixedThreadPool(threadPoolSize);
//    }
//
//    @PostMapping("/client/{clientId}/request")
//    public String handleClientRequest(@PathVariable int clientId) {
//        ClientRequestHandler requestHandler = new ClientRequestHandler(clientId);
//
//        // Отправляем запрос на обработку в пул потоков
//        threadPool.submit(requestHandler);
//
//        return "Запрос клиента #" + clientId + " принят в обработку.";
//    }
}