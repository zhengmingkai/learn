package org.apache.dubbo.test.generator;

/**
 * Created by zhengmk on 2018/7/30 0030.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.dubbo.common.bytecode.NoSuchPropertyException;
import org.apache.dubbo.common.bytecode.Wrapper;


public final class Wrapper1 extends Proxy {
    private static Method m4;
    private static Method m14;
    private static Method m12;
    private static Method m6;
    private static Method m10;
    private static Method m5;
    private static Method m7;
    private static Method m13;
    private static Method m9;
    private static Method m11;
    private static Method m8;
    private static Method m3;

    public Wrapper1(InvocationHandler var1) {
        super(var1);
    }


    public final Object getPropertyValue(Object var1, String var2) {
        try {
            return super.h.invoke(this, m4, new Object[]{var1, var2});
        } catch (RuntimeException | Error var4) {
            throw var4;
        } catch (Throwable var5) {
            throw new UndeclaredThrowableException(var5);
        }
    }

    public final Wrapper getWrapper(Class var1) {
        try {
            return (Wrapper)super.h.invoke(this, m14, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final Object[] getPropertyValues(Object var1, String[] var2)throws NoSuchPropertyException, IllegalArgumentException {
        try {
            return (Object[])super.h.invoke(this, m12, new Object[]{var1, var2});
        } catch (RuntimeException | Error var4) {
            throw var4;
        } catch (Throwable var5) {
            throw new UndeclaredThrowableException(var5);
        }
    }

    public final String[] getMethodNames() {
        try {
            return (String[])super.h.invoke(this, m6, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final boolean hasProperty(String var1) {
        try {
            return ((Boolean)super.h.invoke(this, m10, new Object[]{var1})).booleanValue();
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final void setPropertyValue(Object var1, String var2, Object var3) {
        try {
            super.h.invoke(this, m5, new Object[]{var1, var2, var3});
        } catch (RuntimeException | Error var5) {
            throw var5;
        } catch (Throwable var6) {
            throw new UndeclaredThrowableException(var6);
        }
    }

    public final Object invokeMethod(Object var1, String var2, Class[] var3, Object[] var4) throws InvocationTargetException {
        try {
            return super.h.invoke(this, m7, new Object[]{var1, var2, var3, var4});
        } catch (RuntimeException | InvocationTargetException | Error var6) {
            throw var6;
        } catch (Throwable var7) {
            throw new UndeclaredThrowableException(var7);
        }
    }

    public final boolean hasMethod(String var1) {
        try {
            return ((Boolean)super.h.invoke(this, m13, new Object[]{var1})).booleanValue();
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final String[] getDeclaredMethodNames() {
        try {
            return (String[])super.h.invoke(this, m9, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final void setPropertyValues(Object var1, String[] var2, Object[] var3) throws NoSuchPropertyException, IllegalArgumentException {
        try {
            super.h.invoke(this, m11, new Object[]{var1, var2, var3});
        } catch (RuntimeException | Error var5) {
            throw var5;
        } catch (Throwable var6) {
            throw new UndeclaredThrowableException(var6);
        }
    }

    public final String[] getPropertyNames() {
        try {
            return (String[])super.h.invoke(this, m8, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }


    public final Class getPropertyType(String var1) {
        try {
            return (Class)super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }
    static {
        try {
            m4 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getPropertyValue", new Class[]{Class.forName("java.lang.Object"), Class.forName("java.lang.String")});
            m14 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getWrapper", new Class[]{Class.forName("java.lang.Class")});
            m12 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getPropertyValues", new Class[]{Class.forName("java.lang.Object"), Class.forName("[Ljava.lang.String;")});
            m6 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getMethodNames", new Class[0]);
            m10 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("hasProperty", new Class[]{Class.forName("java.lang.String")});
            m5 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("setPropertyValue", new Class[]{Class.forName("java.lang.Object"), Class.forName("java.lang.String"), Class.forName("java.lang.Object")});
            m7 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("invokeMethod", new Class[]{Class.forName("java.lang.Object"), Class.forName("java.lang.String"), Class.forName("[Ljava.lang.Class;"), Class.forName("[Ljava.lang.Object;")});
            m13 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("hasMethod", new Class[]{Class.forName("java.lang.String")});
            m9 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getDeclaredMethodNames", new Class[0]);
            m11 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("setPropertyValues", new Class[]{Class.forName("java.lang.Object"), Class.forName("[Ljava.lang.String;"), Class.forName("[Ljava.lang.Object;")});
            m8 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getPropertyNames", new Class[0]);
            m3 = Class.forName("org.apache.dubbo.common.bytecode.Wrapper0").getMethod("getPropertyType", new Class[]{Class.forName("java.lang.String")});
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}

