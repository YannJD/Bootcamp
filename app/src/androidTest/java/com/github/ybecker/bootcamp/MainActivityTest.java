package com.github.ybecker.bootcamp;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.*;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test() {
        Intents.init();

        ViewInteraction textInteraction = androidx.test.espresso.Espresso
                .onView(ViewMatchers.withId(R.id.mainName));
        textInteraction.perform(
                ViewActions.clearText(),
                ViewActions.typeText("Yann"),
                ViewActions.closeSoftKeyboard()
        );

        ViewInteraction buttonInteraction = androidx.test.espresso.Espresso
                .onView(ViewMatchers.withId(R.id.mainGoButton));
        buttonInteraction.perform(ViewActions.click());

        intended(allOf(
                hasExtra("name", "Yann"),
                hasComponent(GreetingActivity.class.getName()))
        );

        Intents.release();
    }
}
