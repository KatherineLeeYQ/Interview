package java.api;

/**
 * # Java常用类型转换
 * ## 基本数据类型
 * * 整型：byte(字节型) short(短整型) int(整型) long(长整型)
 * * 浮点型：float(单精度浮点型) double(双精度浮点型)
 * * 逻辑型：boolean(布尔型)
 * * 字符型：char(字符型)
 *
 * ## 对应包装类
 * * 整型：java.lang.Byte、java.lang.Short、java.lang.Integer、java.lang.Long
 * * 浮点型：java.lang.Float、java.lang.Double
 * * 逻辑型: java.lang.Boolean
 * * 字符型: java.lang.Character
 *
 * ## 与String相互转化
 * ### String转为基本类型
 * 使用包装类型的静态方法：
 * ```
 * String s = "123";
 * int i = Integer.parseInt(s);
 * long l = Long.parseLong(s);
 * double d = Double.parseDouble(s);
 * float f = Float.parseFloat(s);
 * ```
 * ### 基本类型转为String
 * 使用String的valueOf方法
 * ```
 * int i = 123;
 * long l = 123l;
 * float f = 123.456f;
 * double d = 123.456;
 *
 * String s_i = String.valueOf(i);
 * String s_l = String.valueOf(l);
 * String s_f = String.valueOf(f);
 * String s_d = String.valueOf(d);
 * ```
 */
public class CommonAPI {
}
