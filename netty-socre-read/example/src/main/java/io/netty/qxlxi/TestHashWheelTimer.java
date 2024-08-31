package io.netty.qxlxi;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/8/18 09:16
 */
public class TestHashWheelTimer {

    public static void main(String[] args) {
        // tickDuration : 时间间隔
        // TimeUnit : 单位
        // ticksPerWheel : 划分多少块  默认512
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS, 20);
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(Thread.currentThread().getName()+"\t hello");
            }
        }, 1, TimeUnit.SECONDS);

    }
}
