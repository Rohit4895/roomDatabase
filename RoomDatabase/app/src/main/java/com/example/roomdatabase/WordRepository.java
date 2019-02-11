package com.example.roomdatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word){

        new insertAsynchTask(mWordDao).execute(word);
    }

    private static class insertAsynchTask extends AsyncTask<Word, Void, Void>{
        private WordDao mAsynchTaskDao;

        insertAsynchTask(WordDao wordDao){
            mAsynchTaskDao = wordDao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            mAsynchTaskDao.insert(words[0]);
            return null;
        }
    }
}
