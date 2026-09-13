package org.firstinspires.ftc.teamcode.Opmodes.Teleops;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot.Robot;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "Main Teleop")
public class MainTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //test
        MyTelemetry.init(telemetry);
        Robot robot = new Robot(hardwareMap);

        GamepadEx gp1 = new GamepadEx(gamepad1);
        GamepadEx gp2 = new GamepadEx(gamepad2);


        waitForStart();

        while (opModeIsActive()) {


            robot.update();
            MyTelemetry.update();
        }
    }


}
