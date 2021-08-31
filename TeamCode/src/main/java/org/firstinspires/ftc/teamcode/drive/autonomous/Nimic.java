package org.firstinspires.ftc.teamcode.drive.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(group = "Autonomous")
public class Nimic extends LinearOpMode {

    int n = 0;

    private ElapsedTime runtime = new ElapsedTime();
    public static double WHEEL_RADIUS = 5;

    public DcMotor BackLeft = null;
    public DcMotor FrontRight = null;
    public DcMotor FrontLeft = null;
    public DcMotor BackRight = null;
    public DcMotor OuttakeMotor = null;
    public CRServo PushServo = null;
    public DcMotor intakeWing = null;

    public int distance_math(int distance) {

        double circumferance = 2 * WHEEL_RADIUS * Math.PI;
        double rotation_needed = distance / circumferance;
        int driving_target = (int) (rotation_needed * 383.6);
        return driving_target;
    }

    @Override
    public void runOpMode() throws InterruptedException {

        BackLeft = hardwareMap.get(DcMotor.class, "Back_Left");
        FrontRight = hardwareMap.get(DcMotor.class, "Front_Right");
        FrontLeft = hardwareMap.get(DcMotor.class, "Front_Left");
        BackRight = hardwareMap.get(DcMotor.class, "Back_Right");

        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);

        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        BackLeft.setPower(0);
        FrontRight.setPower(0);
        FrontLeft.setPower(0);
        BackRight.setPower(0);

        OuttakeMotor = hardwareMap.get(DcMotor.class, "Outtake_Wing");
        OuttakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        OuttakeMotor.setPower(0);
        intakeWing = hardwareMap.get(DcMotor.class, "Intake_Wing");
        intakeWing.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeWing.setPower(0);

        PushServo = hardwareMap.get(CRServo.class, "Push_Wing");
        PushServo.setPower(0.01);

        while (isStarted()==false && isStopRequested()==false){
            waitForStart();

            sleep(n);


            BackLeft.setPower(0.7);
            FrontRight.setPower(0.7);
            FrontLeft.setPower(0.7);
            BackRight.setPower(0.7);
            runtime.reset();
            while(runtime.seconds() <= 1.15) {


            }
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            FrontLeft.setPower(0);
            BackRight.setPower(0);

            sleep(200);

            OuttakeMotor.setPower(-0.65);
            PushServo.setPower(1.0);
            runtime.reset();
            while (runtime.seconds() <= 15){

            }
            PushServo.setPower(0);
            OuttakeMotor.setPower(0);

            BackLeft.setPower(0.3);
            FrontLeft.setPower(0.3);
            BackRight.setPower(0.3);
            FrontRight.setPower(0.3);
            runtime.reset();
            while(runtime.seconds() <= 0.8 ) {

            }
            BackLeft.setPower(0);
            FrontLeft.setPower(0);
            BackRight.setPower(0);
            FrontRight.setPower(0);

            sleep(8000);

        }


    }
}
