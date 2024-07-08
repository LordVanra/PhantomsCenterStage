package org.firstinspires.ftc.teamcode.core;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.component.Shoulder;
import org.firstinspires.ftc.teamcode.component.Claw;
import org.firstinspires.ftc.teamcode.component.Elbow;
import org.firstinspires.ftc.teamcode.component.Wrist;


public class Bot {
    public static HardwareMap hardwareMap;

    public static Motor frontLeft;
    public static Motor frontRight;
    public static Motor backLeft;
    public static Motor backRight;

    public static Wrist wrist;
    public static Elbow elbow;
    public static Claw claw;
    public static Shoulder shoulder;
//    public static imu imu;

    public static void init(HardwareMap hwMap, boolean initTeleOp) {

        hardwareMap = hwMap;

        wrist = new Wrist();
        wrist.init(hardwareMap);

        claw = new Claw();
        claw.init(hardwareMap);

        elbow = new Elbow();
        elbow.init(hardwareMap);

        shoulder = new Shoulder();
        shoulder.init(hardwareMap);

        frontLeft = new Motor(hwMap, "leftFront");
        frontRight = new Motor(hwMap, "rightFront");
        backLeft = new Motor(hwMap, "leftBack");
        backRight = new Motor(hwMap, "rightBack");

        frontLeft.setInverted(true);
        frontRight.setInverted(true);
        backLeft.setInverted(true);
        backRight.setInverted(true);

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }


    /**
     * Sleeps for the given amount of milliseconds, or until the thread is interrupted. This is
     * simple shorthand for the operating-system-provided {@link Thread#sleep(long) sleep()} method.
     *
     * @param milliseconds amount of time to sleep, in milliseconds
     * @see Thread#sleep(long)
     */
    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}