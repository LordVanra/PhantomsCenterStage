package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shoulder {

    private DcMotor shoulderMotor1;
    private DcMotor shoulderMotor2;


    private double targetPos;

    public void init(HardwareMap hwMap){

        shoulderMotor1 = hwMap.get(DcMotor.class, "sServo1");
        shoulderMotor2 = hwMap.get(DcMotor.class, "sServo2");
    }

    public void forward(){
        shoulderMotor1.setPower(0.4);
        shoulderMotor2.setPower(0.4);
    }

    public void reverse(){
        shoulderMotor1.setPower(-0.4);
        shoulderMotor2.setPower(-0.4);
    }

    public void stop(){
        shoulderMotor1.setPower(0.01);
        shoulderMotor2.setPower(0.01);
    }

}
