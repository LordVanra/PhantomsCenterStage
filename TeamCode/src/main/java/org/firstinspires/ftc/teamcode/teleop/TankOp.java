package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TankOp")
public class TankOp extends LinearOpMode {

    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public Boolean mode;

    public double leftPower;
    public double rightPower;

    @Override
    public void runOpMode() throws InterruptedException {
        GamepadEx driverOp = new GamepadEx(gamepad1);

        ToggleButtonReader aReader = new ToggleButtonReader(
                driverOp, GamepadKeys.Button.A
        );

        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor = hardwareMap.get(DcMotor.class, "right");

        waitForStart();

        while (opModeIsActive()) {

            if(aReader.getState()){
                mode = !mode;
            }

            if(mode){
                leftPower = gamepad1.left_stick_y + gamepad1.right_stick_y;
                rightPower = gamepad1.left_stick_y - gamepad1.right_stick_y;
            }
            else{
                leftPower = gamepad1.left_stick_y;
                rightPower = gamepad1.right_stick_y;
            }

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            aReader.readValue();
        }
    }
}