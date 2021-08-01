package org.sdargol.render;

import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

//Если необходимо произвести рендер не из главного потока, то
//необходимо использовать данный класс
//Плюс данный класс лучше использовать для вывода результата команды
//Не ну а че, пусть будет рендер только после выполнения menu.execute(str) =)
public class Render {
    private final ConcurrentLinkedQueue<RenderTask> renderQueue;

    public Render() {
        this.renderQueue = new ConcurrentLinkedQueue<>();
    }

    public void offer(RenderTask task){
        renderQueue.offer(task);
    }

    public synchronized void start(){
        while(!renderQueue.isEmpty()){
            renderQueue.poll().complete();
        }
    }

    //метод для "быстрого рендера"
    //использовать, когда надо сразу вывести результат в консоль (например предложение о вводе данных)
    public static void print(String prefix, String msg, boolean newLine){
        String str = "[" + prefix.toUpperCase(Locale.ROOT) + "]: " + msg;
        if(newLine){
            System.out.println(str);
            return;
        }
        System.out.print(str);
    }
}
