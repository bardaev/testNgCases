import io.qameta.allure.Step;
import org.testng.Assert;

public class Steps {

    @Step(value = "Проверка имени")
    public static void checkName(String actual, String excepted) {
        Assert.assertEquals(actual, excepted);
    }

    @Step(value = "Проверка email")
    public static void checkEmail(String actual, String excepted) {
        Assert.assertEquals(actual, excepted);
    }

    @Step(value = "Проверка хобби")
    public static void checkHobby(String actual, String excepted) {
        Assert.assertEquals(actual, excepted);
    }

    @Step(value = "Проверка телефона")
    public static void checkPhone(String actual, String excepted) {
        Assert.assertEquals(actual, excepted);
    }

    @Step(value = "Проверка на наличие ошибки")
    public static void checkError(Object o) {
        Assert.assertNull(o);
    }

    @Step(value = "Проверка на наличие ошибки после создания одинаковых данных")
    public static void checkError(String actual, String excepted) {
        Assert.assertEquals(actual, excepted);
    }
}
