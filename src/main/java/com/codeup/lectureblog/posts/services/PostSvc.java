package com.codeup.lectureblog.posts.services;


import com.codeup.lectureblog.posts.models.Post;
import com.codeup.lectureblog.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostSvc {

    private final PostRepository postDao;

    public PostSvc(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public void delete(long id) {
        postDao.deleteById(id);
    }

}
