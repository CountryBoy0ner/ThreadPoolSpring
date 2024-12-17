package ehu.thread.ThreadPool;

import ehu.thread.ThreadPool.service.ClientRequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class ThreadPoolApplication {
    private static final Logger logger = (Logger) LogManager.getLogger(ThreadPoolApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            List<String> configLines = Files.readAllLines(Path.of("config.txt"));
            int threadPoolSize = Integer.parseInt(configLines.get(0));

            ExecutorService threadPool = newFixedThreadPool(threadPoolSize);


            for (int i = 0; i < 10; i++) {
                threadPool.submit(new ClientRequestHandler(i));
            }

            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                }
            } catch (InterruptedException e) {
                logger.error("Ошибка ожидания завершения работы пула потоков", e);
                threadPool.shutdownNow();
            }
        };
    }
}
