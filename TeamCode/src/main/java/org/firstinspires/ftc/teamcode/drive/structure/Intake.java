package org.firstinspires.ftc.teamcode.drive.structure;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


// Clasa pentru partea de intake
public class Intake {

    public DcMotor intakeWing = null;

    public IntakeModes RobotIntake = IntakeModes.STOP;

    public enum IntakeModes{
        IN,
        OUT,
        STOP,
    }

    public Intake(){

    }

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;
        intakeWing = hwMap.get(DcMotor.class, "Intake_Wing");
        intakeWing.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeWing.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeWing.setPower(0);
    }

    public void update(){
        switch (RobotIntake){
            case IN:{
                intakeWing.setPower(-1.0);
                break;
            }
            case OUT:{
                intakeWing.setPower(1.0);
                break;
            }
            case STOP:{
                intakeWing.setPower(0);
                break;
            }
        }
    }

    public void switchToIN() {RobotIntake = IntakeModes.IN;}

    public void switchToOUT() {RobotIntake = IntakeModes.OUT;}

    public void switchToSTOP() {RobotIntake = IntakeModes.STOP;}
}
