package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {

    private Servo wristServo;

    private double targetPos = 0.65;

    public void init(HardwareMap hwmap){
        wristServo = hwmap.get(Servo.class, "wrist");
    }

    public void forward(){
        targetPos += 0.001;
    }

    public void reverse(){
        targetPos -= 0.001;
    }

    public double getPos(){
        return targetPos;
    }

    public void update(){
        wristServo.setPosition(targetPos);
    }
}
