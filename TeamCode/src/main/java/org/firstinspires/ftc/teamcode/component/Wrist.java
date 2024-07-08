package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {

    private CRServo wristServo;

    public void init(HardwareMap hwmap){
        wristServo = hwmap.get(CRServo.class, "wrist");
    }

    public void forward(){
        wristServo.setPower(0.4);
    }

    public void reverse(){
        wristServo.setPower(-0.4);
    }

    public void stop(){
        wristServo.setPower(0);
    }

}
