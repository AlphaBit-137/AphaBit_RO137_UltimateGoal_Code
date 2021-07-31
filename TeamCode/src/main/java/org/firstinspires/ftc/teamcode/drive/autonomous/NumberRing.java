package org.firstinspires.ftc.teamcode.drive.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

public class NumberRing extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    public static int ring_1=0;
    public static int ring_4=0;

    OpenCvWebcam webcam;
    HardwareMap hwMap = null;

    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void init(HardwareMap ahwMAp){
        hwMap = ahwMAp;
        int cameraMonitorViewId = hwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.getPackageName());
        webcam = (OpenCvWebcam) hwMap.get(WebcamName.class, "Webcam 1");
        webcam.openCameraDevice();
        webcam.setPipeline(new StagePipeline());
        webcam.startStreaming(320,240, OpenCvCameraRotation.UPRIGHT);
    }

    public void stopCamera(HardwareMap ahwMap){
        webcam.stopStreaming();
    }

    static class StagePipeline extends OpenCvPipeline{

        // Working Mat variables
        Mat YCrCb = new Mat(); // This will store the whole YCrCb channel
        Mat Cb = new Mat(); // This will store the Cb Channel (part from YCrCb)
        Mat tholdMat = new Mat(); // This will store the threshold

        public Point BigSquare1 = new Point(1, 177);
        public Point BigSquare2 = new Point(90, 216);

        public Point SmallSquare1 = new Point(90, 200);
        public Point SmallSquare2 = new Point(1, 180);

        @Override
        public Mat processFrame(Mat input) {

            Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_BGR2YCrCb);
            Core.extractChannel(YCrCb, Cb, 2);
            Imgproc.threshold(Cb, tholdMat, 134, 255, Imgproc.THRESH_BINARY_INV);

            int BigSquarePointX = (int) ((BigSquare1.x + BigSquare2.x) / 2);
            int BigSquarePointY = (int) ((BigSquare1.y + SmallSquare1.y) / 2);

            int SmallSquarePointX = (int) ((SmallSquare1.x + SmallSquare2.x) / 2);
            int SmallSquarePointY = (int) ((SmallSquare1.y + SmallSquare2.y) / 2);

            double[] bigSquarePointValues = tholdMat.get(BigSquarePointY, BigSquarePointX);
            double[] smallSquarePointValues = tholdMat.get(SmallSquarePointY, SmallSquarePointX);

            ring_4 = (int) bigSquarePointValues[0];
            ring_1 = (int) smallSquarePointValues[0];

            return input;
        }
    }
}
