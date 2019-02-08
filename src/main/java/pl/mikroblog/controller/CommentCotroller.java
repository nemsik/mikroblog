package pl.mikroblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mikroblog.Service.CommentService;
import pl.mikroblog.Service.PostService;
import pl.mikroblog.model.Comment;
import pl.mikroblog.model.Post;

import javax.validation.Valid;

/**
 * Created by bartek on 08.02.2019.
 */
@Controller
@RequestMapping("/post/{id}")
public class CommentCotroller {

    @Autowired
    private  CommentService commentService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/addComent", method = RequestMethod.POST)
    public ModelAndView addComment(@Valid Comment comment, @PathVariable("id") long id) {
        comment.setPost(postService.getPostById(id));
        commentService.newComment(comment);
        ModelAndView modelAndView = new ModelAndView("posts");
        modelAndView.addObject("posts", postService.getAllPosts());
        modelAndView.addObject("comment", comment);
        modelAndView.addObject("successMessage", "Comment has been added successfully");
        return modelAndView;
    }
}
