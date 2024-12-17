package ehu.thread.ThreadPool.service;

public interface ClientState {
    void handleRequest(ClientRequestHandler handler);
}
