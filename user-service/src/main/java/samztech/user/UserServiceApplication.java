package samztech.user;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class UserServiceApplication {
    public static void main(String[] args) {
        Quarkus.run(args);
    }
}
