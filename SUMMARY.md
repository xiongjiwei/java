-  可以在数字中加入下划线方便阅读
-  显示转化与隐式转换表

|        | byte   | short  |  int   |  long  | float  | double |
|:------:|:------:|:-----: | :----: |:------:|:------:|:------:|
| byte   |        |隐      |隐      |隐       |隐      |隐      |
| short  |显      |        |隐      |隐       |隐      |隐      |
| int    |显      |显      |        |隐       |隐      |隐      |
| long   |显      |显      |显      |         |隐      |隐      |
| float  |显      |显      |显      |显       |        |隐      |
| double |显      |显      |显      |显       |显      |        |
 
-  `>>>` 不带符号的右移
-  `>>`  带符号的右移
- 未初始化的变量无法使用
- 类中的Filed未给出值时默认初始化为0(Primitive Type)

- float类型在数值后加上`f`表示float类型，`d`表示double，`L`表示long
- Double中存在Infinity和Nan. Infinity加任何数仍是Infinity,Nan不和任何数相等

- Java中的一个`char`16位
- `&&` `||` 有短路效果
- 位运算中`~`优先级最高`&`次之`|`最低
- Java中的数组都是某个类的实例
- Java中的String是不可改变的
- 一个CodePoint是一个真正意义上的字符,可以占1个或多个字节
- 如果需要对字符串多次拼接,最好使用StringBuilder或者StringBuffer
- Format String
```java
d - decimal integer
x - hexadecimal integer
o - octal integer
f - fixed-point floating point
e - exponential floating point
g - general floating point (the shorter of e and f)
a - hexadecimal floating point
s - string
c - character
b - boolean
h - hash code
n - platform dependent line separator
```
- Perfect Equals包括以下规则

>reflexive: for any non-null reference value x, x.equals(x) should return true.

>symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.

>transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
  
>consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.

>For any non-null reference value x, x.equals(null) should return false.
- 重写`equals`方法时也要重写`hashcode`方法

- 所有类都是Object的子类

- 实例化一个类时先执行父类构造函数,子类的构造函数中如果没有显式的调用自身或父类构造函数,此时会默认调用父类的无参构造函数,即使子类调用的是有参构造函数。
当子类的构造函数中显式的调用子类的其他构造函数时,会跳转到其他构造函数

- 类中的Field和Initialization Block会先于构造函数执行

- Class类中存储着实例的元数据,封装了一些对类的操作方法

- 使用Class.forName()或者一个instance.getClass得到实例的Class实例
 
- @interface表明这是一个注解

- 接口中的方法可以有一个默认实现, 使用default关键字修饰

- Lambda表达式是lazy的,等到求值时才真正的执行

- Lambda是一个匿名类

- 闭包中的变量不能更改值

- 被闭包捕获的变量会提升作用域
