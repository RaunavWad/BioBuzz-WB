package org.firstinspires.ftc.teamcode;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MyTelemetry {
    public static MultipleTelemetry telemetry;
    public static void init(Telemetry tele) {
        telemetry = new MultipleTelemetry(tele, FtcDashboard.getInstance().getTelemetry());

    }
    public static void addData(String key, Object value){
        telemetry.addData(key, value);
    }

    public static void update(){
        telemetry.update();
    }
}