package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.arcrobotics.ftclib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.MyTelemetry;

import java.util.List;

public class Robot {
    //test
    private static ElapsedTime elapsedTime;
    public List<LynxModule> hubs;
    public double loopTime;
    public float Hz;

    public Robot(HardwareMap hardwareMap) {
        CommandScheduler.getInstance().reset();
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();

        hubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
        CommandScheduler.getInstance().registerSubsystem();

    }

    public void update() {
        CommandScheduler.getInstance().run();
        for(LynxModule hub : hubs){
            hub.clearBulkCache();
        }
        loopTime = elapsedTime.milliseconds();
        Hz = (float) (1000/loopTime);
        MyTelemetry.addData("Loop Time", loopTime);
        MyTelemetry.addData("Hz", Hz);
    }
}