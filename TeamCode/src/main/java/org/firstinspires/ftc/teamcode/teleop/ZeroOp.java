package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ZeroServoSetter")
public class ZeroOp extends LinearOpMode {

    Servo zero;

    @Override
    public void runOpMode() throws InterruptedException {

        zero = hardwareMap.get(Servo.class, "claw");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        waitForStart();

        while (opModeIsActive()) {

            zero.setPosition(gamepad1.left_stick_x);
            telemetry.addData("0 pos?", zero.getPosition());
            telemetry.update();
        }
    }
}