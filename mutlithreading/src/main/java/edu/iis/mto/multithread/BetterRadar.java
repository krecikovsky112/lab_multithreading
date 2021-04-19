package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private final int rocketCount;
    private final PatriotBattery battery;
    private final ExecutorService executorService;

    public BetterRadar(PatriotBattery battery, int rocketCount) {
        this.battery = battery;
        this.rocketCount = rocketCount;
        executorService = Executors.newSingleThreadExecutor();
    }

    public BetterRadar(PatriotBattery battery, int rocketCount, ExecutorService executorService) {
        this.battery = battery;
        this.rocketCount = rocketCount;
        this.executorService = executorService;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rocketCount);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        executorService.submit(launchPatriotTask);
    }

}
