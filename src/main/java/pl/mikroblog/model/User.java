package pl.mikroblog.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bartek on 07.02.2019.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (nullable = false, unique = true)
    @Length (min = 3, message = "*Your nick must have at least 3 characters")
    private String nick;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Set<Post> comments = new HashSet<>();


}
