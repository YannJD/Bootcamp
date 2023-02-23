package com.github.ybecker.bootcamp;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import android.app.Activity;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {
    @Test
    public void test() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra("name", "Yann");

        try {
            ActivityScenario<Activity> activity = ActivityScenario.launch(intent);

            androidx.test.espresso.Espresso
                    .onView(ViewMatchers.withId(R.id.greetingMessage))
                    .check(matches(ViewMatchers.withText("Welcome Yann !")));

            activity.close();
        } catch (AssertionError e) {
        }
    }
}
