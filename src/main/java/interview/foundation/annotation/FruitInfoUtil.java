package interview.foundation.annotation;

import java.lang.reflect.Field;

/*注解处理器*/
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> aClass) {
        String strFruitProvider = "供应商信息";
        Field[] fields = aClass.getDeclaredFields();//通过反射获取处理注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                //注解信息的处理地方
                strFruitProvider = " 供应商编号：" + fruitProvider.id() + " 供应商名称:"+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
