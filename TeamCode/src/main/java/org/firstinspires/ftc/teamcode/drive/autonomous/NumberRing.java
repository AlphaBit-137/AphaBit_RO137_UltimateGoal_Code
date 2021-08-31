package org.firstinspires.ftc.teamcode.drive.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

public class NumberRing extends LinearOpMode {

    public static Telemetry telemetry;
    private ElapsedTime runtime = new ElapsedTime();
    public static double Big_percent, Small_percent;

    OpenCvWebcam webcam;
    HardwareMap hwMap = null;

    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void init(HardwareMap ahwMAp){
        hwMap = ahwMAp;
        int cameraMonitorViewId = hwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hwMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
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

        static final Rect BIG_ROI = new Rect(
                new Point (1, 177),
                new Point (90, 216)
        );

        static final Rect SMALL_ROI = new Rect(
                new Point (90, 200),
                new Point (1, 180)
        );

        Scalar BLACK = new Scalar(0, 0, 0);

        @Override
        public Mat processFrame(Mat input) {

            Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_BGR2YCrCb);
            Core.extractChannel(YCrCb, Cb, 2);
            Imgproc.threshold(Cb, tholdMat, 134, 255, Imgproc.THRESH_BINARY_INV);

            int BigSquarePointX = (int) ((BigSquare1.x + BigSquare2.x) / 2);
            int BigSquarePointY = (int) ((BigSquare1.y + SmallSquare1.y) / 2);

            int SmallSquarePointX = (int) ((SmallSquare1.x + SmallSquare2.x) / 2);
            int SmallSquarePointY = (int) ((SmallSquare1.y + SmallSquare2.y) / 2);

         //   double[] bigSquarePointValues = tholdMat.get(BigSquarePointY, BigSquarePointX);
         //   double[] smallSquarePointValues = tholdMat.get(SmallSquarePointY, SmallSquarePointX);

         //   ring_4 = (int) bigSquarePointValues[0];
         //   ring_1 = (int) smallSquarePointValues[0];

            Mat Big = tholdMat.submat(BIG_ROI);
            Mat Small = tholdMat.submat(SMALL_ROI);

            double big_value = Core.sumElems(Big).val[0] / BIG_ROI.area() / 255;
            double small_value = Core.sumElems(Small).val[0] / SMALL_ROI.area() / 255;

            Big.release();
            Small.release();

            Big_percent = Math.round(big_value*100);
            Small_percent = Math.round(small_value*100);

            Imgproc.rectangle(input, BigSquare1, BigSquare2, BLACK);
            Imgproc.rectangle(input, SmallSquare1, SmallSquare2, BLACK);

            return input;
        }
    }
}
