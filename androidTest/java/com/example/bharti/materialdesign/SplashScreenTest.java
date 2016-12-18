package com.example.bharti.materialdesign;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SplashScreenTest {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void splashScreenTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.musicButton), withText("Play Music"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.drawer_layout)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.musicButton), withText("Pause"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.drawer_layout)))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.navigate), withContentDescription("next"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button2), withText("Pick from Gallery"),
                        withParent(allOf(withId(R.id.linlayout),
                                withParent(withId(R.id.activity_sub)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button4), withText("Download Image"),
                        withParent(allOf(withId(R.id.activity_sub),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.button3), withText("Take picture"),
                        withParent(allOf(withId(R.id.linlayout),
                                withParent(withId(R.id.activity_sub)))),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(allOf(withId(R.id.appBar),
                                withParent(withId(R.id.activity_sub)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Help"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.musicButton), withText("Play Music"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.drawer_layout)))),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.musicButton), withText("Pause"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(R.id.drawer_layout)))),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.activity_main),
                        childAtPosition(
                                allOf(withId(R.id.drawer_layout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.navigate), withContentDescription("next"), isDisplayed()));
        actionMenuItemView2.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
