package org.firstinspires.ftc.teamcode.drive.autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

@Autonomous(group = "Autonomous")
public class AtBuild extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    public static double WHEEL_RADIUS = 5;

    public DcMotor BackLeft = null;
    public DcMotor FrontRight = null;
    public DcMotor FrontLeft = null;
    public DcMotor BackRight = null;
    public DcMotor OuttakeMotor = null;
    public CRServo PushServo = null;
    public DcMotor intakeWing = null;
    NumberRing numberRing = new NumberRing();

    OpenCvCamera webcam;

    public int caz;

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

        PushServo = hardwareMap.get(CRServo.class, "Push_Wing");
        PushServo.setPower(0.02);

        intakeWing = hardwareMap.get(DcMotor.class, "Intake_Wing");
        intakeWing.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeWing.setPower(0);

        numberRing.init(hardwareMap);


        while (!isStarted()) {
            if (numberRing.ring_1 == 0 && numberRing.ring_4 == 0) {
                telemetry.addData("Cazul", 4);
                telemetry.update();
                caz = 4;
            }
            if (numberRing.ring_1 != 0 && numberRing.ring_4 == 0) {
                telemetry.addData("Cazul", 1);
                telemetry.update();
                caz = 1;
            }
            if (numberRing.ring_1 != 0 && numberRing.ring_4 != 0) {
                telemetry.addData("Cazul", 0);
                telemetry.update();
                caz = 0;
            }
        }

        waitForStart();

        numberRing.stopCamera(hardwareMap);

        if (isStopRequested()) return;

        switch (caz) {

            case 0: {
                //Se afla 0 inele pe teren
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

                OuttakeMotor.setPower(-1.0);
                runtime.reset();
                while (runtime.seconds() <= 1.5){

                }
                OuttakeMotor.setPower(0);

                BackLeft.setPower(-0.75);
                FrontRight.setPower(-0.75);
                FrontLeft.setPower(-0.75);
                BackRight.setPower(-0.75);
                runtime.reset();
                while(runtime.seconds() <= 0.15) {

                }
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);

                BackLeft.setPower(0.3);
                FrontLeft.setPower(-0.3);
                BackRight.setPower(-0.3);
                FrontRight.setPower(0.3);
                runtime.reset();
                while(runtime.seconds() <= 1.9 ) {

                }
                BackLeft.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                FrontRight.setPower(0);

                BackLeft.setPower(-0.25);
                FrontLeft.setPower(-0.25);
                BackRight.setPower(-0.25);
                FrontRight.setPower(-0.25);
                runtime.reset();
                while (runtime.seconds() <= 0.3){

                }
                BackLeft.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                FrontRight.setPower(0);

                BackLeft.setPower(-0.25);
                FrontLeft.setPower(-0.25);
                BackRight.setPower(0.25);
                FrontRight.setPower(0.25);
                runtime.reset();
                while (runtime.seconds() <= 0.18){

                }
                BackLeft.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                FrontRight.setPower(0);

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

                break;
            }

            case 1: {
                // Se afla 1 inel pe teren

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
                while (runtime.seconds() <= 2.2){

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

                break;
            }

            case 4: {
                // Se afla 4 inele pe teren
                BackLeft.setPower(0.8);
                FrontRight.setPower(0.8);
                FrontLeft.setPower(0.8);
                BackRight.setPower(0.8);
                runtime.reset();
                while(runtime.seconds() <= 1.75) {

                }
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);

                sleep(200);

                OuttakeMotor.setPower(-1.0);
                runtime.reset();
                while (runtime.seconds() <= 1.5){

                }
                OuttakeMotor.setPower(0);

                FrontLeft.setPower(-0.4);
                BackRight.setPower(-0.4);
                FrontRight.setPower(0.4);
                BackLeft.setPower(0.4);
                runtime.reset();
                while(runtime.seconds() <= 1.45) {

                }
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);


                BackLeft.setPower(-0.4);
                FrontRight.setPower(-0.4);
                FrontLeft.setPower(-0.4);
                BackRight.setPower(-0.4);
                runtime.reset();
                while(runtime.seconds() <= 1.60) {

                }
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);

                BackLeft.setPower(-0.25);
                FrontLeft.setPower(-0.25);
                BackRight.setPower(0.25);
                FrontRight.setPower(0.25);
                runtime.reset();
                while (runtime.seconds() <= 0.17){

                }
                BackLeft.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                FrontRight.setPower(0);

                OuttakeMotor.setPower(-0.67);
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
                while(runtime.seconds() <= 0.68 ) {

                }
                BackLeft.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                FrontRight.setPower(0);

                break;
            }
        }

    }

}