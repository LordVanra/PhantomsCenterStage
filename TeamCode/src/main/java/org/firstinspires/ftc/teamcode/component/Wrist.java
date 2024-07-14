package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {

    private Servo wristServo;

    public void init(HardwareMap hwmap){
        wristServo = hwmap.get(Servo.class, "wrist");
    }

    public void forward(){
        wristServo.setPosition(wristServo.getPosition()+0.001);
    }

    public void reverse(){
        wristServo.setPosition(wristServo.getPosition()-0.001);
    }

    public void stop(){
        wristServo.setPosition(wristServo.getPosition());
    }

}
