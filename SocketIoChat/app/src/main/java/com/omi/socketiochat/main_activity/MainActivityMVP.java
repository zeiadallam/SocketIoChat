package com.omi.socketiochat.main_activity;



import com.omi.socketiochat.objects.Message;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface MainActivityMVP {

    interface View {

        void updateData(List<Message> messages);

        void showSnackbar(String error);

        void addLog(Message message);
        void addTyping(String username);
        void removeTyping(String username);
        void addMessage(Message message);

    }

    interface Presenter {

        void loadData(String lastId);

        void connectToServer(String mUsername);
        void disconnectFromServer();

        void newMessage(Message message);
        void typing(Message message);
        void stopTyping(Message message);

        void newMessageCallback();
        void typingCallback();
        void stopTypingCallback();
        void userJoinedCallback();
        void userLeftCallback();

        void rxUnsubscribe();

        boolean isConnected();

        void setView(MainActivityMVP.View view);
    }

    interface Model {

        Observable<List<Message>> loadData(String lastId);
        Observable<List<Message>> saveData(List<Message> messages);



        Observable<Message> newMessageCallback();
        Observable<Message> typingCallback();
        Observable<Message> stopTypingCallback();
        Observable<Message> userJoinedCallback();
        Observable<Message> userLeftCallback();

        Completable connectToServer(String mUsername);
        void disconnectFromServer();

        void newMessage(Message message);
        void typing(Message message);
        void stopTyping(Message message);

        boolean isConnected();

    }
}
