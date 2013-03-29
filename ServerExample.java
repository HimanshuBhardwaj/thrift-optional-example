import org.apache.thrift.Option;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ServerExample {
    public static void main(String[] args) {
        try {
            TServerSocket serverTransport = new TServerSocket(7911);
            UserService.Processor processor = new UserService.Processor(new UserService.Iface(){
                public User getUserById(int id) throws TException {
                    User user = new User();
                    user.setId(42);
                    user.setName("Chuck Norris");
                    // Note that we don't set the optional "born" field.
                    return user;
                }
            });

            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).
                    processor(processor));
            System.out.println("Starting server on port 7911 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
