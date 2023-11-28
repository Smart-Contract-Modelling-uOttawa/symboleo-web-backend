package ca.uottawa.csmlab.symboleo.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.net.InetSocketAddress;
import java.io.File;
import org.eclipse.xtext.util.IFileSystemScanner;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.InputOutput;


public class RunWebSocketServer3 {
  public static void main(final String[] args) {
    String host = "0.0.0.0";
    int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "5007"));;
    ServerModule _serverModule = new ServerModule();
    Injector injector = Guice.createInjector(_serverModule);
    InetSocketAddress _inetSocketAddress = new InetSocketAddress(host, port);
    MyDslWebSocketServer server = new MyDslWebSocketServer(_inetSocketAddress) {
      @Override
      public void run() {
        super.run();
      }
    };
    LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
    final Function<MessageConsumer, MessageConsumer> _function = (MessageConsumer consumer) -> {
      MessageConsumer result = consumer;
      return result;
    };
    Function<MessageConsumer, MessageConsumer> wrapper = _function;
    Launcher<LanguageClient> launcher = new LSPLauncher.Builder<LanguageClient>().setLocalService(languageServer).setRemoteInterface(LanguageClient.class).setInput(server.in).setOutput(server.out).setExecutorService(Executors.newCachedThreadPool()).wrapMessages(wrapper).create();
    languageServer.connect(launcher.getRemoteProxy());
    Future<?> future = launcher.startListening();
    InputOutput.<String>println("gogogo");
    try {
    server.run();}
    catch(RuntimeException e) {
    	System.err.println("Error in server.run");
    	e.printStackTrace();    
    }
    System.err.println("möööp");
    while ((!future.isDone())) {
      boolean _isDone = future.isDone();
      if (_isDone) {
        languageServer.shutdown();
      }
    }
  }
}
