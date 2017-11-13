package com.notcmput301.habitbook;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;


/**
 * Created by shang on 10/21/2017.
 */

public class LoginActivityTest extends ActivityInstrumentationTestCase2{


    private Solo solo;


    public LoginActivityTest(){
        super(LoginActivity.class);
    }


    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation() , getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void test_missing() throws Exception {
        //When there are missing fields expect return msg "Some fields are missing"
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.clickOnButton("login");
        assertTrue(solo.waitForText("Some fields are missing"));
        solo.enterText((EditText) solo.getView(R.id.login_username),"abc");
        solo.clickOnButton("login");
        assertTrue(solo.waitForText("Some fields are missing"));
        solo.enterText((EditText) solo.getView(R.id.login_password),"abc");
        solo.clearEditText((EditText) solo.getView(R.id.login_username));
        solo.clickOnButton("login");
        assertTrue(solo.waitForText("Some fields are missing"));
    }

    public void test_wrongPassword() throws Exception{
        //When the password is wrong
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.clearEditText((EditText) solo.getView(R.id.login_username));
        solo.clearEditText((EditText) solo.getView(R.id.login_password));

        solo.enterText((EditText) solo.getView(R.id.login_username),"testcode");
        solo.enterText((EditText) solo.getView(R.id.login_password),"wrongpwd");
        solo.clickOnButton("login");
        assertTrue(solo.waitForText("Check password or internet connection"));

    }

    public void test_login() throws Exception{
        //attempt login
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.clearEditText((EditText) solo.getView(R.id.login_username));
        solo.clearEditText((EditText) solo.getView(R.id.login_password));

        solo.enterText((EditText) solo.getView(R.id.login_username),"testcode");
        solo.enterText((EditText) solo.getView(R.id.login_password),"testpassword");
        solo.clickOnButton("login");
        assertTrue(solo.waitForText("Logged in"));
        assertTrue(solo.waitForActivity(MainMenuActivity.class));
        solo.assertCurrentActivity("Not Main menu Activity", MainMenuActivity.class);
        solo.clickOnButton("Logout");
        assertTrue(solo.waitForActivity(LoginActivity.class));
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
    }

    public void test_register() throws Exception{
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.clickOnButton("sign up");
        solo.waitForActivity(CreateAccountActivity.class);
        solo.assertCurrentActivity("Not Create account Activity", CreateAccountActivity.class);
    }

    public void test_tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}