package ca.uottawa.csmlab.symboleo.ide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class MyDslWebSocketServer extends WebSocketServer {
	public ByteArrayOutputStream out = new ByteArrayOutputStream() {
	    @Override
	    public void flush() throws IOException {
	      super.flush();
	      byte[] _byteArray = this.toByteArray();
	      String s = new String(_byteArray, StandardCharsets.UTF_8);
	      int i = s.indexOf("\r\n\r\n");
	      if ((i > 0)) {
	        s = s.substring((i + 4));
	      }
	      InputOutput.<String>println(s);
	      MyDslWebSocketServer.this.conn.send(s);
	      this.reset();
	    }
	  };
	  
  private PipedOutputStream pipe = new PipedOutputStream();

  public PipedInputStream in = new Function0<PipedInputStream>() {
    @Override
    public PipedInputStream apply() {
      try {
        PipedInputStream _pipedInputStream = new PipedInputStream(MyDslWebSocketServer.this.pipe);
        return _pipedInputStream;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();

  private WebSocket conn;

  public MyDslWebSocketServer(final InetSocketAddress a) {
    super(a);
  }

	@Override
	public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(WebSocket arg0, Exception ex) {
		// TODO Auto-generated method stub
		ex.printStackTrace();

	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		// TODO Auto-generated method stub
		try {
//		      String replaceString=message.replace("\"workspaceFolders\":true","\"workspaceFolders\":false"); 
		      String replaceString=message.replace("\"workspaceFolders\":[{\"uri\":\"inmemory://model/\",\"name\":\"\"}]","\"workspaceFolders\":null");
		      int _length = replaceString.length();
		      String _plus = ("Content-Length: " + Integer.valueOf(_length));
		      this.pipe.write((_plus + "\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
		      this.pipe.write(replaceString.getBytes(StandardCharsets.UTF_8));
		      this.pipe.flush();
		      System.err.println(("FinalReplacedmessage: " + replaceString));
		    } catch (Throwable _e) {
		      throw Exceptions.sneakyThrow(_e);
		    }

	}

	@Override
	public void onOpen(WebSocket arg0, ClientHandshake arg1) {
		// TODO Auto-generated method stub
		System.err.println("open");
	    this.conn = arg0;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.err.println("start");
	}

}
