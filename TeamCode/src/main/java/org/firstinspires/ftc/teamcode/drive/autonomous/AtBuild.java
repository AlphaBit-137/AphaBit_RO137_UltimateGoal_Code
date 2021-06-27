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

    OpenCvCamera webcam;

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

        //Initializari camera

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        webcam.openCameraDevice();
        // Loading pipeline
        RingPipeline visionPipeline = new RingPipeline();
        webcam.setPipeline(visionPipeline);
        webcam.openCameraDevice();
        
            try {
                // Start streaming the pipeline
                webcam.startStreaming(320,240, OpenCvCameraRotation.UPRIGHT);
            }catch (Exception e){
                telemetry.addLine("Something went wrong");
                telemetry.update();
                while (isStarted()==false && isStopRequested()==false)
                {
                    waitForStart();

                    //Case 4
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
                }
            }


        while (isStarted()==false && isStopRequested()==false) {

            waitForStart();

            if (visionPipeline.ring1==0 && visionPipeline.ring4==0)
            {
                //CASE 4

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


            }
            else
                if (visionPipeline.ring1!=0 && visionPipeline.ring4==0)
                {
                    //CASE 1

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
                }
                else
                {
                    //CASE 0

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

                }

        }

        if (isStopRequested()==true)
        {
            webcam.closeCameraDevice();
        }
    }

class RingPipeline extends OpenCvPipeline {


    // Working Mat variables
    Mat YCrCb = new Mat(); // This will store the whole YCrCb channel
    Mat Cb = new Mat(); // This will store the Cb Channel (part from YCrCb)
    Mat tholdMat = new Mat(); // This will store the threshold

    // Drawing variables
    Scalar GRAY = new Scalar(220, 220, 220); // RGB values for gray.
    Scalar GREEN = new Scalar(0, 255, 0); // RGB values for green.

    // Variables that will store the results of our pipeline
    public int ring1;
    public int ring4;

    // Space which we will annalise data
    public Point BigSquare1 = new Point(90, 216);
    public Point BigSquare2 = new Point(1, 177);

    public Point SmallSquare1 = new Point(90, 200);
    public Point SmallSquare2 = new Point(1, 180);

    @Override
    public Mat processFrame(Mat input) {

        // Img processing
        Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_BGR2YCrCb);
        Core.extractChannel(YCrCb, Cb, 2);
        Imgproc.threshold(Cb, tholdMat, 134, 255, Imgproc.THRESH_BINARY_INV);

        // Drawing Points
        int BigSquarePointX = (int) ((BigSquare1.x + BigSquare2.x) / 2);
        int BigSquarePointY = (int) ((BigSquare1.y + SmallSquare1.y) / 2);

        int SmallSquarePointX = (int) ((SmallSquare1.x + SmallSquare2.x) / 2);
        int SmallSquarePointY = (int) ((SmallSquare1.y + SmallSquare2.y) / 2);

        double[] bigSquarePointValues = tholdMat.get(BigSquarePointY, BigSquarePointX);
        double[] smallSquarePointValues = tholdMat.get(SmallSquarePointY, SmallSquarePointX);

        ring4 = (int) bigSquarePointValues[0];
        ring1 = (int) smallSquarePointValues[0];


        // Big Square
        Imgproc.rectangle(
                input,
                BigSquare1,
                BigSquare2,
                GRAY,
                1
        );

        // Small Square
        Imgproc.rectangle(
                input,
                SmallSquare1,
                SmallSquare2,
                GRAY,
                1
        );

        // Big Square Point
        Imgproc.circle(
                input,
                new Point(BigSquarePointX, BigSquarePointY),
                2,
                GRAY,
                1
        );

        // Small Square Point
        Imgproc.circle(
                input,
                new Point(SmallSquarePointX, SmallSquarePointY),
                2,
                GRAY,
                1
        );

        // Change colors if the pipeline detected something

        if (ring1 == 0 && ring4 == 0) {
            Imgproc.rectangle(
                    input,
                    BigSquare1,
                    BigSquare2,
                    GREEN,
                    1
            );
            Imgproc.circle(
                    input,
                    new Point(BigSquarePointX, BigSquarePointY),
                    2,
                    GREEN,
                    1
            );
        }
        if (ring1 == 0) {
            Imgproc.rectangle(
                    input,
                    SmallSquare1,
                    SmallSquare2,
                    GREEN,
                    1
            );
            Imgproc.circle(
                    input,
                    new Point(SmallSquarePointX, SmallSquarePointY),
                    2,
                    GREEN,
                    1
            );
        }

        return input;
    }
}
}

