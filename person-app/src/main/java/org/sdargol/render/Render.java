package org.sdargol.render;

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
}
