package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
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

    private double targetPos;

    public void init(HardwareMap hwMap){

        elbowServo1 = hwMap.get(Servo.class, "eServo1");
        elbowServo2 = hwMap.get(Servo.class, "eServo2");
    }

    public void forward(){
        elbowServo1.setPosition(elbowServo1.getPosition()-0.001);
        elbowServo2.setPosition(elbowServo1.getPosition()+0.001);
    }

    public void reverse(){
        elbowServo1.setPosition(elbowServo1.getPosition()+0.001);
        elbowServo2.setPosition(elbowServo1.getPosition()-0.001);
    }

    public void stop(){
        elbowServo1.setPosition(elbowServo1.getPosition());
        elbowServo2.setPosition(elbowServo1.getPosition());
    }

    public double[] getPos(){
        double[] posArr = {elbowServo1.getPosition(), elbowServo2.getPosition()};
        return new double[] {elbowServo1.getPosition(), elbowServo2.getPosition()};
    }
}
