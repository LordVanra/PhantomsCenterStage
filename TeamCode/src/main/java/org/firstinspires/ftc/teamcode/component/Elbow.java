package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Elbow {

    private Servo elbowServo1;
    private Servo elbowServo2;

//    public enum Pos{
//        //Update Values
//        OUT(10),
//        COLLAPSED(0),
//        CLIMB(30),
//        PLACE(40);
//
//        int position;
//
//        Pos(int position) {
//            this.position = position;
//        }
//
//        public int getPosition() {
//            return position;
//        }
//    }

    private int targetPos;

    public void init(HardwareMap hwMap){

        elbowServo1 = hwMap.get(Servo.class, "eServo1");
        elbowServo2 = hwMap.get(Servo.class, "eServo2");
    }

    public void setTargetPosition(int position){
        targetPos = position;
    }

    public double getTargetPosition(){
        return targetPos;
    }

    public void update(){
        elbowServo1.setPosition(targetPos);
        elbowServo2.setPosition(targetPos);
    }
}
