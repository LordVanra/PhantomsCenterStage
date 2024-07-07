package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {

    private Servo wrist;
    private int pos;
    //Set Values

    public void init(HardwareMap hwmap){
        wrist = hwmap.get(Servo.class, "wrist");
    }

    public void setPos(){
        wrist.setPosition(pos);
    }

    public int getPos(){
        return pos;
    }

    public void update(){
        wrist.setPosition(pos);
    }

}
