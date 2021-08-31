package org.firstinspires.ftc.teamcode.drive.structure;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

//Clasa pentru partea de outtake
public class Outtake {

    public DcMotor outtakeWing = null;
    public CRServo pushWing = null;

    public OuttakeModes RobotOuttake = OuttakeModes.STOP;

    public enum OuttakeModes{
        OUT,
        STOP,
        REVERSE,
    }

    public Outtake(){

    }

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        outtakeWing = hwMap.get(DcMotor.class, "Outtake_Wing");
        outtakeWing.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        outtakeWing.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        outtakeWing.setPower(0);

        pushWing = hwMap.crservo.get("Push_Wing");
        pushWing.setDirection(DcMotorSimple.Direction.FORWARD);
        pushWing.setPower(0);

    }

    public void update(){
        switch (RobotOuttake){
            case OUT:{
                outtakeWing.setPower(-0.85);
                pushWing.setPower(1.0);
                break;
            }
            case STOP:{
                outtakeWing.setPower(0);
                // TO DO seteaza puterea la STOP astfel incat sa nu se miste
                pushWing.setPower(0.01);
                break;
            }
            case REVERSE:{
                outtakeWing.setPower(0);
                pushWing.setPower(-1.0);
                break;
            }

        }
    }

    public void switchToOUT() {RobotOuttake = OuttakeModes.OUT;}

    public void switchToSTOP() {RobotOuttake = OuttakeModes.STOP;}
}
