package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {

    public CRServo clawServo;

    public void init(HardwareMap hwMap){
        clawServo = hwMap.get(CRServo.class, "claw");
    }

    public void forward(){
        clawServo.setPower(0.1);
    }

    public void reverse(){
        clawServo.setPower(-0.1);
    }

    public void stop(){
        clawServo.setPower(0);
    }
}