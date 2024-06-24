package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import static helper.Utility.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebPage {
    By input_appId = By.xpath("//input[@name='appId']");
    By input_userId = By.xpath("//input[@name='userId']");
    By input_nickname = By.xpath("//input[@name='nickname']");
    By click_copy = By.xpath("//button[normalize-space()='Copy']");
    By verify_url_accessible = By.xpath("(//span[@class='sendbird-channel-header__title__right__name sendbird-label sendbird-label--subtitle-2 sendbird-label--color-onbackground-1'])[1]");
    By click_add_channel = By.xpath("//button[@type='button']");
    By click_add_group = By.xpath("//div[@class='sendbird-add-channel__rectangle']");
    By add_user_to_new_channel(String newUser) {
        return By.xpath("//div[@class=' sendbird-user-list-item']//label[@for='"+ newUser +"']");
    }
    By click_create = By.xpath("//button[contains(@class,'sendbird-button--primary sendbird-button--big')]");
    By input_message = By.xpath("//div[@class='sendbird-message-input']//div[@id='sendbird-message-input-text-field']");
    By click_send_message = By.xpath("//button[@data-testid='sendbird-message-input-send-button']");
    By attach_file_message = By.xpath("//button[@class='sendbird-message-input--attach sendbird-iconbutton ']//span[@class='sendbird-iconbutton__inner']//input[@type='file']");
    By assert_text_message = By.xpath("//div[@class='sendbird-message-content__middle__body-container']//div[@class='sendbird-message-content__middle__message-item-body sendbird-text-message-item-body incoming  ']");
    By assert_img_message = By.xpath("//div[@class='sendbird-image-renderer__image']");
    By assert_file_message = By.xpath("//div[@class='sendbird-message-content__middle__message-item-body sendbird-file-message-item-body incoming  ']");

    public void openBrowser() {
        driver.get("https://sendbird-uikit-react.netlify.app/url-builder");
    }

    public void inputAppid(String appid) {
        driver.findElement(input_appId).sendKeys(appid);
    }

    public void inputUserid(String userid) {
        driver.findElement(input_userId).sendKeys(userid);
    }

    public void inputNickname(String nickname) {
        driver.findElement(input_nickname).sendKeys(nickname);
    }

    public void clickCopy() {
        driver.findElement(click_copy).click();
    }

    public void pasteAndNavigateToURL(String uid, String nick) throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://sendbird-uikit-react.netlify.app/group_channel?appId=37C8DB25-8B44-435F-A528-5BA9B9965FD0&userId=" + uid + "&nickname=" + nick);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(50000);
    }

    public void assertSuccessCreateUrl(String usrUrl) {
        String urlExpected = usrUrl;
        String urlActual = driver.findElement(verify_url_accessible).getText();
        assertThat(urlActual).isEqualTo(urlExpected);
    }

    public void createGroupWithOtherUser(String newUser) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(click_add_channel).click();
        driver.findElement(click_add_group).click();
        Thread.sleep(3000);
        driver.findElement(add_user_to_new_channel(newUser)).click();
        driver.findElement(click_create).click();
    }

    public void sendTextMessage(String msg) throws InterruptedException {
        driver.findElement(input_message).sendKeys(msg);
        driver.findElement(click_send_message).click();
        Thread.sleep(3000);
    }

    public void sendImgFile() throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Satoru-Gojo.jpeg"; //insert your image file to folder resources and paste the path
        driver.findElement(attach_file_message).sendKeys(filePath);
        Thread.sleep(3000);
    }

    public void sendTxtFile() throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/test.txt"; //insert your txt file to folder resources and paste the path
        driver.findElement(attach_file_message).sendKeys(filePath);
        Thread.sleep(3000);
    }

    public void assertReceiveTxtMsg() {

        driver.findElement(assert_text_message).isDisplayed();
    }

    public void assertReceiveImgMsg() {
        driver.findElement(assert_img_message).isDisplayed();
    }

    public void assertReceiveFileMsg() {
        driver.findElement(assert_file_message).isDisplayed();
    }
}
