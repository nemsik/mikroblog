package pl.mikroblog.Service;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import pl.mikroblog.model.Post;
import pl.mikroblog.repository.PostRepository;

import java.util.List;

/**
 * Created by bartek on 08.02.2019.
 */
@Service("PostService")
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {return postRepository.findAll();}

    public Post getPostById(long id) {
        return postRepository.findById(id).get();
    }
}
