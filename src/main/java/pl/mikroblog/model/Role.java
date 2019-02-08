package pl.mikroblog.model;

import javax.persistence.*;

/**
 * Created by bartek on 08.02.2019.
 */
//todo
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
}
