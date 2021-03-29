package ca.unb.mobiledev.openlegendrpg.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;
import java.util.concurrent.ExecutionException;

import ca.unb.mobiledev.openlegendrpg.Items.User;
import ca.unb.mobiledev.openlegendrpg.repositories.userRepo;


public class userViewModel extends AndroidViewModel {
    private final userRepo userRepository;
    private Application application;

    public userViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        userRepository = new userRepo(application);
    }

    public List<User> isUser(String name, String password) throws ExecutionException, InterruptedException {
        List<User> isUser = userRepository.verifiedUser(name, password);
        return isUser;
    }

    public boolean createUser(String name, String password, String email) throws ExecutionException, InterruptedException {
        boolean created = userRepository.insertRecord(name, password, email);
        return created;
    }
}