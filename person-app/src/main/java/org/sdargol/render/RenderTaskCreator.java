package org.sdargol.render;

import java.util.Locale;

public class RenderTaskCreator {
    public static RenderTask create(String msg){
        String prefix = "[RENDER]: ";
        return () -> System.out.println(prefix + msg);
    }

    public static RenderTask create(String prefix, String msg){
        String p = "[" + prefix.toUpperCase(Locale.ROOT) + "]: ";
        return () -> System.out.println(p + msg);
    }
}
