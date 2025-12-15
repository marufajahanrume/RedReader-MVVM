package org.quantumbadger.redreader.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import org.quantumbadger.redreader.mvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    public MutableLiveData<List<Post>> getPosts() {
        MutableLiveData<List<Post>> data = new MutableLiveData<>();

        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("Funny Cat", "u/whiskers", "r/aww", "https://placekitten.com/400/400", 253));
//        posts.add(new Post("SpaceX Launch", "u/elonfan", "r/space", "https://placehold.co/400x400/black/white", 999));
//        posts.add(new Post("Programming Tip", "u/codeguru", "r/programming", "https://placehold.co/400x400/blue/white", 421));
//        posts.add(new Post("Nature Landscape", "u/earthlover", "r/pics", "https://placehold.co/400x400/green/white", 876));

        posts.add(new Post("Funny Cat", "u/whiskers", "r/aww",
                "https://placekitten.com/400/400",
                "https://www.reddit.com/r/aww/",
                253));

        posts.add(new Post("SpaceX Launch", "u/elonfan", "r/space",
                "https://placehold.co/400x400/black/white",
                "https://www.reddit.com/r/space/",
                999));

        posts.add(new Post("Programming Tip", "u/codeguru", "r/programming",
                "https://placehold.co/400x400/blue/white",
                "https://www.reddit.com/r/programming/",
                421));

        posts.add(new Post("Nature Landscape", "u/earthlover", "r/pics",
                "https://placehold.co/400x400/green/white",
                "https://www.reddit.com/r/pics/",
                876));


        data.setValue(posts);
        return data;
    }

    public MutableLiveData<List<Post>> getMorePosts() {
        MutableLiveData<List<Post>> data = new MutableLiveData<>();

        List<Post> posts = new ArrayList<>();
//        posts.add(new Post("Android MVVM Guide", "u/dev_dan", "r/androiddev", "https://placehold.co/400x400/orange/white?text=MVVM", 560));
//        posts.add(new Post("Beautiful Mountains", "u/hikerlife", "r/earth", "https://placehold.co/400x400/teal/white?text=Mountains", 812));
//        posts.add(new Post("Doggos Being Silly", "u/pupmaster", "r/aww", "https://placekitten.com/401/401", 692));
//        posts.add(new Post("Game of the Year?", "u/gamerpro", "r/gaming", "https://placehold.co/400x400/purple/white?text=Game", 1432));
//        posts.add(new Post("AI Makes Music", "u/technerd", "r/technology", "https://placehold.co/400x400/gray/white?text=AI", 934));
//        posts.add(new Post("Clean Desk Setup", "u/minimalist", "r/battlestations", "https://placehold.co/400x400/silver/black?text=Setup", 1240));
//        posts.add(new Post("New Space Photos", "u/nasa_updates", "r/space", "https://placehold.co/400x400/navy/white?text=Galaxy", 1763));
//        posts.add(new Post("Cooking Made Easy", "u/chefhome", "r/food", "https://placehold.co/400x400/red/white?text=Food", 422));
//        posts.add(new Post("Car Enthusiasts Unite", "u/gearhead", "r/cars", "https://placehold.co/400x400/yellow/black?text=Cars", 871));
//        posts.add(new Post("Photography Hacks", "u/lenslover", "r/photography", "https://placehold.co/400x400/black/white?text=Photo", 1095));
//        posts.add(new Post("Travel Vibes", "u/wanderlust", "r/travel", "https://placehold.co/400x400/skyblue/white?text=Travel", 965));
//        posts.add(new Post("RedReader Mock Post", "u/tester", "r/demoapp", "https://placehold.co/400x400/green/white?text=Demo", 310));
//        posts.add(new Post("Coding Setup Inspiration", "u/devguy", "r/programming", "https://placehold.co/400x400/blue/white?text=Setup", 870));
//        posts.add(new Post("Motivation Monday", "u/positivevibes", "r/motivation", "https://placehold.co/400x400/pink/white?text=Motivation", 532));
//        posts.add(new Post("Retro Tech Love", "u/vintagebyte", "r/retrotech", "https://placehold.co/400x400/brown/white?text=Retro", 299));

        posts.add(new Post("Android MVVM Guide", "u/dev_dan", "r/androiddev",
                "https://placehold.co/400x400/orange/white?text=MVVM",
                "https://www.reddit.com/r/androiddev/",
                560));

        posts.add(new Post("Beautiful Mountains", "u/hikerlife", "r/earth",
                "https://placehold.co/400x400/teal/white?text=Mountains",
                "https://www.reddit.com/r/earth/",
                812));

        posts.add(new Post("Doggos Being Silly", "u/pupmaster", "r/aww",
                "https://placekitten.com/401/401",
                "https://www.reddit.com/r/FunnyDogVideos/",
                692));

        posts.add(new Post("Game of the Year?", "u/gamerpro", "r/gaming",
                "https://placehold.co/400x400/purple/white?text=Game",
                "https://www.reddit.com/r/gaming/",
                1432));

        posts.add(new Post("AI Makes Music", "u/technerd", "r/technology",
                "https://placehold.co/400x400/gray/white?text=AI",
                "https://www.reddit.com/r/technology/",
                934));

        posts.add(new Post("Clean Desk Setup", "u/minimalist", "r/battlestations",
                "https://placehold.co/400x400/silver/black?text=Setup",
                "https://www.reddit.com/r/battlestations/",
                1240));

        posts.add(new Post("New Space Photos", "u/nasa_updates", "r/space",
                "https://placehold.co/400x400/navy/white?text=Galaxy",
                "https://www.reddit.com/r/space/",
                1763));

        posts.add(new Post("Cooking Made Easy", "u/chefhome", "r/food",
                "https://placehold.co/400x400/red/white?text=Food",
                "https://www.reddit.com/r/food/",
                422));

        posts.add(new Post("Car Enthusiasts Unite", "u/gearhead", "r/cars",
                "https://placehold.co/400x400/yellow/black?text=Cars",
                "https://www.reddit.com/r/cars/",
                871));

        posts.add(new Post("Photography Hacks", "u/lenslover", "r/photography",
                "https://placehold.co/400x400/black/white?text=Photo",
                "https://www.reddit.com/r/photography/",
                1095));

        posts.add(new Post("Travel Vibes", "u/wanderlust", "r/travel",
                "https://placehold.co/400x400/skyblue/white?text=Travel",
                "https://www.reddit.com/r/travel/",
                965));

        posts.add(new Post("RedReader Mock Post", "u/tester", "r/demoapp",
                "https://placehold.co/400x400/green/white?text=Demo",
                "https://www.reddit.com/r/demoapp/",
                310));

        posts.add(new Post("Coding Setup Inspiration", "u/devguy", "r/programming",
                "https://placehold.co/400x400/blue/white?text=Setup",
                "https://www.reddit.com/r/programming/",
                870));

        posts.add(new Post("Motivation Monday", "u/positivevibes", "r/motivation",
                "https://placehold.co/400x400/pink/white?text=Motivation",
                "https://www.reddit.com/r/motivation/",
                532));

        posts.add(new Post("Retro Tech Love", "u/vintagebyte", "r/retrotech",
                "https://placehold.co/400x400/brown/white?text=Retro",
                "https://www.reddit.com/r/retrotech/",
                299));


        data.setValue(posts);
        return data;
    }
}
