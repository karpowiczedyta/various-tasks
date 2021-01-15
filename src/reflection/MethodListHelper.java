package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MethodListHelper {

    public static void main(String[] args) {

        MethodListHelper methodListHelper = new MethodListHelper();

        Class aClass = SampleRepository.class;
        Collection<MethodInfo> collection = methodListHelper.listMethods(aClass, true, true);
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Name Of Method: " + ((MethodInfo) array[i]).getName());
            System.out.println("isAbstract?: " + ((MethodInfo) array[i]).isAbstract());
            System.out.println("ReturnType: " + ((MethodInfo) array[i]).getReturnType());
            for (int j = 0; j < ((MethodInfo) array[i]).getArgs().size(); j++) {
                List<Class> tmp = ((MethodInfo) array[i]).getArgs();
                Object[] tmpArray = tmp.toArray();
                System.out.println("ParameterTypes: " + ((Class) tmpArray[j]).getName());
            }
            System.out.println("====================");
        }


    }

    /**
     * Method returns methods metadata
     *
     * @param aClass            class to analyse
     * @param includeAbstract   should we include abstract methods
     * @param includeSuperclass should we include methods from the class we extend (only direct superclass)
     * @return collection of methods metadata
     */
    public Collection<MethodInfo> listMethods(Class aClass, boolean includeAbstract, boolean includeSuperclass) {
        List<Class> listOfParameterTypes;
        Collection<MethodInfo> returnedList = new ArrayList<>();
        if (!includeAbstract && !includeSuperclass) {
            Method[] method = aClass.getDeclaredMethods();

            for (int i = 0; i < method.length; i++) {
                method[i].setAccessible(true);
                int modifier = method[i].getModifiers();
                boolean isAbstract = Modifier.isAbstract(modifier);
                if (!isAbstract) {
                    String name = method[i].getName();
                    Class returnType = method[i].getReturnType();
                    Class[] parameterTypes = method[i].getParameterTypes();
                    listOfParameterTypes = Arrays.asList(parameterTypes);
                    returnedList.add(new MethodInfo(name, includeAbstract, listOfParameterTypes, returnType));
                }
            }
            return returnedList;
        } else {
            Method[] method = aClass.getDeclaredMethods();

            for (int i = 0; i < method.length; i++) {
                method[i].setAccessible(true);
                int modifier = method[i].getModifiers();
                boolean isAbstract = Modifier.isAbstract(modifier);
                String name = method[i].getName();
                Class returnType = method[i].getReturnType();
                Class[] parameterTypes = method[i].getParameterTypes();
                listOfParameterTypes = Arrays.asList(parameterTypes);
                returnedList.add(new MethodInfo(name, isAbstract, listOfParameterTypes, returnType));
            }

            Class abstractClass = aClass.getSuperclass();
            Method[] methodM = abstractClass.getDeclaredMethods();

            for (int i = 0; i < methodM.length; i++) {
                methodM[i].setAccessible(true);
                int modifier = methodM[i].getModifiers();
                boolean isAbstract = Modifier.isAbstract(modifier);
                String name = methodM[i].getName();
                Class returnType = methodM[i].getReturnType();
                Class[] parameterTypes = methodM[i].getParameterTypes();
                listOfParameterTypes = Arrays.asList(parameterTypes);
                returnedList.add(new MethodInfo(name, isAbstract, listOfParameterTypes, returnType));
            }

        }

        return returnedList;
    }

}
