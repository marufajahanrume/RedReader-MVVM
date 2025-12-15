package org.quantumbadger.redreader.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.quantumbadger.redreader.mvvm.model.DetailItem;
import org.quantumbadger.redreader.mvvm.repository.DetailRepository;

import java.util.List;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<List<DetailItem>> details;
    private DetailRepository repository = new DetailRepository();

    public LiveData<List<DetailItem>> getDetails(String category) {
        if (details == null) {
            details = repository.getDetailsForCategory(category);
        }
        return details;
    }
}
