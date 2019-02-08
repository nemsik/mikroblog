package pl.mikroblog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bartek on 07.02.2019.
 */
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column (nullable = false, unique = true)
    @Length (min = 3, message = "*Your nick must have at least 3 characters")
    private String nick;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
        posts = new ArrayList<>();
    }
}
