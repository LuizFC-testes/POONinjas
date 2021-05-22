public class MainTester {
    public static void main(String []args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class dataClass = Class.forName("Data");
        Class[] paramTypes = {int.class, int.class, int.class};
        var data = dataClass.getConstructor(paramTypes).newInstance(2, 3, 1998);
        System.out.println(data);
    }
}