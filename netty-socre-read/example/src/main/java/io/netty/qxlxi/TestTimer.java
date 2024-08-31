package io.netty.qxlxi;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 1.task queue timer
 * 2.数据以什么顺序添加到queue?
 * @author qxlx
 * @date 2024/8/15 21:35
 */
@Slf4j
public class TestTimer extends TimerTask{

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TestTimer(),6000);
        timer.schedule(new TestTimer(),3000);
        timer.schedule(new TestTimer(),9000);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"\t timer");
    }

}
