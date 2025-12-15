package org.quantumbadger.redreader.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.quantumbadger.redreader.mvvm.model.Post;
import org.quantumbadger.redreader.mvvm.repository.PostRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Post>> posts;
    private PostRepository repository;

    public HomeViewModel() {
        repository = new PostRepository();
    }

    public LiveData<List<Post>> getPosts() {
        if (posts == null) {
            posts = repository.getPosts(); // load static posts
        }
        return posts;
    }

    public LiveData<List<Post>> getMorePosts() {
        return repository.getMorePosts();
    }
}
