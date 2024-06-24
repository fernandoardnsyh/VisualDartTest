package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPage;

public class WebStep {
    WebPage webPage;
    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("open Sendbird React UIKit URL Builder")
    public void openSendbirdReactUIKitURLBuilder() {
        webPage.openBrowser();
    }

    @And("user input appId {string}")
    public void userInputAppId(String appid) {
        webPage.inputAppid(appid);
    }

    @And("user input userId {string}")
    public void userInputUserId(String userid) {
        webPage.inputUserid(userid);
    }

    @And("user input nickname {string}")
    public void userInputNickname(String nickname) {
        webPage.inputNickname(nickname);
    }

    @And("user click copy to create URL link")
    public void copyUrlBuilder() {
        webPage.clickCopy();
    }

    @Given("user go to link builder {string}, {string}")
    public void goToUrlCopyBuilder(String uid, String nick) throws InterruptedException {
        webPage.pasteAndNavigateToURL(uid, nick);
    }

    @Then("verify user success open url {string}")
    public void verifyUserSuccessCreateUrlUserId(String usrUrl) {
        webPage.assertSuccessCreateUrl(usrUrl);
    }

    @And("create new group channel with add other user {string}")
    public void createNewGroupChannelWithOtherUser(String newUser) throws InterruptedException {
        webPage.createGroupWithOtherUser(newUser);
    }

    @And("user send text message {string}")
    public void userSendTextMessage(String msg) throws InterruptedException {
        webPage.sendTextMessage(msg);
    }

    @And("user send image file")
    public void userSendFile() throws InterruptedException {
        webPage.sendImgFile();
    }

    @And("user send txt file")
    public void userSendTxtFile() throws InterruptedException {
        webPage.sendTxtFile();
    }

    @Then("verify text message received")
    public void verifyMessageReceived() {
        webPage.assertReceiveTxtMsg();
    }

    @Then("verify image message received")
    public void verifyImageMessageReceived() {
        webPage.assertReceiveImgMsg();
    }

    @Then("verify file message received")
    public void verifyFileMessageReceived() {
        webPage.assertReceiveFileMsg();
    }
}
