package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Elbow {

    private Servo elbowServo1;
    private Servo elbowServo2;

    private double targetPos1 = 0.8;
    private double targetPos2 = 0.2;

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

    public void init(HardwareMap hwMap){
        elbowServo1 = hwMap.get(Servo.class, "eServo1");
        elbowServo2 = hwMap.get(Servo.class, "eServo2");
    }

    public void forward(){
        targetPos1 -= 0.001;
        targetPos2 += 0.001;
    }

    public void reverse(){
        targetPos1 += 0.001;
        targetPos2 -= 0.001;
    }

    public void update(){
        elbowServo1.setPosition(targetPos1);
        elbowServo2.setPosition(targetPos2);
    }

    public double[] getPos(){
        return new double[] {targetPos1, targetPos2};
    }
}
