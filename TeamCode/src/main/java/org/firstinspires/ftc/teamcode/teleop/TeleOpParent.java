/** This is the code used for the field-centric driving tutorial
 This is by no means a perfect code
 There are a number of improvements that can be made
 So, feel free to add onto this and make it better
 */

package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
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
    DriveStyle.DriveType type = DriveStyle.DriveType.DRIVERORIENTED;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);

        telemetry.update();
    }
}