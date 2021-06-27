package org.firstinspires.ftc.teamcode.drive.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(group = "Autonomous")
public class Case1 extends LinearOpMode {

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
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
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
        PushServo.setPower(0.02);

        while (isStarted()==false && isStopRequested()==false){
            waitForStart();



            FrontLeft.setPower(0.3);
            BackLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackRight.setPower(0.3);
            runtime.reset();
            while (runtime.seconds() <= 2.8){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            FrontLeft.setPower(-0.3);
            BackLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackRight.setPower(-0.3);
            runtime.reset();
            while (runtime.seconds() <= 2){

            }

            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            FrontLeft.setPower(0.9);
            BackLeft.setPower(0.9);
            FrontRight.setPower(0.9);
            BackRight.setPower(0.9);
            runtime.reset();
            while (runtime.seconds() <= 0.4){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            sleep(200);

            OuttakeMotor.setPower(-1.0);
            runtime.reset();
            while (runtime.seconds() <= 1.5){

            }
            OuttakeMotor.setPower(0);

            FrontLeft.setPower(-0.3);
            BackLeft.setPower(-0.3);
            FrontRight.setPower(-0.3);
            BackRight.setPower(-0.3);
            runtime.reset();
            while (runtime.seconds() <= 1.4){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            FrontLeft.setPower(-0.3);
            BackLeft.setPower(-0.3);
            FrontRight.setPower(0.3);
            BackRight.setPower(0.3);
            runtime.reset();
            while (runtime.seconds() <= 0.20){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            PushServo.setPower(1);
            OuttakeMotor.setPower(-0.66);
            runtime.reset();
            while (runtime.seconds() <= 10){

            }

            PushServo.setPower(0);
            OuttakeMotor.setPower(0);

            FrontLeft.setPower(-0.2);
            BackLeft.setPower(-0.2);
            FrontRight.setPower(0.2);
            BackRight.setPower(0.2);
            runtime.reset();
            while (runtime.seconds() <= 0.1){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);



            FrontLeft.setPower(-0.4);
            BackLeft.setPower(0.4);
            FrontRight.setPower(0.4);
            BackRight.setPower(-0.4);
            runtime.reset();
            while (runtime.seconds() <= 0.45){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);


            intakeWing.setPower(-1.0);
            FrontLeft.setPower(-0.4);
            BackLeft.setPower(-0.4);
            FrontRight.setPower(-0.4);
            BackRight.setPower(-0.4);
            runtime.reset();
            while (runtime.seconds() <= 1.2){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            FrontLeft.setPower(0.4);
            BackLeft.setPower(0.4);
            FrontRight.setPower(0.4);
            BackRight.setPower(0.4);
            runtime.reset();
            while (runtime.seconds() <= 1.0){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);

            FrontLeft.setPower(-0.3);
            BackLeft.setPower(-0.3);
            FrontRight.setPower(0.3);
            BackRight.setPower(0.3);
            runtime.reset();
            while (runtime.seconds() <= 0.1){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);



            OuttakeMotor.setPower(-0.69);
            PushServo.setPower(1.0);
            runtime.reset();
            while (runtime.seconds() <= 6.6){

            }
            OuttakeMotor.setPower(0);
            PushServo.setPower(0);
            intakeWing.setPower(0);

            FrontLeft.setPower(0.85);
            BackLeft.setPower(0.85);
            FrontRight.setPower(0.85);
            BackRight.setPower(0.85);
            runtime.reset();
            while (runtime.seconds() <= 0.25){

            }
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);














        }


    }
}
