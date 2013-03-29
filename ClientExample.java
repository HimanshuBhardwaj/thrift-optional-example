import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class ClientExample {
    try {
        TSocket transport = new TSocket("localhost", 7911);
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();

        User user = client.getUserById(42);
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        if (user.getBorn().isDefined()) {
            System.out.println("age: " + 2013 - user.getBorn().get());
        } else {
            System.out.println("unknown age.");
        }

        /* === this prints: ===
        id: 42
        name: Chuck Norris
        unknown age.
         */

        transport.close();
    } catch (TTransportException e) {
        e.printStackTrace();
    } catch (TException e) {
        e.printStackTrace();
    }
}
