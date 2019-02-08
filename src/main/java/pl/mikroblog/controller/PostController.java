package pl.mikroblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.mikroblog.Service.PostService;
import pl.mikroblog.Service.UserService;
import pl.mikroblog.model.Comment;
import pl.mikroblog.model.Post;
import pl.mikroblog.model.User;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

/**
 * Created by bartek on 08.02.2019.
 */
@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView getAllPosts() {
        Comment comment = new Comment();
        ModelAndView modelAndView = new ModelAndView("posts");
        modelAndView.addObject("posts", postService.getAllPosts());
        modelAndView.addObject("comment", comment);
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newPostGet() {
        ModelAndView modelAndView = new ModelAndView("newPost");
        Post post = new Post();
        modelAndView.addObject("post", post);
        return modelAndView;
    }


    @Transactional
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView newPost(@Valid Post post, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("newPost");
        if(post.getContent().length() < 5 || post.getContent().length() > 250) {
            bindingResult.rejectValue("content", "error.content", "content size");
        } else {
            post.setCreateDate(Calendar.getInstance().getTime());
            post.setLastModifiedDate(Calendar.getInstance().getTime());
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Optional<User> user = userService.getUserByNick(auth.getName());
            post.setUser(user.get());
            postService.addPost(post);
            modelAndView.addObject("successMessage", "Post has been added successfully");
        }
        return modelAndView;
    }
}
