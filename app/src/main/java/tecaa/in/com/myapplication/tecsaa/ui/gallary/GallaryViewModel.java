package tecaa.in.com.myapplication.tecsaa.ui.gallary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GallaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GallaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}