package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.core.SigmaPiZeta;
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
        SigmaPiZeta.init(hardwareMap, true);
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver

        ToggleButtonReader bReader = new ToggleButtonReader(
                driverOp, GamepadKeys.Button.B
        );

        waitForStart();
        MecanumDrive drive = new MecanumDrive(
                SigmaPiZeta.frontLeft,
                SigmaPiZeta.frontRight,
                SigmaPiZeta.backLeft,
                SigmaPiZeta.backRight
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
//                        SigmaPiZeta.imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
//                        false
//                );
//            }
            if(gamepad1.dpad_left){
                SigmaPiZeta.wrist.forward();
            }
            else if(gamepad1.dpad_right){
                SigmaPiZeta.wrist.reverse();
            }

            if(gamepad1.left_bumper){
                SigmaPiZeta.shoulder.reverse();
            }
            else if(gamepad1.right_bumper){
                SigmaPiZeta.shoulder.forward();
            }
            else{
                SigmaPiZeta.shoulder.stop();
            }

            if(gamepad1.left_trigger>0){
                SigmaPiZeta.elbow.forward();
            }
            else if(gamepad1.right_trigger>0){
                SigmaPiZeta.elbow.reverse();
            }

            if(gamepad1.x){
                SigmaPiZeta.claw.forward();
            }
            else if(gamepad1.a){
                SigmaPiZeta.claw.reverse();
            }
            else{
                SigmaPiZeta.claw.stop();
            }

//            if(bReader.getState()){
//                SigmaPiZeta.shoulder.mult = -1;
//            }
            //TEST

            telemetry.addData("Mult", SigmaPiZeta.shoulder.mult);
            telemetry.update();
        }
    }
}