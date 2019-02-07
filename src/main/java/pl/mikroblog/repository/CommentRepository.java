package pl.mikroblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikroblog.model.Comment;

/**
 * Created by bartek on 07.02.2019.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
