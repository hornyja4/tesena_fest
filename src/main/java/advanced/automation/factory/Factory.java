package advanced.automation.factory;

import advanced.automation.driver.Driver;
import advanced.automation.objects.PageObject;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.time.Duration;

@SuppressWarnings("unchecked")
public class Factory {

    public static void processPageObjectComponents(PageObject pageObject) {
        Class<PageObject> klass = (Class<PageObject>) pageObject.getClass();
        processClassComponents(klass, pageObject);
        while (!(klass = (Class<PageObject>) klass.getSuperclass()).equals(PageObject.class)) {
            processClassComponents(klass, pageObject);
        }
    }

    private static void processClassComponents(Class<PageObject> klazz, PageObject pageObject) {
        for (Field field: klazz.getDeclaredFields()) {
            if (isPageObject(field)) {
                PageObject object = null;
                try {
                    object = field.getType().asSubclass(PageObject.class).newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(true);
                try {
                    field.set(pageObject, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isPageObject(Field field) {
        Class fieldType = field.getType();
        while ((fieldType = fieldType.getSuperclass()) != PageObject.class) {
            if (fieldType == null) {
                return false;
            }
        }
        return true;
    }

    public static void initElements(PageObject object) {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(5)), object);
    }
}
