package ehu.thread.ThreadPool.service;

// Состояния клиента
public interface ClientState {
    void handleRequest(ClientRequestHandler handler);
}
