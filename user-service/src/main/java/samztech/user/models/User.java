package samztech.user.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Entity
@Consumes(MediaType.APPLICATION_JSON)
public class User extends PanacheEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String username;

    @Column(nullable = false, length = 60)
    public String password;

    @Column(nullable = false)
    public String email;
}
