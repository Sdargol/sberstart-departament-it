package org.sdargol.render;

public class RenderManager {
    private final static Render render = new Render();

    public static Render getRender(){
        return render;
    }
}
