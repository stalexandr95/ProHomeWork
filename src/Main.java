import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Reflex {
    @Test(a = 2, b = 5)
    public static void num(int a, int b) {
        System.out.println(a);
        System.out.println(b);
    }
}

public class Main {
        public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

            Class<?> cls = Reflex.class;

            Method[] methods = cls.getDeclaredMethods();

            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    Test test = m.getAnnotation(Test.class);
                    int res;
                    m.invoke(null, test.a(), test.b());
                    System.out.println(test);
                }
            }

        }
    }
