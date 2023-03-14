package com.example.jokesingleservingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.jokesingleservingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private List<JokeStoryEntity> listStories = new ArrayList<>();
    protected int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data binding
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        //get data from database
        listStories = JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().getAll() ;

        data();
        event();
    }

    private void data(){
        //if data is doesn't exist. create it
        if(listStories.isEmpty() || listStories.size() == 0){
            JokeStoryEntity story1 = new JokeStoryEntity("A child asked his father, \"How were people born?\" So his father said, \"Adam and Eve made babies, then their babies became adults and made babies, and so on.\"\n" +
                    "\n" +
                    "The child then went to his mother, asked her the same question and she told him, \"We were monkeys then we evolved to become like we are now.\"\n" +
                    "\n" +
                    "The child ran back to his father and said, \"You lied to me!\" His father replied, \"No, your mom was talking about her side of the family.\"", false);
            JokeStoryEntity story2 = new JokeStoryEntity("Teacher: \"Kids,what does the chicken give you?\" Student: \"Meat!\" Teacher: \"Very good! Now what does the pig give you?\" Student: \"Bacon!\" Teacher: \"Great! And what does the fat cow give you?\" Student: \"Homework!\"",false);
            JokeStoryEntity story3 = new JokeStoryEntity("The teacher asked Jimmy, \"Why is your cat at school today Jimmy?\" Jimmy replied crying, \"Because I heard my daddy tell my mommy, 'I am going to eat that pussy once Jimmy leaves for school today!'\"",false);
            JokeStoryEntity story4 = new JokeStoryEntity("A housewife, an accountant and a lawyer were asked \"How much is 2+2?\" The housewife replies: \"Four!\". The accountant says: \"I think it's either 3 or 4. Let me run those figures through my spreadsheet one more time.\" The lawyer pulls the drapes, dims the lights and asks in a hushed voice, \"How much do you want it to be?\"",false);

            JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().insertJokeStory(story1);
            JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().insertJokeStory(story2);
            JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().insertJokeStory(story3);
            JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().insertJokeStory(story4);
            listStories = JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().getAll() ;
        }
    }
    private void event() {
        //show first story
        activityMainBinding.textViewJoke.setText(listStories.get(index).getContent());

        activityMainBinding.buttonPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index < listStories.size()){
                    int tempUpVote =  listStories.get(index).getUpVote() + 1;
                    listStories.get(index).setUpVote(tempUpVote);
                    JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().updateVote(listStories.get(index));
                    activityMainBinding.textViewJoke.setText(listStories.get(index).getContent());
                }else{
                    activityMainBinding.textViewJoke.setText("That's all the jokes for today! \n Comeback another day ");
                }
            }
        });

        activityMainBinding.buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index < listStories.size()){
                    int tempDownVote =  listStories.get(index).getDownVote() + 1;
                    listStories.get(index).setDownVote(tempDownVote);
                    JokeStoryDatabase.getInstance(MainActivity.this).getJokeStoryDAO().updateVote(listStories.get(index));
                    activityMainBinding.textViewJoke.setText(listStories.get(index).getContent());
                }else{
                    activityMainBinding.textViewJoke.setText("That's all the jokes for today! \n Comeback another day ");
                }
            }
        });

        }
}
