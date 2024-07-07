package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    public Servo claw;

    private double OPEN;
    private double CLOSE;

    public void init(HardwareMap hwMap){
        OPEN=0.125;
        CLOSE=0;

        claw = hwMap.get(Servo.class, "claw");
    }

    public void open(){
        claw.setPosition(OPEN);
    }

    public void close(){
        claw.setPosition(CLOSE);
    }

    public double getPos(){
        return claw.getPosition();
    }
}