package pl.mikroblog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bartek on 07.02.2019.
 */

@Getter
@Setter
@Entity
@Table (name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Lob
    @Size(min = 10, max = 250)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

}
