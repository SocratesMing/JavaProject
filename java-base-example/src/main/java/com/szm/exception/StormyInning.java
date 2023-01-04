package com.szm.exception;

//定义三个异常，有继承关系
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}


abstract class Inning {
    public Inning() throws BaseballException {}

    public void event() throws BaseballException {}

    public abstract void atBat() throws Strike, Foul;

    public void walk() {}  //没有抛出异常
}

class StormException extends Exception { }

class RainedOut extends StormException { }

class PopFoul extends Foul { }

interface Storm {
    public void event() throws RainedOut;   //与抽象类的函数名相同，且抛出的异常不同，不建议这样写

    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    //子类的构造函数上可以抛出父类构造函数抛出异常的子类，或增加新的异常
    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws Foul, BaseballException {}


    // void walk() throws PopFoul {} //编译错误，因为被重写的函数没有抛出异常

    // public void event() throws RainedOut {}  //编译错误，接口无法为基类中的同名方法添加异常：

    public void rainHard() throws RainedOut {}  //如果方法在父类中没有,可以按照接口的写

    public void event() {}  //父类中的方法抛出异常，子类可以不抛出异常

    // 子类重写方法可以抛出子类异常
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {

            Inning i = new StormyInning();  //向上造型
            i.atBat();  //必须捕捉父类方法抛出的异常
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}