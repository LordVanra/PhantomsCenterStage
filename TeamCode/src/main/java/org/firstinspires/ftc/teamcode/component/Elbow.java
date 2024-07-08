package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Elbow {

    private CRServo elbowServo1;
    private CRServo elbowServo2;

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

        elbowServo1 = hwMap.get(CRServo.class, "eServo1");
        elbowServo2 = hwMap.get(CRServo.class, "eServo2");
    }

    public void forward(float power){
        elbowServo1.setPower(3.5*power/5);
        elbowServo2.setPower(3.5*power/5);
    }

    public void reverse(float power){
        elbowServo1.setPower(-1.5*power/5);
        elbowServo2.setPower(-1.5*power/5);
    }

    public void stop(){
        elbowServo1.setPower(0.1);
        elbowServo2.setPower(0.1);
    }
}
