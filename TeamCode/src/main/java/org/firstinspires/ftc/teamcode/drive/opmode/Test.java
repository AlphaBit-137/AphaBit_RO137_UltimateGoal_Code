
package org.firstinspires.ftc.teamcode.drive.opmode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.drive.structure.Intake;
import org.firstinspires.ftc.teamcode.drive.structure.Outtake;

@TeleOp(name = "Test", group = "Linear Opmode")
public class Test extends LinearOpMode {

    //Daclararea motoarelor
    public DcMotor BackLeftMotor = null;
    public DcMotor FrontRightMotor = null;
    public DcMotor FrontLeftMotor = null;
    public DcMotor BackRightMotor = null;
    private ElapsedTime runtime = new ElapsedTime();


    //Declararea claselor
    Intake intake = new Intake();
    Outtake outtake = new Outtake();

    Modes SpeedModes = Modes.FAST;

    enum Modes{
        FAST,
        SLOW,
        MEDIUM,
    }

    @Override
    public void runOpMode() throws InterruptedException {


        BackLeftMotor = hardwareMap.get(DcMotor.class, "Back_Left");
        FrontRightMotor = hardwareMap.get(DcMotor.class, "Front_Right");
        FrontLeftMotor = hardwareMap.get(DcMotor.class, "Front_Left");
        BackRightMotor = hardwareMap.get(DcMotor.class, "Back_Right");


        BackLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        FrontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotor.Direction.REVERSE);

        BackLeftMotor.setPower(0);
        FrontRightMotor.setPower(0);
        FrontLeftMotor.setPower(0);
        BackRightMotor.setPower(0);

        BackLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        runtime.reset();
        waitForStart();

        intake.init(hardwareMap);
        outtake.init(hardwareMap);

        while (opModeIsActive()){

            //Initiallizam variabilele
            double Front, Turn, Sum, Diff, Side, Drive1, Drive2, Drive3, Drive4;

            //Primirea datelor de la joystick-uri
            Front = gamepad1.left_stick_y;
            Turn = gamepad1.right_stick_x;
            Side = gamepad1.left_stick_x;

            if (gamepad1.dpad_up)
                FrontRightMotor.setPower(1.0);
            else
                FrontRightMotor.setPower(0);

            if (gamepad1.dpad_right)
                FrontLeftMotor.setPower(1.0);
            else
                FrontLeftMotor.setPower(0);

            if (gamepad1.dpad_down)
                BackLeftMotor.setPower(1.0);
            else
                BackLeftMotor.setPower(0);

            if (gamepad1.dpad_left)
                BackRightMotor.setPower(1.0);
            else
                BackRightMotor.setPower(0);

            //Calcularea puterii redate motoarelor
            if (SpeedModes == Modes.FAST)
            {
                Sum = Range.clip(Front + Side, -1.0, 1.0);
                Diff = Range.clip(Front - Side, -1.0, 1.0);

                Drive1 = Range.clip(Sum - 2*Turn, -1.0, 1.0);
                Drive2 = Range.clip(Sum + 2*Turn, -1.0, 1.0);
                Drive3 = Range.clip(Diff - 2*Turn, -1.0, 1.0);
                Drive4 = Range.clip(Diff + 2*Turn, -1.0, 1.0);

                MS(Drive1, Drive2, Drive3, Drive4);
            }
            if (SpeedModes == Modes.SLOW)
            {
                Sum = Range.clip(Front + Side, -0.3, 0.3);
                Diff = Range.clip(Front - Side, -0.3, 0.3);

                Drive1 = Range.clip(Sum - 2*Turn, -0.3, 0.3);
                Drive2 = Range.clip(Sum + 2*Turn, -0.3, 0.3);
                Drive3 = Range.clip(Diff - 2*Turn, -0.3, 0.3);
                Drive4 = Range.clip(Diff + 2*Turn, -0.3, 0.3);

                MS(Drive1, Drive2, Drive3, Drive4);
            }
            if(SpeedModes==Modes.MEDIUM)
            {
                Sum = Range.clip(Front + Side, -0.7, 0.7);
                Diff = Range.clip(Front - Side, -0.7, 0.7);

                Drive1 = Range.clip(Sum - 2*Turn, -0.7, 0.7);
                Drive2 = Range.clip(Sum + 2*Turn, -0.7, 0.7);
                Drive3 = Range.clip(Diff - 2*Turn, -0.7, 0.7);
                Drive4 = Range.clip(Diff + 2*Turn, -0.7, 0.7);

                MS(Drive1, Drive2, Drive3, Drive4);
            }

            if (gamepad1.a)
                SpeedModes = Modes.MEDIUM;
            if (gamepad1.b)
                SpeedModes = Modes.SLOW;
            if (gamepad1.y)
                SpeedModes= Modes.FAST;

            //Intake
            if(gamepad2.left_bumper){
                intake.switchToIN();
            } else if (gamepad2.right_bumper) {
                intake.switchToOUT();
            }else{
                intake.switchToSTOP();
            }

            //Outtake
            if (gamepad2.a){
                outtake.switchToOUT();
            }
            else {
                outtake.switchToSTOP();
            }

          /* if (gamepad2.b){
                outtake.switchToREVERSE();
            }
            else{
                outtake.switchToSTOP();
            }*/

            //telemetry.addData("Motors", "BackLeft (%.2f), FrontRight (%.2f), FrontLeft (%.2f), BackRight (%.2f)", Drive1, Drive2, Drive3, Drive4);
            telemetry.addData("Informatie:", "Atentie! Programul a fost sting.");

            //Chasis
            if (SpeedModes == Modes.FAST)
                telemetry.addData("Chasis", "FAST");
            if (SpeedModes == Modes.SLOW)
                telemetry.addData("Chasis", "SLOW");
            if (SpeedModes == Modes.MEDIUM)
                telemetry.addData("Chasis", "MEDIUM");

            //Intake
            if(intake.RobotIntake == Intake.IntakeModes.IN){
                telemetry.addData("Intake", "IN");
            }
            if(intake.RobotIntake == Intake.IntakeModes.OUT){
                telemetry.addData("Intake", "OUT");
            }
            if(intake.RobotIntake == Intake.IntakeModes.STOP){
                telemetry.addData("Intake", "STOP");
            }

            //Outtake
            if(outtake.RobotOuttake == Outtake.OuttakeModes.OUT){
                telemetry.addData("Ottake", "OUT");
            }
            if(outtake.RobotOuttake == Outtake.OuttakeModes.STOP){
                telemetry.addData("Ottake", "STOP");
            }

            intake.update();
            outtake.update();
            telemetry.update();

        }

    }

    void MS(double x1, double x2, double x3, double x4) {
        BackLeftMotor.setPower(x1);
        FrontRightMotor.setPower(x2);
        FrontLeftMotor.setPower(x3);
        BackRightMotor.setPower(x4);
    }

}
