package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "DaddyTeleOp")
public class TeleOpParent extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;
    //This bad boy
    DriveStyle.DriveType type = DriveStyle.DriveType.MECANUMARCADE;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver

        ToggleButtonReader bReader = new ToggleButtonReader(
                driverOp, GamepadKeys.Button.B
        );

        waitForStart();
        MecanumDrive drive = new MecanumDrive(
                Bot.frontLeft,
                Bot.frontRight,
                Bot.backLeft,
                Bot.backRight
        );

        while (opModeIsActive()) {

            //DRIVETRAIN STUFF
            if (type == DriveStyle.DriveType.MECANUMARCADE) {
                drive.driveRobotCentric(
                        power * driverOp.getLeftX(),
                        power * driverOp.getLeftY(),
                        power * driverOp.getRightX(),
                        false
                );
            }
//            else if (type == DriveStyle.DriveType.DRIVERORIENTED) {
//                drive.driveFieldCentric(
//                        power * (Math.pow(driverOp.getLeftX(), 3)),
//                        power * (Math.pow(driverOp.getLeftY(), 3)),
//                        turningMultiplier * power * (Math.pow(driverOp.getRightX(), 3)),
//                        Bot.imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
//                        false
//                );
//            }
            if(gamepad1.dpad_left){
                Bot.wrist.forward();
            }
            else if(gamepad1.dpad_right){
                Bot.wrist.reverse();
            }

            if(gamepad1.left_bumper){
                Bot.shoulder.reverse();
            }
            else if(gamepad1.right_bumper){
                Bot.shoulder.forward();
            }
            else{
                Bot.shoulder.stop();
            }

            if(gamepad1.left_trigger>0){
                Bot.elbow.forward();
            }
            else if(gamepad1.right_trigger>0){
                Bot.elbow.reverse();
            }

            if(gamepad1.x){
                Bot.claw.forward();
            }
            else if(gamepad1.a){
                Bot.claw.reverse();
            }
            else{
                Bot.claw.stop();
            }

//            if(bReader.getState()){
//                Bot.shoulder.mult = -1;
//            }
            //TEST

            telemetry.addData("Mult", Bot.shoulder.mult);
            telemetry.update();
        }
    }
}