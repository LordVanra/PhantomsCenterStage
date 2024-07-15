package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.SigmaPiZeta;

@Autonomous(name = "Longitude")
public class LongAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException{
        SigmaPiZeta.init(hardwareMap, false);
        waitForStart();

        while (!isStopRequested()){
            SigmaPiZeta.backLeft.setTargetDistance(10);
            SigmaPiZeta.frontLeft.setTargetDistance(10);
            SigmaPiZeta.backRight.setTargetDistance(10);
            SigmaPiZeta.frontRight.setTargetDistance(10);
        }
    }


}
