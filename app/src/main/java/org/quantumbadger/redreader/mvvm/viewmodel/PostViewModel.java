package org.quantumbadger.redreader.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.quantumbadger.redreader.mvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel extends ViewModel {
    private final MutableLiveData<List<Post>> posts = new MutableLiveData<>();

    public PostViewModel() {
        loadPosts();
    }

    private void loadPosts() {
//        List<Post> list = new ArrayList<>();
//        list.add(new Post("Front Page", "Your curated front page."));
//        list.add(new Post("All Posts", "Everything, everywhere, all at once."));
//        list.add(new Post("Science", "Discussions, papers, breakthroughs."));
//        list.add(new Post("Books", "For book lovers and reviews."));
//        list.add(new Post("Technology", "Trends, gadgets, programming."));
//        list.add(new Post("Art", "Share and admire artworks."));
//        posts.setValue(list);
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }
}
