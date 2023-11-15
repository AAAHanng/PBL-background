package com.pbl.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;


/**
 * 用于转化vo对象
 * */
public interface BaseData {

    /**
     * 创建指定的VO类并将当前DTO对象中的所有成员变量值直接复制到VO对象中
     * @param clazz 指定VO类型
     * @param consumer 返回VO对象之前可以使用Lambda进行额外处理
     * @return 指定VO对象
     * @param <V> 指定VO类型
     */
    default <V> V asViewObject(Class<V> clazz, Consumer<V> consumer) {
        V v = this.asViewObject(clazz);
        consumer.accept(v);
        return v;
    }

    /**
     * 创建指定的VO类并将当前DTO对象中的所有成员变量值直接复制到VO对象中
     * @param clazz 指定VO类型
     * @return 指定VO对象
     * @param <V> 指定VO类型
     */
    default <V> V asViewObject(Class<V> clazz) {
        try {
            Field[] fields = clazz.getDeclaredFields();
            Constructor<V> constructor = clazz.getConstructor();
            // 获取一个类（clazz）中所有声明的字段（成员变量）的数组。getDeclaredFields() 方法返回一个 Field 类型的数组，该数组包含了类中所有字段的信息，包括字段的名称、类型、修饰符
            V v = constructor.newInstance();
            Arrays.asList(fields).forEach(field -> convert(field, v));
            return v;
        } catch (ReflectiveOperationException exception) {
            Logger logger = LoggerFactory.getLogger(BaseData.class);
            logger.error("在VO与DTO转换时出现了一些错误", exception);
            throw new RuntimeException(exception.getMessage());
        }
    }

    /**
     * 内部使用，快速将当前类中目标对象字段同名字段的值复制到目标对象字段上
     * @param field 目标对象字段
     * @param target 目标对象
     */
    private void convert(Field field, Object target){
        try {
            Field source = this.getClass().getDeclaredField(field.getName());
            field.setAccessible(true);
            source.setAccessible(true);
            field.set(target, source.get(this));
        } catch (IllegalAccessException | NoSuchFieldException ignored) {}
    }
}
