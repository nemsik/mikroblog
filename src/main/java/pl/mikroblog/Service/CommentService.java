package pl.mikroblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mikroblog.model.Comment;
import pl.mikroblog.repository.CommentRepository;

/**
 * Created by bartek on 08.02.2019.
 */
@Service("commentService")
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void newComment(Comment comment){
        commentRepository.save(comment);
    }
}
